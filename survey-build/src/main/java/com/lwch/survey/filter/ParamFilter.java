package com.lwch.survey.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.lwch.survey.utils.MAPIHttpServletRequestWrapper;


@Component("paramFilter")
public class ParamFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            String contentType = request.getContentType();

            if (contentType == null || contentType.toLowerCase().contains("json")) {
                requestWrapper = new MAPIHttpServletRequestWrapper((HttpServletRequest) request);
            }
        }

        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response); // 替换！
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}