package Presentation;

import Model.LoginModel;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Singleton
public class LoginController extends HttpServlet {
    LoginModel lm = new LoginModel();
    boolean canLog;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        canLog = lm.checkForData(user, pass);
        if(canLog){
            HttpSession session=request.getSession(true);
            session.setAttribute("owner",user);
            response.sendRedirect("ViewPlaylist");
        } else {
            request.getRequestDispatcher("/start.jsp").forward(request, response);
        }
    }
}
