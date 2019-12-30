package com.grizzly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        String uri = request.getRequestURI();
        System.out.println("访问链接:" + uri);
//		chain.doFilter(request, response);
        String[] str = uri.split("/");
        if (str.length == 2) {
            chain.doFilter(request, response);
        } else if (str.length == 4 && str[2].equals("admin") && str[3].equals("login.jsp")) {
            chain.doFilter(request, response);
        } else {
            if (str[2].equals("admin")) {
                if (str.length == 4 && str[3].equals("login.do")) {
                    chain.doFilter(request, response);
                } else if (session.getAttribute("user") == null) {
//					request.getRequestDispatcher("login.jsp").forward(request, response);
                    response.sendRedirect("login.jsp");
                } else {
                    // pass the request along the filter chain
                    chain.doFilter(request, response);
                }
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
