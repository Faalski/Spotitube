package Presentation;

import Model.PlaylistModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lars on 29-3-2017.
 */
@WebServlet(urlPatterns = "/CreatePlaylist")
public class CreatePlaylistController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();
    String owner = "harry";

    public CreatePlaylistController() {};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String playlistname = request.getParameter("newplaylist");
        String[] newPlaylistInfo = {owner, playlistname};
        pm.createNewPlaylist(newPlaylistInfo);
        response.sendRedirect("ViewPlaylist");
    }

}
