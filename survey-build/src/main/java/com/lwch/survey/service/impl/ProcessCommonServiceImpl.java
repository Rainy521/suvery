package com.lwch.survey.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.service.ProcessCommonService;
import com.lwch.survey.utils.JC;
import com.lwch.survey.utils.TimeUtils;
import com.lwch.survey.utils.TimeUtils.TimeFormat;

import redis.clients.jedis.Jedis;

@Service
public class ProcessCommonServiceImpl implements ProcessCommonService {
    
    @Autowired
    ProcessStatusMapper processStatusMapper;
    
    @Autowired
    ToolUsersMemberMapper toolUsersMemberMapper;
    
    @Autowired
    JC jc;
    

    @Override
    public ProcessStatus statusByid(String id) {
        return processStatusMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public Map<String, String> statusByids(List<String> statusIds) {
        if (CollectionUtils.isEmpty(statusIds)) {
            return Collections.emptyMap();
        }
        
        ProcessStatusExample example = new ProcessStatusExample();
        example.createCriteria().andIdIn(statusIds);
        
        return processStatusMapper.selectByExample(example).stream().collect(Collectors.toMap(ProcessStatus::getId, ProcessStatus::getStatus));
    }

    @Override
    public String generate(String busName) {
        
        String date = TimeUtils.getCurrentDatetime(TimeUtils.TimeFormat.SHORT_DATE_PATTERN_NONE);
 
        long expire = TimeUtils.getTimestampOfDateTime(TimeUtils.parseTime(date + " 23:59:59", TimeFormat.LONG_DATE_PATTERN_NONE));
 
        String key = SERIAL_NUMBER  + busName + date;
        
        Long incr = 0L;
        
        try(Jedis jedis = jc.getJedisPoolResource()){
            Boolean exists = jedis.exists(key);
            
            incr = jedis.incr(key);
     
            //设置过期时间
            if(!exists){
                jedis.pexpireAt(key,expire);
            }
        }
 
        //默认编码需要5位，位数不够前面补0
        String formattNum = String.format("%02d", incr);
        if(incr >= 99){
        	formattNum = String.format("%03d", incr);
        }else if(incr >= 999){
        	formattNum = String.format("%04d", incr);
        }else if(incr >= 9999){
        	formattNum = String.format("%05d", incr);
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append(busName).append(date).append(formattNum);
 
        return sb.toString();
    }
}
