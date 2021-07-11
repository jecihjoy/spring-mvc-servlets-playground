package com.jecihjoy.APlusDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet", initParams = @WebInitParam(name = "URL", value = "https://www.weatherservice.com/"))
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login Init Params " + getServletConfig().getInitParameter("URL"));
        String html = "<html><h2>Please Login</h2></html";
        response.getWriter().write(html);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/html/login.html");
        dispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
