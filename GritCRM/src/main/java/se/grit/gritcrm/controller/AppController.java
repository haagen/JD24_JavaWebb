package se.grit.gritcrm.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.grit.gritcrm.dao.UserDAO;
import se.grit.gritcrm.model.User;
import se.grit.gritcrm.util.HashingUtil;

import java.io.IOException;
import java.io.PrintWriter;

public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession session = req.getSession(false);
        try {

            if(session == null || session.getAttribute("user") == null) {
                req.getRequestDispatcher("view/login.jsp").forward(req, res);
            } else {
               req.getRequestDispatcher("view/index.jsp").forward(req, res);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
