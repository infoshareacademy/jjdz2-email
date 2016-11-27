package com.jbd.Authorization;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/forssm.jsp")
public class AuthorizationFilter implements Filter {

    @Inject SessionData sessionData;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!sessionData.isLogged()){

            //HttpServletRequest request = (HttpServletRequest) servletRequest;
            ((HttpServletResponse) servletResponse).sendRedirect("/jbdee/Login.jsp");//?referrer=" + request.getRequestURI());
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
