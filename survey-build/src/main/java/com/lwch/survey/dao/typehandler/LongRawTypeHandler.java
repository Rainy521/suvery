package com.lwch.survey.dao.typehandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongRawTypeHandler extends BaseTypeHandler<byte[]> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LongRawTypeHandler.class);

    @Override
    public byte[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
    	
    	ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
	    InputStream inputStream = rs.getBinaryStream(columnName);
	    
    	byte[] buff = new byte[1024];
    	int rc = 0;
    	
    	try {
			while ((rc = inputStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc); 
			}
		} catch (IOException e) {
			LOGGER.error("stream write error!" + e.getMessage());
		}
	    	
    	return swapStream.toByteArray();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, byte[] parameter, JdbcType jdbcType)
            throws SQLException {
        super.setParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public byte[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return super.getResult(rs, columnIndex);
    }

    @Override
    public byte[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return super.getResult(cs, columnIndex);
    }
}
