package com.lwch.survey.pojo;

import com.lwch.survey.model.JsgcghxkDossierExamine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsgcghxkParam {

	private Integer examineId;
	
	private String jsgcghxkzNo;
	
	private String applyUsername;
	
	private Integer isExist;
	
	private String jsdwmc;
	
	private String proName;
	
	private String lpzh;
	
	private Integer state;
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	@Builder.Default
	private JsgcghxkDossierExamine examine = new JsgcghxkDossierExamine();
}
