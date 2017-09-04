package Presentation;

import Datasource.Hibernate.LoginHibernate;
import Datasource.IloginHibernate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    IloginHibernate login = new LoginHibernate();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        try{
            if(login.getAccountByName(user, pass).size() != 0){
                HttpSession session = request.getSession(true);
                session.setAttribute("owner", user);
                response.sendRedirect("ViewInventory");
            } else {
                request.setAttribute("status", "LOGIN_NOT_CORRECT");
                request.getRequestDispatcher("/start.jsp").forward(request, response);
            }
        }catch(Exception e){
            request.setAttribute("status", "DATABASE_ERROR");
            request.getRequestDispatcher("/start.jsp").forward(request, response);
        }

    }
}
