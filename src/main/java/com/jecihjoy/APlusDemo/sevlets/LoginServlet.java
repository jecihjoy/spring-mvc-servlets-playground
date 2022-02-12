package com.jecihjoy.APlusDemo.sevlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "LoginServlet", value = "/LoginServlet", initParams = @WebInitParam(name = "URL", value = "https://www.weatherservice.com/"))
public class LoginServlet extends HttpServlet {
    public static String USER_USERNAME = "jecihjoy";
    public static String USER_PASSWORD = "tomcat";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login Init Params " + getServletConfig().getInitParameter("URL"));
        String html = "<html><h2><em>  </em></h2></html";
        response.getWriter().write(html);
        String[] pls = {"Java", "Node js", "GraphQl", "React js"};
        request.setAttribute("pls", pls);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/login.jsp");

        /**Using sessions*/
        HttpSession session = request.getSession();
        List<String> otherPls = (ArrayList) session.getAttribute("otherPls");
        if (otherPls == null) {
            otherPls = new ArrayList<>();
        }
        String pl = request.getParameter("pl");
        if (request.getParameter("pl") != null) {
            otherPls.add(pl);
        }
        session.setAttribute("otherPls", otherPls);
        dispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("password", request.getParameter("password"));
        if (request.getParameter("username").equals(USER_USERNAME) && request.getParameter("password").equals(USER_PASSWORD)) {
            System.out.println("User is validated");
            request.getRequestDispatcher("/index.jsp").include(request, response);
        } else {
            String[] pls = {"Java", "Node js", "GraphQl", "React js"};
            request.setAttribute("pls", pls);
            request.getRequestDispatcher("/html/login.jsp").include(request, response);
        }
    }

}
