package com.lwch.survey.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class WordUtil {
    
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Bean
    public Configuration getFreeMarkerConfiguration(){
        return freeMarkerConfigurer.getConfiguration();
    }

    public File createDoc(final String templateName, final String fileName, Map<?, ?> dataMap) throws IOException{
        File file = File.createTempFile(fileName, ".doc");
        
        try(FileOutputStream out = new FileOutputStream(file);){
            
            Template template = getFreeMarkerConfiguration().getTemplate(templateName);
            template.process(dataMap, new OutputStreamWriter(out, "utf-8"));
            
            out.flush();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            file.deleteOnExit();
        }
        
        return file;
    }
    
    public File createExcel(final String templateName, final String fileName, Map<?, ?> dataMap) throws IOException{
        File file = File.createTempFile(fileName, ".xls");
        
        try(FileOutputStream out = new FileOutputStream(file);){
            
            Template template = getFreeMarkerConfiguration().getTemplate(templateName);
            template.process(dataMap, new OutputStreamWriter(out, "utf-8"));
            
            out.flush();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            file.deleteOnExit();
        }
        
        return file;
    }
}
