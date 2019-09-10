package org.example.servletfilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns="/*")
public class SampleFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(SampleFilter.class);

    public SampleFilter() {
        log.info("SampleFilter was loaded.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("doFilter() was called.");
        chain.doFilter(request, response);
    }
}
