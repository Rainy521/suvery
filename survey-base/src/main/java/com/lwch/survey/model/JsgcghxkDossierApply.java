package com.lwch.survey.model;

import java.util.Date;

import com.lwch.survey.pojo.JsgcghxkDossier;

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
public class JsgcghxkDossierApply {
	
    private Integer id;

    private Integer jdid;

    private Integer state;

    private String fileId;

    private String usrName;

    private Date createTime;

    @Builder.Default
    private JsgcghxkDossier dossier = new JsgcghxkDossier();
}