package com.lwch.survey.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 建设工程规划许可档案入库系统
 * @author Administrator
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JsgcghxkDossier {

	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 建设工程规划许可证编号
	 */
	private String jsgcghxkzNo;
	
	/**
	 * 建设单位名称
	 */
	private String jsdwmc;
	
	/**
	 * 项目名称
	 */
	private String proName;
	
	/**
	 * 幢号
	 */
	private String lpzh;
	
	/**
	 * 提交人
	 */
	private String useName;
	
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 附件id
	 */
	private String fileId;
	
	/**
	 * 提交日期
	 */
	private Date createTime;
	
	/**
	 * 图纸类型
	 */
	private String tzlx;
	
	private Integer applyId;
	private String applyName;
	private String applyFileId;
	private Integer applyState;
	private Date rkTime;
	private Date applyTime;
	
	private boolean isView;
}
