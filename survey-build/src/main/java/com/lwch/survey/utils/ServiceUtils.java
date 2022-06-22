package com.lwch.survey.utils;

import com.github.pagehelper.PageHelper;
import com.lwch.survey.pojo.PageParm;

public class ServiceUtils {
    public static void startPage(PageParm pageParm) {
        if (pageParm != null) {
            PageHelper.startPage(pageParm.getPageNum(), pageParm.getPageSize(), pageParm.getOrderBy());
        }
    }
    
}
