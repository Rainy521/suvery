package com.lwch.survey.utils;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

public class ExcelUtils {
    
    public static <T> void listToExcel (Map<String, String> fields, List<T> list, HttpServletResponse response) throws IOException, IllegalAccessException, InvocationTargetException, ParseException {
        if(CollectionUtils.isEmpty(list)){
            throw new RuntimeException("没有要导出的数据");
        }

        try (ByteArrayOutputStream os = new ByteArrayOutputStream();){
            
            ExcelUtils.exportExcelData(fields, list).write(os);
            
            DownloadUtils.download("example.xlsx", os.toByteArray(), response);
        }catch (RuntimeException e) {
            throw new RuntimeException("导出Excel失败");
        }
    }

    @SuppressWarnings("deprecation")
    private static <T> XSSFWorkbook exportExcelData(Map<String, String> fieldMap, List<T> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        for (int j = 0; j < list.size(); j++) {
            T t = list.get(j);
            
            if(j == 0){
                makeExcelHead(workbook, fieldMap.values().stream().toArray(String[]::new));
            }

            XSSFRow rowData = sheet.createRow(j + 1);
            String[] fields = fieldMap.keySet().stream().toArray(String[]::new);
            for(int k = 0; k < fields.length; k++){
                XSSFCellStyle styleData = workbook.createCellStyle();
                styleData.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                styleData.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                
                PropertyDescriptor obj = BeanUtils.getPropertyDescriptor(t.getClass(), fields[k]);
                XSSFCell cellData = rowData.createCell(k);
                
                Method readMethod = obj.getReadMethod();
                
                if(readMethod.getReturnType() == Date.class){
                    styleData.setDataFormat(workbook.createDataFormat().getFormat("yyyy/m/d h:mm"));
                    cellData.setCellValue((Date) readMethod.invoke(t));
                }else{
                    styleData.setDataFormat(0);
                    cellData.setCellValue(String.valueOf(readMethod.invoke(t)));
                }
                
                cellData.setCellStyle(styleData);
            }
        }

        return workbook;
    }

    public static void makeExcelHead(XSSFWorkbook workbook, String[] titles){
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow rowField = sheet.createRow(0);
        XSSFCellStyle styleField = createStyle(workbook, (short)8);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = rowField.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(styleField);
        }
    }

    @SuppressWarnings("deprecation")
    private static XSSFCellStyle createStyle(XSSFWorkbook workbook, short fontSize){
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(fontSize);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
        return style;
    }
    
    /** 
     * @MethodName          : excelToList 
     * @Description             : 将Excel转化为List 
     * @param in                    ：承载着Excel的输入流 
     * @param entityClass       ：List中对象的类型（Excel中的每一行都要转化为该类型的对象） 
     * @param fieldMap          ：Excel中的中文列头和类的英文属性的对应关系Map 
     * @param uniqueFields  ：指定业务主键组合（即复合主键），这些列的组合不能重复 
     * @return                      ：List 
     * @throws ExcelException 
     */  
    public static <T>  List<T>  excelToList(
            InputStream in,
            Class<T> entityClass,
            Map<String, String> fieldMap
            ) throws Exception{

        //定义要返回的list
        List<T> resultList=new ArrayList<>();

        try(XSSFWorkbook workbook = new XSSFWorkbook(in)){
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow firstRow = sheet.getRow(0);

            String[] excelFieldNames = new String[firstRow.getLastCellNum()];

                //获取Excel中的列名
            for(int i=0; i< excelFieldNames.length; i++){
                excelFieldNames[i] = firstRow.getCell(i).getStringCellValue();
            }

            //判断需要的字段在Excel中是否都存在  
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for(String cnName : fieldMap.keySet()){
                if(!excelFieldList.contains(fieldMap.get(cnName))){
                    isExist = false;
                    break;
                }
            }

            //如果有列名不存在，则抛出异常，提示错误 
            if(!isExist){
                throw new RuntimeException("Excel中缺少必要的字段，或字段名称有误");
            }

            //将列名和列号放入Map中,这样通过列名就可以拿到列号 
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<>();
            for(int i = 0;i < excelFieldNames.length; i++){  
                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
            }

            //将sheet转换为list
            for(int i = 1; i < sheet.getLastRowNum() + 1; i++){
                //新建要转换的对象 
                T entity = entityClass.newInstance();

                //给对象中的字段赋值
                for(Entry<String, String> entry : fieldMap.entrySet()){
                    //获取中文字段名 
                    String cnNormalName = entry.getKey();
                    
                    //根据中文字段名获取列号
                    int col = colMap.get(fieldMap.get(cnNormalName));

                    XSSFCell cell = sheet.getRow(i).getCell(col);
                    
                    if(cell == null){
                        continue;
                    }
                    
                    //给对象赋值
                    setFieldValueByName(cnNormalName, cell, entity);
                }

                resultList.add(entity);
            }
        }

        return resultList;
    }
    
    /** 
     * @MethodName  : setFieldValueByName 
     * @Description : 根据字段名给对象的字段赋值 
     * @param fieldName  字段名 
     * @param fieldValue    字段值 
     * @param o 对象
     */
    private static void setFieldValueByName(String fieldName, XSSFCell cell, Object o) throws Exception{
          
        Field field = getFieldByName(fieldName, o.getClass());
        if(field != null){
            field.setAccessible(true);
            //获取字段类型  
            Class<?> fieldType = field.getType();
              
            //根据字段类型给字段赋值  
            if (String.class == fieldType) {
                field.set(o, String.valueOf(cell.getStringCellValue()));
            } else if ((Integer.TYPE == fieldType)
                    || (Integer.class == fieldType)) {
                field.set(o, Integer.parseInt(cell.getRawValue()));
            } else if ((Long.TYPE == fieldType)
                    || (Long.class == fieldType)) {
                field.set(o, Long.valueOf(cell.getRawValue()));
            } else if ((Float.TYPE == fieldType)
                    || (Float.class == fieldType)) {
                field.set(o, Float.valueOf(cell.getRawValue()));
            } else if ((Short.TYPE == fieldType)
                    || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(cell.getRawValue()));
            } else if ((Double.TYPE == fieldType)
                    || (Double.class == fieldType)) {
                field.set(o, Double.valueOf(cell.getNumericCellValue()));
            } else if(Date.class == fieldType){
                field.set(o, cell.getDateCellValue());
            } else{
                field.set(o, cell.getRawValue());
            }
        }else{
            throw new RuntimeException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
        }
    }
    
    /** 
     * @MethodName  : getFieldByName 
     * @Description : 根据字段名获取字段 
     * @param fieldName 字段名 
     * @param clazz 包含该字段的类 
     * @return 字段 
     */
    private static Field getFieldByName(String fieldName, Class<?>  clazz){
        //拿到本类的所有字段  
        Field[] selfFields=clazz.getDeclaredFields();

        //如果本类中存在该字段，则返回
        for(Field field : selfFields){
            if(field.getName().equals(fieldName)){
                return field;
            }
        }

        //否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz=clazz.getSuperclass();
        if(superClazz!=null  &&  superClazz !=Object.class){
            return getFieldByName(fieldName, superClazz);
        }
          
        //如果本类和父类都没有，则返回空  
        return null;
    }

}