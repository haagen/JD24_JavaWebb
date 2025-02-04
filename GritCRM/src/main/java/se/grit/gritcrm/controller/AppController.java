package se.grit.gritcrm.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.grit.gritcrm.dao.UserDAO;
import se.grit.gritcrm.model.User;

import java.io.IOException;
import java.io.PrintWriter;

public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        User u = new User();
        u.setUsername("martin");
        UserDAO udao = new UserDAO();
        udao.save(u);

        PrintWriter out = res.getWriter();
        out.println("DONE!");

    }

}
