package se.grit.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.grit.gritcrm.dao.AccountDAO;
import se.grit.gritcrm.dao.ContactDAO;
import se.grit.gritcrm.model.Account;
import se.grit.gritcrm.model.Contact;
import se.grit.gritcrm.model.User;
import se.grit.gritcrm.util.SessionUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/contacts")
public class ContactController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {

            if (!SessionUtil.isAuthenticated(request)) {
                SessionUtil.redirectToLogin(request, response);
                return;
            }

            User u = (User) request.getSession().getAttribute("user");
            ContactDAO cdao = new ContactDAO();

            // Check if SingleView
            if(request.getParameter("id") != null) {
                Contact c =  null; Integer id = null;
                String sId = request.getParameter("id");
                if(sId != null &&  !sId.isEmpty()) {
                    id = Integer.parseInt(sId);
                    c = cdao.findById(id, u);
                    if(c != null) {
                        request.setAttribute("contact", c);
                        request.getRequestDispatcher("view/contact/detail.jsp").forward(request, response);
                        return;
                    }
                }
            }

            // Check if Create or Update
            if(request.getParameter("editId") != null) {
                Contact c =  null; Integer id = null;
                String sId = request.getParameter("editId");
                if(sId != null &&  !sId.isEmpty()) {
                    id = Integer.parseInt(sId);
                    c = cdao.findById(id, u);
                    if(c != null && c.getAccount() != null) {
                        request.setAttribute("accountId", c.getAccount().getId());
                    }
                }
                if(c == null) {
                    c = new Contact();
                    request.setAttribute("accountId", request.getParameter("accountId"));
                }
                request.setAttribute("contact", c);
                request.getRequestDispatcher("view/contact/edit.jsp").forward(request, response);
                return;
            }

            // Check if Delete
            if(request.getParameter("deleteId") != null) {
                String sId = request.getParameter("deleteId");
                if(sId != null &&  !sId.isEmpty()) {
                    Integer id = Integer.parseInt(sId);
                    cdao.deleteById(id, u);
                }
            }

            // Load All accounts owned by user - default action
            List<Contact> contacts = cdao.findAll(u);
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("view/contact/list.jsp").forward(request, response);

        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {

            if (!SessionUtil.isAuthenticated(request)) {
                SessionUtil.redirectToLogin(request, response);
                return;
            }
            User u = (User) request.getSession().getAttribute("user");
            ContactDAO cdao = new ContactDAO();

            String sId = request.getParameter("id");
            Contact c = null;
            if(sId == null) {
                c = new Contact();
            } else {
                Integer id = Integer.parseInt(sId);
                if(id > 0) {
                    c = cdao.findById(id, u);
                } else {
                    c = new Contact();
                    c.setUser(u);
                }
                assert c != null;
            }

            c.setName(request.getParameter("name"));
            c.setEmail(request.getParameter("email"));
            c.setPhone(request.getParameter("phone"));
            c.setChanged(new Date());

            sId = request.getParameter("accountId");
            if(sId != null &&  !sId.isEmpty()) {
                Integer accountId = Integer.parseInt(sId);
                AccountDAO adao = new AccountDAO();
                Account a = adao.findById(accountId, u);
                if(a != null) {
                    c.setAccount(a);
                }
            }

            if(c.getId() > 0) {
                cdao.update(c);
            } else {
                cdao.save(c);
            }

            List<Contact> contacts = cdao.findAll(u);
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("view/contact/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
