package se.grit.dag3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.grit.dag3.database.DB;
import se.grit.dag3.models.Fruit;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/viewFruit")
public class FruitDetail extends HttpServlet {

    @Override
    public void init() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String sId = req.getParameter("fruitId");
        if(sId == null || sId.isEmpty()) {
            req.getRequestDispatcher("/fruitList").forward(req, res);
            return;
        }

        int fruitId = Integer.parseInt(sId);
        Fruit theFruit = null;
        for(int i=0;i< DB.fruits.length; i++) {
            if(DB.fruits[i].getId() == fruitId) {
                theFruit = DB.fruits[i];
            }
        }

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Fruit details</h1>");
        if(theFruit != null) {
            out.println("<h2>The " + theFruit.getName() + " fruit is " +
                    theFruit.getColor() + "</h2>");
        } else {
            out.println("<h2>No fruit found</h2>");
        }
        out.println("</body></html>");
    }

    @Override
    public void destroy() {}
}
