package Presentation;

import Model.PlaylistModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*Hier begint Functional Requirement 1*/

public class CreatePlaylistController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();

    public CreatePlaylistController() {};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String playlistname = request.getParameter("newplaylist");
        HttpSession session=request.getSession(true);
        session.setAttribute("playlistname",playlistname);
        String owner = (String)session.getAttribute("owner");
        String[] newPlaylistInfo = {owner, playlistname};
        pm.createNewPlaylist(newPlaylistInfo);
        response.sendRedirect("SearchTracks");
    }

}
