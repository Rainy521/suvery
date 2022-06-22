package com.lwch.survey.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JsgcghxkDossierExamine {
	
    private Integer id;

    private Integer jdId;

    private String jsgcghxkzNo;

    private String applyUsername;

    private Integer state;

    private Integer isExist;

    private Date createTime;
    
    private String fileId;

}