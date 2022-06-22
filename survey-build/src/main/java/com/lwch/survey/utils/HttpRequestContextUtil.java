package com.lwch.survey.utils;

import java.util.Deque;
import java.util.LinkedList;

public class HttpRequestContextUtil {

    private static ThreadLocal<Deque<String>> id;

    private static final ThreadLocal<Deque<HttpRequestContext>> httpRequestContexts = new ThreadLocal<Deque<HttpRequestContext>>() {
        protected Deque<HttpRequestContext> initialValue() {
            return new LinkedList<>();
        };
    };

    public static HttpRequestContext builder() {
        HttpRequestContext httpRequestContext = new HttpRequestContext(id.get().getLast());
        httpRequestContexts.get().addLast(httpRequestContext);
        return httpRequestContext;
    }

    public static HttpRequestContext peekLast() {
        return httpRequestContexts.get().peekLast();
    }

    public static HttpRequestContext removeLast() {
        return httpRequestContexts.get().removeLast();
    }

    public static void setId(ThreadLocal<Deque<String>> id) {
        HttpRequestContextUtil.id = id;
    }
}
