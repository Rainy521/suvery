package com.lwch.survey.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class JdbcPaginationHelper<T> {

    public Page<T> fetchPage(final JdbcTemplate jdbcTemplate, final String countSql, final String dataSql, final Object[] args,
            final String condition, final int pageNo, final int pageSize, final String orderBy, final String order, final RowMapper<T> rowMapper) {
        
        final String where = " where 1 = 1";
        final int rowCount = jdbcTemplate.queryForObject(countSql + where + condition, args, Integer.class);
        
        final Page<T> page = new Page<>();
        page.setPageNo(pageNo);
        page.setTotalCount(rowCount);
        page.setPageSize(pageSize);
        
        final int startRow = (pageNo - 1) * pageSize;
        jdbcTemplate.query(dataSql + where + condition + Page.ORDER + orderBy + " " + order, args, new ResultSetExtractor<Page<T>>() {
            public Page<T> extractData(ResultSet rs) throws SQLException, DataAccessException {
                final List<T> pageItems = page.getResult();
                int currentRow = 0;
                while (rs.next() && currentRow < startRow + pageSize) {
                    if (currentRow >= startRow) {
                        pageItems.add(rowMapper.mapRow(rs, currentRow));
                    }
                    currentRow++;
                }
                
                return page;
            }
        });
        
        return page;
    }
}