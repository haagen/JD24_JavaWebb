package se.grit.dag2;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet implements Servlet {

    private ServletConfig config;
    private int counter;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("SimpleServlet init");
        counter = 0;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("SimpleServlet service");
        this.counter++;

        response.setContentType("text/html");
        //response.setContentType("plain/text");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SimpleServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>SimpleServlet</h1>");

        out.println("<ul><li>Remote host: " + request.getRemoteHost() + "</li>");
        out.println("<li>Server name: " + request.getServerName() + "</li></ul>");


        out.println("<footer><p><b>Sidan har haft: " + counter + " besökare!</b></p></footer>");

        out.println("</body>");
        out.println("</html>");


    }

    @Override
    public void destroy(){
        System.out.println("SimpleServlet destroy");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "SimpleServlet - a simple servlet to help us learn Servlets";
    }

}
