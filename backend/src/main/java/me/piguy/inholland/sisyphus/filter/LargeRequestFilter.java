package me.piguy.inholland.sisyphus.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.java.Log;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
@Log
public class LargeRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int requestSize = servletRequest.getContentLength();
        log.info("Request size: " + requestSize);
        if (requestSize > 1000) {
            log.severe("Request size is too large");
            throw new ServletException("Request size is too large");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
