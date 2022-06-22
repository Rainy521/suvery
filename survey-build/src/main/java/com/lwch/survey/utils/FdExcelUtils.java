package com.lwch.survey.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lwch.survey.model.ApplyBuild;
import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.pojo.ExcelDataVO;

public class FdExcelUtils {

	private static Logger logger = Logger.getLogger(FdExcelUtils.class.getName()); // 日志打印类

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static ApplyProject readExcel(String fileName) {
    	
    	// 获取Excel后缀名
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        // 获取Excel文件
        File excelFile = new File(fileName);
        if (!excelFile.exists()) {
            logger.warning("指定的Excel文件不存在！");
            return null;
        }
        
        // 获取Excel工作簿
        try(FileInputStream inputStream = new FileInputStream(excelFile);
        		Workbook workbook = getWorkbook(inputStream, fileType);){

            // 读取excel中的数据
            List<ExcelDataVO> resultDataList = parseExcel(workbook);

            return convertExcelDataToApply(resultDataList);
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } 
		/*
		 * //Workbook workbook = null;
        	//FileInputStream inputStream = null;
		 * finally { try { if (null != workbook) { workbook.close(); } if (null !=
		 * inputStream) { inputStream.close(); } } catch (Exception e) {
		 * logger.warning("关闭数据流出错！错误信息：" + e.getMessage()); return null; } }
		 */
    }

    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<ExcelDataVO> parseExcel(Workbook workbook) {
       List<ExcelDataVO> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.warning("解析Excel，在第一行没有读取到任何数据！");
                continue;
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }

                ExcelDataVO resultData = convertRowToData(row);
                if (null == resultData) {
                    logger.warning("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }

    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
	private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:   //数字
            	if("yyyy/mm;@".equals(cell.getCellStyle().getDataFormatString()) 
            			|| "m/d/yy".equals(cell.getCellStyle().getDataFormatString())
            	        || "yy/m/d".equals(cell.getCellStyle().getDataFormatString()) 
            	        || "mm/dd/yy".equals(cell.getCellStyle().getDataFormatString())
            	        || "dd-mmm-yy".equals(cell.getCellStyle().getDataFormatString())
            	        || "yyyy/m/d".equals(cell.getCellStyle().getDataFormatString())){
            		returnValue = new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
            		break;
            	}
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }

    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     *
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static ExcelDataVO convertRowToData(Row row) {
        ExcelDataVO resultData = new ExcelDataVO();

        Cell cell;
        int cellNum = 0;
        // 获取名称
        cell = row.getCell(cellNum++);
        String name = convertCellValueToString(cell);
        resultData.setName(name);
        
        cell = row.getCell(cellNum++);
        // 获取值
        String value = convertCellValueToString(cell);
        resultData.setValue(value);
        
        cell = row.getCell(cellNum++);
        // 获取值
        String remake = convertCellValueToString(cell);
        resultData.setRemake(remake);
        
        
		/*
		 * // 获取年龄 cell = row.getCell(cellNum++); String ageStr =
		 * convertCellValueToString(cell); if (null == ageStr || "".equals(ageStr)) { //
		 * 年龄为空 resultData.setAge(null); } else {
		 * resultData.setAge(Integer.parseInt(ageStr)); } // 获取居住地 cell =
		 * row.getCell(cellNum++); String location = convertCellValueToString(cell);
		 * resultData.setLocation(location); // 获取职业 cell = row.getCell(cellNum++);
		 * String job = convertCellValueToString(cell); resultData.setJob(job);
		 */

        return resultData;
    }
    
    public static ApplyProject convertExcelDataToApply(List<ExcelDataVO> vos) {
    	ApplyProject project = new ApplyProject();
		ApplyBuild build = new ApplyBuild();
		
		
    	for(ExcelDataVO x : vos) {
			if (null != x.getName() && !("".equals(x.getName()))) {
				switch (x.getName()) {
				case "项目名称":
					verifColumn(x);
					project.setProjectName(x.getValue());
					break;
				case "受理单位":
					verifColumn(x);
					project.setSldw(x.getValue());
					break;
				case "建设单位":
					verifColumn(x);
					project.setProjectFzr(x.getValue());
					break;
				case "证件号码":
					verifColumn(x);
					project.setSlzjhm(x.getValue());
					break;
				case "受理联系人":
					verifColumn(x);
					project.setSllxr(x.getValue());
					break;
				case "联系人":
					verifColumn(x);
					project.setLxr(x.getValue());
					break;
				case "联系电话":
					verifColumn(x);
					project.setLxdh(x.getValue());
					break;
				case "受理联系电话":
					verifColumn(x);
					project.setSldh(x.getValue());
					break;
				case "项目坐落":
					verifColumn(x);
					project.setProjectXmzl(x.getValue());
					break;
				case "备注":
					project.setProjectGk(x.getValue());
					break;
				case "测绘类型":
					verifColumn(x);
					build.setChlx(x.getValue());
					project.setProjectType(x.getValue());
					break;
				case "项目信用代码":
					verifColumn(x);
					project.setCreditCode(x.getValue());
					break;
				case "受理信用代码":
					verifColumn(x);
					project.setSlcreditCode(x.getValue());
					break;
				case "幢号":
					verifColumn(x);
					build.setLpzh(x.getValue());
					break;
				case "不动产权证号":
					verifColumn(x);
					build.setBdcqzh(x.getValue());
					break;
				case "规划许可证号":
					verifColumn(x);
					build.setGhxkzh(x.getValue());
					break;
				case "建筑结构":
					build.setJzjg(x.getValue());
					break;
				case "总层数":
					build.setZcs(numberExcption(x));
					break;
				case "地下层数":
					build.setDxcs(numberExcption(x));
					break;
				case "地上层数":
					build.setDscs(numberExcption(x));
					break;
				case "规划用途":
					build.setGhyt(x.getValue());
					break;
				case "总建筑面积":
					try {
						build.setZjzmj(x.getValue()==null?0:Double.valueOf(x.getValue()));
					} catch (NumberFormatException e) {
						throw new RuntimeException(x.getName() + "数字转换错误,请检查");
					}
					break;
				default:
					break;
				}
			}
    	}
    	project.setApplyBuild(build);
    	return project;
    }
    
    private static Integer numberExcption(ExcelDataVO x) {
    	try {
			return x.getValue()==null?0:Integer.valueOf(x.getValue());
		} catch (NumberFormatException e) {
			throw new RuntimeException(x.getName() + "数字转换错误,请检查");
		}
    }
    
    private static void verifColumn(ExcelDataVO column) {
    	if(column.getValue() == null || column.getValue().equals("")) {
    		throw new RuntimeException(column.getName() + "字段不能为空");
		}
    }

}