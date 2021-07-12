package com.jecihjoy.APlusDemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.MessageFormat;

public class BasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** ServletConfig Init Params */
        ServletConfig config = getServletConfig();
        System.out.println("ServletConfig Init Params = " + config.getInitParameter("web-service-url"));

        /** ServletContext Init Params */
        ServletContext context = getServletContext();
        System.out.println("ServletContext Init Params = " + context.getInitParameter("databaseUrl"));

        /** Writing the html string into a web page */
        PrintWriter out = resp.getWriter();
        String yearPassed = req.getParameter("year");
        String[] values = {"A BadAss Engineer"};
        String htmlPage = getHtmlString(req.getServletContext().getRealPath("/html/basicServlet.html"), values);
        if (yearPassed == null) {
            out.write(htmlPage);
        } else {
            out.write(htmlPage + "3. Current year " + yearPassed);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fname")+ " " +req.getParameter("lname");
        String hobby = req.getParameter("hobby");
        String[] values = {"A BadAss Engineer", name, hobby};
        String htmlContent = getHtmlString(req.getServletContext().getRealPath("/html/basicServlet.html"), values);
        resp.getWriter().write(htmlContent);
    }

    public String getHtmlString(String filePath, String[] values) throws IOException {
        /** Reads entire html file as a string */
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        StringBuffer buffer = new StringBuffer();
        while((line=br.readLine())!=null){
            buffer.append(line);
        }
        br.close();

        /** Replaces place holders with actual values */
        if (values.length>1) {
            return MessageFormat.format(buffer.toString(), values[0], values[1], values[2]);
        }
        return MessageFormat.format(buffer.toString(), values[0]);
    }
}
