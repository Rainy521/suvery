package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApplyEngineering {
    private String id;

    private String proName;

    private String proXmzl;

    private Double tdsymj;

    private String tdyt;

    private String rjl;

    private String jzmd;

    private String jsdw;

    private String jsdwCode;

    private String lxr;

    private String lxdh;

    private String chdw;

    private String chdwCode;

    private String chdwlxr;

    private String chdwlxdh;

    private String remark;

    private String chlx;

    private String lpzh;

    private String bdcqzh;

    private String ghxkzh;

    private String jzjg;

    private Integer zcs;

    private Integer dscs;

    private Integer dxcs;

    private String ghyt;

    private Double zjzmj;

    private Double jrjzmj;

    private Integer jzzgd;

    private Double cg;

    private Double snwdpbg;
    
    private Double zflbg;

    private String lmsccz;

    private Date createTime;
    
    private List<FileTypeApplyMember> listFiles = new ArrayList<>();

}