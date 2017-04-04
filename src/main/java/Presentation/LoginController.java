package Presentation;

import Model.LoginModel;
import Model.PlaylistModel;
import Service.RestResourceConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lars on 27-3-2017.
 */
@WebServlet(urlPatterns = "/Login")
public class LoginController extends HttpServlet {
    LoginModel lm = new LoginModel();
    boolean canLog;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        canLog = lm.checkForData(user, pass);
        System.out.println(canLog);
        if(canLog){
            HttpSession session=request.getSession(true);
            session.setAttribute("owner",user);
            request.getRequestDispatcher("/ViewPlaylist.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/start.jsp").forward(request, response);
        }
    }
}
