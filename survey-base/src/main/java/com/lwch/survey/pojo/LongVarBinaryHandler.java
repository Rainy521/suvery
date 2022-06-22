package com.lwch.survey.pojo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class LongVarBinaryHandler implements TypeHandler<byte[]>{
	
	public LongVarBinaryHandler(){

    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, byte[] bytes, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public byte[] getResult(ResultSet resultSet, String s) throws SQLException {
        byte[] result = resultSet.getBytes(s);
        return result;
    }

    @Override
    public byte[] getResult(ResultSet resultSet, int i) throws SQLException {
        byte[] result = resultSet.getBytes(i);
        return result;
    }

    @Override
    public byte[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        return new byte[0];
    }
}
