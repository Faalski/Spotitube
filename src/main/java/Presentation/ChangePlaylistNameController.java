package Presentation;

import Model.PlaylistModel;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*Hier begint Functional Requirement 3*/

@Singleton
public class ChangePlaylistNameController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String newplaylistname = request.getParameter("newplaylistname");
            String oldplaylistname = request.getParameter("oldplaylistname");
            HttpSession session=request.getSession();
            String owner = (String)session.getAttribute("owner");
            pm.changePlaylistName(owner, newplaylistname, oldplaylistname);
            response.sendRedirect("ViewPlaylist");
        }
    }

