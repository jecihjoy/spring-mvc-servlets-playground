package com.jecihjoy.APlusDemo.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = "", value = ""))
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().equals(req.getContextPath() + "/RedirectServlet")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                String[] pls = {"Java", "Node js", "GraphQl", "React js"};
                request.setAttribute("pls", pls);
                req.getRequestDispatcher("/html/login.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }
}
