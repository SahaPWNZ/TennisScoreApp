package com.sahapwnz.tennisscoreapp.filter;

import com.sahapwnz.tennisscoreapp.dto.ErrorResponseDTO;
import com.sahapwnz.tennisscoreapp.exceptions.CastomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class ExceptionsHandler extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) res;
        try {
            super.doFilter(req, res, chain);
        } catch (CastomException e) {
            resp.setStatus(e.getCODE_OF_EXCEPTION());
            resp.getWriter().print(new ErrorResponseDTO(e.getMessage()));
            super.doFilter(req, res, chain);
        }

    }
}
