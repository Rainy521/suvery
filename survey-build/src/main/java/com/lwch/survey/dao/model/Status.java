package com.lwch.survey.dao.model;

import com.lwch.survey.dao.type.IntEnum;

public enum Status implements IntEnum<Status> {
    NORMAL(0), DELETED(1);
    
    private final int value;
    
    private Status(int value) {
        this.value = value;
    }

    @Override
    public int getIntValue() {
        return value;
    }
}
