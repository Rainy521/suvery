package com.lwch.survey.dao.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.lwch.survey.dao.type.IntEnum;

public class IntEnumTypeHandler<E extends Enum<E> & IntEnum<E>> extends BaseTypeHandler<IntEnum<E>> {
    private Class<IntEnum<E>> type;

    public IntEnumTypeHandler(Class<IntEnum<E>> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
    }

    private IntEnum<E> convert(int value) {
        IntEnum<E>[] objs = type.getEnumConstants();
        for (IntEnum<E> em : objs) {
            if (em.getIntValue() == value) {
                return em;
            }
        }
        return null;
    }

    @Override
    public IntEnum<E> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getInt(columnName));
    }

    @Override
    public IntEnum<E> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getInt(columnIndex));
    }

    @Override
    public IntEnum<E> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getInt(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IntEnum<E> enumObj, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, enumObj.getIntValue());
    }
}
