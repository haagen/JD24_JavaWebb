package se.grit.dag3;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import se.grit.dag3.database.DB;
import se.grit.dag3.models.Fruit;

@WebServlet("/fruitList")
public class FruitList extends HttpServlet {

    public void init() { }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>The Fruit List</h1>");
        out.println("<ul>");
        for(int i=0; i< DB.fruits.length; i++) {
            Fruit fruit = DB.fruits[i];
            out.println("<li><a href=\"viewFruit?fruitId=" + fruit.getId() + "\">" + fruit.getName() + "</a></li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() { }
}