package se.grit.gritcrm.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {

    public static Boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            return false;
        }
        return true;
    }

    public static void redirectToLogin(HttpServletRequest req, HttpServletResponse res) {
        try {
            req.getRequestDispatcher("/view/login.jsp").forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
