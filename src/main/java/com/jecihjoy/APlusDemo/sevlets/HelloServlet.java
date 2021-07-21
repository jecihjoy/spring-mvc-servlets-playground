package com.jecihjoy.APlusDemo.sevlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Username value from session: " + request.getSession().getAttribute("username"));
        if (request.getParameter("logout") != null) {
            request.getSession().invalidate();
            System.out.println("Session invalidated successfully; username " + request.getSession().getAttribute("username"));
            String[] pls = {"Java", "Node js", "GraphQl", "React js"};
            request.setAttribute("pls", pls);
            request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}