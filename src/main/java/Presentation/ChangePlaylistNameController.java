package Presentation;

import Model.PlaylistModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lars on 27-3-2017.
 */
@WebServlet(urlPatterns = "/ChangePlaylistName")
public class ChangePlaylistNameController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String newplaylistname = request.getParameter("newplaylistname");
            String oldplaylistname = request.getParameter("oldplaylistname");
            pm.changePlaylistName(newplaylistname, oldplaylistname);
            response.sendRedirect("ViewPlaylist");

        }
    }

