package com.lwch.survey.listener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lwch.survey.model.Ownership;
import com.lwch.survey.service.HouseService;

@Component
public class TradingCenterScheduler {
    
    @Autowired
    private HouseService houseService;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Scheduled(cron = "0 0 9 * * ?") 
    /*@Scheduled(cron = "0 * 13 * * ?") */
    public void cleanCoupon() throws ParseException {
        List<String> list = new ArrayList<>();
        List<Ownership> ownerships = houseService.selectAllHouse();
        if(ownerships.isEmpty()){
            logger.info("交易中心暂无申请信息");
            return;
        }
        
        for(Ownership member : ownerships){
            list.add(member.getId());
        }
        
        
        
        logger.info("定时提交交易中心申请信息");
    }
}
