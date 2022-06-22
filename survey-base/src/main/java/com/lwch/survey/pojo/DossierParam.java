package com.lwch.survey.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DossierParam {

	private String applyId;
	
	private String proName;
	
	private String ghno;
	
	private String jsdw;
	
	private String xmzl;
	
	private String chlx;
	
	private String lpzh;
	
	private String beginGdrq;
	
	private String endGdrq;
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	private String jsgcghxkzNo;
	
	private String jsdwmc;
	
	private Integer startPage;
	
	private Integer endPage;
	
	private String loginUser;
	
}
