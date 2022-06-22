package com.lwch.survey.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lwch.survey.pojo.CommentPojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DjchGdb {
    private Integer id;

    private String applyId;

    private String proName;

    private String proXmlz;

    private String jsdw;

    private String applyField;

    private String gdno;

    private Date updateTime;

    private Integer yxx;

    private String lcslid;

    private Integer backnum;

    private String pzxx;
    
    private List<CommentPojo> comments = new ArrayList<>();
    
    private ApplyCadastre applyCadastre = new ApplyCadastre();

}