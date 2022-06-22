package com.lwch.survey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class SQLController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostMapping()
    public Map<String, Object> query(@RequestBody String sql) {
        String[] columns = null;
        List<String[]> rows = new ArrayList<>();
        
        try{
            SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        
            SqlRowSetMetaData sqlRowSetMetaData = sqlRowSet.getMetaData();
            
            int columnCount = sqlRowSetMetaData.getColumnCount();
            
            columns = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columns[i] = sqlRowSetMetaData.getColumnLabel(i + 1);
            }
            
            while (sqlRowSet.next()) {
                String[] row = new String[columnCount]; 
                for (int i = 0; i < columnCount; i++) {
                    row[i] = sqlRowSet.getString(i + 1);
                }
                
                rows.add(row);
            }
        }catch(DataAccessException ex){
            throw new RuntimeException("SQL语句有误,请核对SQL语句!");
        }
        
        Map<String, Object> map = new HashMap<>();
        map.put("heads", columns);
        map.put("rows", rows);
        
        return map;
    }
}
