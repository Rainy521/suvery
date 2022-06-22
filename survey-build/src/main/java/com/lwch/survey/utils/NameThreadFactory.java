package com.lwch.survey.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NameThreadFactory implements ThreadFactory {

    private final AtomicInteger index = new AtomicInteger();
    private final String name;
    
    public NameThreadFactory(String name) {
        super();
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, name + "-" + index.get());
    }
}
