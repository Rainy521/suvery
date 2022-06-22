package com.lwch.survey.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lwch.survey.model.Company;
import com.lwch.survey.model.CompanyExample;
import com.lwch.survey.service.CompanyService;

@Component
public class CompanyScheduler {

    @Autowired
    private CompanyService companyService;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Scheduled(cron = "0 0 9 * * ?") 
    /*@Scheduled(cron = "0 * 13 * * ?") */
    public void cleanCoupon() throws ParseException {
        List<Company>  companys = companyService.selectByExample(new CompanyExample());
        
        Date now = new Date();
        Date startDate = DateUtils.addDays(now, -30);
        
        if(!companys.isEmpty()){
            for(Company member : companys){
                String cxpiryTime = member.getExpiryTime().replace("Z", " UTC");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
                Date cxpiryTimeDate = format.parse(cxpiryTime);
                
                if(startDate.before(cxpiryTimeDate)){
                    /*需要提醒的操作*/
                }
            }
        }
        logger.info("资质到期提醒");
    }
}
