package com.jecihjoy.APlusDemo.servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TomcatBugServlet extends HttpServlet {

    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();

        String home = "";
        try {
            Context ctx = new InitialContext();
            home = (String) ctx.lookup("java:comp/env/BUG_HOME");
        } catch (Exception e) {
            context.log("Configuration Error", e);
        }

        try {
            File dir = new File(home);

            if (dir.exists()) {
                out.println("Listing files in BUG_HOME directory");
                File[] dirContents = dir.listFiles();
                for (File file : dirContents) {
                    out.println(file);
                }
            } else {
                throw new FileNotFoundException(home);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        out.close();
    }

}
