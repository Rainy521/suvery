package com.lwch.survey.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.model.Descrip;
import com.lwch.survey.model.OperationLog;
import com.lwch.survey.service.OperationLogService;
import com.lwch.survey.utils.JdbcPaginationHelper;
import com.lwch.survey.utils.Page;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);
    
    @Override
    public Map<String, Object> getOperationList(String url, int currentPage, int pageSize, String...condition) {
        
        List<Object> list = new ArrayList<>(4);
        String countSQL = "select count(*) from ";
        String querySQL = "select * from ";
        String tableName = "operation_log_";
        String where = "";
        
        tableName = getTableName(tableName, condition);
        
        countSQL += tableName;
        querySQL += tableName;
        
        if(!StringUtils.isBlank(condition[1])){
            where += " and username like ?";
            list.add("%" + condition[1] + "%");
        }
        
        if(!StringUtils.isBlank(url)){
            where += " and url like ?";
            list.add("%" + url + "%");
        }
        
        where += " and request_time between ? and ?";
        list.add(condition[2]);
        list.add(condition[3]);
        
        if(!isExist(tableName)){
            return Collections.emptyMap();
        }
        
        JdbcPaginationHelper<OperationLog> paginationHelper = new JdbcPaginationHelper<>();  
        Page<OperationLog> page = paginationHelper.fetchPage(jdbcTemplate, countSQL, querySQL, list.toArray(), where, currentPage, pageSize, "update_time", Page.DESC, new RowMapper<OperationLog>(){
            @Override
            public OperationLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                OperationLog operation = new OperationLog();
                operation.setId(rs.getString(1));
                operation.setUsername(rs.getString(2));
                operation.setUrl(rs.getString(3));
                operation.setParams(rs.getString(4));
                operation.setBody(rs.getString(5));
                operation.setRequestType(rs.getString(6));
                operation.setRequestTime(rs.getTimestamp(7));
                operation.setCost(rs.getInt(8));
                operation.setStatus(rs.getInt(9));
                operation.setResult(rs.getInt(10));
                operation.setUpdateTime(rs.getTimestamp(11));
                
                return operation;
            }
        });
        
        Map<String, Object> results = new HashMap<>();
        results.put("data", page.getResult());
        results.put("total", page.getTotalCount());
        
        return results;
    }
    
    @Override
    public Map<String, Object> getDescripList(int currentPage, int pageSize, String...condition) {
        
        List<Object> list = new ArrayList<>(4);
        String countSQL = "select count(*) from ";
        String querySQL = "select * from ";
        String tableName = "description_";
        String where = "";
        
        tableName = getTableName(tableName, condition);
        
        countSQL += tableName;
        querySQL += tableName;
        
        if(!StringUtils.isBlank(condition[1])){
            where += " and username like ?";
            list.add("%" + condition[1] + "%");
        }
        
        if(!StringUtils.isBlank(condition[2])){
            where += " and method_descrip like ?";
            list.add("%" + condition[2] + "%");
        }
        
        where += " and update_time between ? and ?";
        list.add(condition[3]);
        list.add(condition[4]);
        
        if(!isExist(tableName)){
            return Collections.emptyMap();
        }
        
        JdbcPaginationHelper<Descrip> paginationHelper = new JdbcPaginationHelper<>();  
        Page<Descrip> page = paginationHelper.fetchPage(jdbcTemplate, countSQL, querySQL, list.toArray(), where, currentPage, pageSize, "update_time", Page.DESC, new RowMapper<Descrip>(){
            @Override
            public Descrip mapRow(ResultSet rs, int rowNum) throws SQLException {
                Descrip descrip = new Descrip();
                descrip.setId(rs.getString(1));
                descrip.setUrl(rs.getString(2));
                descrip.setMethodDescrip(rs.getString(3));
                descrip.setParamsDescrip(rs.getString(4));
                descrip.setUsername(rs.getString(5));
                descrip.setUpdateTime(rs.getTimestamp(6));
                
                return descrip;
            }
        });
        
        Map<String, Object> results = new HashMap<>();
        results.put("data", page.getResult());
        results.put("total", page.getTotalCount());
        
        return results;
    }
    
    @Override
    public void createOpreationTable(String tableName) {
        if(!isExist(tableName)){
            logger.info("创建表" + tableName);
            
            StringBuilder stringBuffer = new StringBuilder("CREATE TABLE " + tableName + " ("); 
            stringBuffer.append("id              varchar(255) not null   comment 'operation id',");
            stringBuffer.append("username        varchar(128) not null   comment '用户名',");
            stringBuffer.append("url             varchar(255) not null   comment '请求路径',");
            stringBuffer.append("params          varchar(5000)           comment '请求参数',");
            stringBuffer.append("body            varchar(15000)          comment '消息体',");
            stringBuffer.append("request_type    varchar(20)  not null   comment '请求类型',");
            stringBuffer.append("request_time    timestamp(3) not null   comment '请求时间',");
            stringBuffer.append("cost            int not null            comment '请求耗时',");
            stringBuffer.append("status          int not null            comment 'status code',");
            stringBuffer.append("result          int not null            comment '结果 1:失败/0:成功',");
            stringBuffer.append("update_time     timestamp(3) not null   comment '最后更新时间',");
            stringBuffer.append("primary key (id))");
            
            jdbcTemplate.update(stringBuffer.toString());
            
            jdbcTemplate.update("create index ix_" + tableName + " on " + tableName + " (update_time)");
            
            logger.info("创建表成功" + tableName);
        }
    }
    
    @Override
    public void createDescripTable(String tableName) {
        if(!isExist(tableName)){
            logger.info("创建表" + tableName);
            
            StringBuilder stringBuffer = new StringBuilder("CREATE TABLE " + tableName + " ("); 
            stringBuffer.append("id                       varchar(255) not null      comment 'descrip id',");
            stringBuffer.append("url                      varchar(255) not null      comment '请求路径',");
            stringBuffer.append("method_descrip           varchar(2000)              comment '方法描述',");
            stringBuffer.append("params_descrip           varchar(2000)              comment '参数描述',");
            stringBuffer.append("username                 varchar(128) not null      comment '用户名',");
            stringBuffer.append("update_time              timestamp(3) not null      comment '最后更新时间',");
            stringBuffer.append("primary key (id))");
            
            jdbcTemplate.update(stringBuffer.toString());
            
            jdbcTemplate.update("create index ix_" + tableName + " on " + tableName + " (update_time)");
            
            logger.info("创建表成功" + tableName);
        }
    }
    
    @Override
    public OperationLog selectByOperationPrimaryKey(String id, String time) {
        String tableName = "operation_log_" + time;
        if(!isExist(tableName)){
            return null;
        }
        
        List<OperationLog> operations = jdbcTemplate.query("select * from " + tableName + " where id = ?", new RowMapper<OperationLog>(){
            @Override
            public OperationLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                OperationLog operation = new OperationLog();
                operation.setId(rs.getString(1));
                operation.setUsername(rs.getString(2));
                operation.setUrl(rs.getString(3));
                operation.setParams(rs.getString(4));
                operation.setBody(rs.getString(5));
                operation.setRequestType(rs.getString(6));
                operation.setRequestTime(rs.getTimestamp(7));
                operation.setCost(rs.getInt(8));
                operation.setStatus(rs.getInt(9));
                operation.setResult(rs.getInt(10));
                operation.setUpdateTime(rs.getDate(11));
                
                return operation;
            }}, new Object[]{id});
        
        if(!CollectionUtils.isEmpty(operations)){
            return operations.get(0);
        }
        
        return null;
    }

    @Override
    public Descrip selectByDescriptionPrimaryKey(String id, String time) {
        String tableName = "description_" + time;
        if(!isExist(tableName)){
            return null;
        }
        
        List<Descrip> descrips = jdbcTemplate.query("select * from " + tableName + " where id = ?", new RowMapper<Descrip>(){
            @Override
            public Descrip mapRow(ResultSet rs, int rowNum) throws SQLException {
                Descrip descrip = new Descrip();
                descrip.setId(rs.getString(1));
                descrip.setUrl(rs.getString(2));
                descrip.setMethodDescrip(rs.getString(3));
                descrip.setParamsDescrip(rs.getString(4));
                descrip.setUsername(rs.getString(5));
                descrip.setUpdateTime(rs.getDate(6));
                
                return descrip;
            }}, new Object[]{id});
    
        if(!CollectionUtils.isEmpty(descrips)){
            return descrips.get(0);
        }
        
        return null;
    }
    
    private boolean isExist(String tableName){
        try (Connection conn = jdbcTemplate.getDataSource().getConnection();){
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String[] types = {"TABLE"};
            try (ResultSet tabs = dbMetaData.getTables(null, null, tableName, types)) {
                if (tabs.next()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            logger.error("isExist failed. " + tableName, ex);
            return false;
        }
        return false;
    }
    
    private String getTableName(String tableName, String...condition){
        if(!StringUtils.isBlank(condition[0])){
            tableName += condition[0];
        }else{
            String format = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
            tableName += format;
        }
        
        return tableName;
    }
}
