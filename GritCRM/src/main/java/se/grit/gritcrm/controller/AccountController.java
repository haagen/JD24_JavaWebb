package se.grit.gritcrm.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.grit.gritcrm.dao.AccountDAO;
import se.grit.gritcrm.model.Account;
import se.grit.gritcrm.model.User;
import se.grit.gritcrm.util.SessionUtil;

import java.util.Date;
import java.util.List;

@WebServlet("/accounts")
public class AccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        try {
            if(!SessionUtil.isAuthenticated(req)) {
                SessionUtil.redirectToLogin(req, res);
                return;
            }

            User user = (User) req.getSession().getAttribute("user");
            AccountDAO aDAO = new AccountDAO();

            // Is this a SingleView?
            if(req.getParameter("id") != null) {
                Account a =  null; Integer id = null;
                String sId = req.getParameter("id");
                if(sId != null &&  !sId.isEmpty()) {
                    id = Integer.parseInt(sId);
                    a = aDAO.findById(id, user);
                    if(a != null) {
                        req.setAttribute("account", a);
                        req.getRequestDispatcher("view/account/detail.jsp").forward(req, res);
                        return;
                    }
                }
            }

            // Is this an Edit- or CreateView
            if(req.getParameter("editId") != null) {
                Account a = null; Integer id = null;
                String sId = req.getParameter("editId");
                if(sId != null && !sId.isEmpty()) {
                    id = Integer.parseInt(sId);
                    a = aDAO.findById(id, user);
                }
                if(a == null) {
                    a = new Account();
                }
                req.setAttribute("account", a);
                req.getRequestDispatcher("view/account/edit.jsp").forward(req, res);
                return;
            }

            // Should we delete an account?
            if(req.getParameter("deleteId") != null) {
                String sId = req.getParameter("deleteId");
                if(sId != null && !sId.isEmpty()){
                    Integer id = Integer.parseInt(sId);
                    aDAO.deleteById(id, user);
                }
            }

            // Default to list all accounts
            List<Account> accounts = aDAO.findAll(user);
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("view/account/list.jsp").forward(req, res);
        } catch(Throwable e) {
            System.out.println("Exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){

        try {
            if(!SessionUtil.isAuthenticated(req)) {
                SessionUtil.redirectToLogin(req, res);
                return;
            }

            User user = (User) req.getSession().getAttribute("user");
            AccountDAO aDAO = new AccountDAO();

            String sId = req.getParameter("id");
            Account a = null;
            if(sId == null){
                a = new Account();
            } else {
                Integer id = Integer.parseInt(sId);
                if(id > 0) {
                    a = aDAO.findById(id, user);
                }
                if(a == null){
                    a = new Account();
                }
            }

            a.setName(req.getParameter("name"));
            a.setName(req.getParameter("name"));
            a.setAddress(req.getParameter("address"));
            a.setCity(req.getParameter("city"));
            a.setZip(req.getParameter("zip"));
            a.setCountry(req.getParameter("country"));
            a.setChanged(new Date());

            if(a.getId() > 0) {
                aDAO.update(a);
            } else {
                a.setUser(user);
                aDAO.save(a);
            }

            List<Account> accounts = aDAO.findAll(user);
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("view/account/list.jsp").forward(req, res);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

}






