package se.grit.dag2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/HTTPServlet")
public class BigHTTPServlet extends HttpServlet {

    @Override
    public void init(){
        System.out.println("init() - this is the place to do start up things");
    }

    @Override
    public void destroy(){
        System.out.println("destroy() - this is the place to do shutdown things");
    }

    @Override
    public String getServletInfo() {
        return "Big HTTP Servlet: This is my Servlet Information";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Big HTTP Servlet</h1>");

        printParams(request, response);

        printForm(request, response);

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       PrintWriter out = response.getWriter();

       out.println("<html><body>");
       out.println("<h1>Big HTTP Servlet doPost()</h1>");
       out.println("<p><b>Hello, " + request.getParameter("name") + "!</b></p>");
       printParams(request, response);
       out.println("</body></html>");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Big HTTP Servlet doPut()</h1></body></html>");
        System.out.println("doPut() - here we handle PUT-requests");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Big HTTP Servlet doDelete()</h1></body></html>");
        System.out.println("doDelete() - here we handle DELETE-requests");
    }

    private void printParams(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //request.getParameter("namn")
        Map<String, String[]> queryParams = request.getParameterMap();
        if(!queryParams.isEmpty()) {
            PrintWriter out = response.getWriter();
            out.println("<h2>Parameters</h2>");
            out.println("<ul>");
            queryParams.forEach((k,v)->{
               out.println("<li>");
               out.print(k + "[ ");
               for(int i=0;i<v.length;i++){
                   out.print(v[i] + " ");
               }
               out.print(" ]");
               out.println("</li>");
            });
        }

    }


    private void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<form action=\"/HTTPServlet\" method=\"POST\">");
        out.println("<label for=\"name\">Name</label>");
        out.println("<input type=\"text\" name=\"name\" id=\"name\">");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
    }

}
