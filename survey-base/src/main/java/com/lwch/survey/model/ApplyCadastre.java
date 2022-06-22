package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApplyCadastre {
    private String id;

    private String proName;

    private String proXmzl;

    private Double tdsymj;

    private String tdyt;

    private String tdsyqlx;

    private String tdsynx;

    private String jsdw;

    private String jsdwCode;

    private String lxr;

    private String lxdh;

    private String chdw;

    private String chdwCode;

    private String chdwlxr;

    private String chdwlxdh;

    private String remark;

    private Date createTime;
    
    private List<FileTypeApplyMember> listFiles = new ArrayList<>();
}