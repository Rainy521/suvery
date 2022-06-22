package com.lwch.survey.utils;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestContext {

    private final String id;

    private String action;
    private Map<String, Object> params = new HashMap<>();

    public HttpRequestContext(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public HttpRequestContext setAction(String action) {
        this.action = action;
        return this;
    }

    public HttpRequestContext putParams(String key, Object value) {
        params.put(key, value);
        return this;
    }
}
