package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lwch.survey.pojo.CommentPojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FcchGdb {
    private Integer id;
    
    private String hisId;
    
    private String zhid;

    private String applyid;

    private String proname;

    private String lpzh;

    private String chlx;

    private String xmzl;

    private String jsdw;

    private String jsdwcode;

    private String lxr;

    private String lxdh;

    private String chdw;

    private String chdwcode;

    private String chdwlxr;

    private String chdwlxdh;

    private String bdcqzh;

    private String ghxkzh;

    private String jzjg;

    private Integer zcs;

    private Integer dscs;

    private Integer dxcs;

    private String ghyt;

    private Double zmj;

    private String files;

    private Integer backnum;

    private String lspzxx;

    private String lcslid;

    private String remark;

    private Date updatetime;

    private Date applytime;
    
    private String applyDateTime;

    private String gdno;

    private Integer yxx;

    private Integer thcs;

    private String pzxx;
    
    private List<CommentPojo> comments = new ArrayList<>();
    
    private Integer datalen;
    
    private Integer originlen;
    
    private byte[] siffData;
    
    private String structCode;
    
    private String usageCode;

}