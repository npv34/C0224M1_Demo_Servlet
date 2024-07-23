package org.codegym.shopapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Login servlet initialized");
        // Tao gia tri ban dau, ket noi csdl
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xu ly request url: /login voi method GET
        // Viet response
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xy ly method post
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        // Kiem tra tai khoan
        if (email.equals("admin@gmail.com") && password.equals("1234")) {
            resp.sendRedirect("dashboard");
        } else {
            // thay doi thuoc tinh location cua response
            // tao 1 request moi: url = "/login" method="GET"
            resp.sendRedirect("login");
        }
    }

}
