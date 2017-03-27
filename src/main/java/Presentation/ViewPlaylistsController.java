package Presentation;

import Model.PlaylistModel;
import Model.TrackModel;
import Service.RestResourceConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Lars on 23-3-2017.
 */
@WebServlet(urlPatterns = "/ViewPlaylist")
public class ViewPlaylistsController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();
    private TrackModel tm = new TrackModel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestResourceConfig rrc = new RestResourceConfig();
        String owner = "harry";
        List<PlaylistModel> playlistmodels = pm.getAllPlaylists(owner);
        request.setAttribute("playlists", playlistmodels);
        request.getRequestDispatcher("/ViewPlaylist.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String JSPplaylist = request.getParameter("playlistname");
        if(request.getParameter("changename") != null) {
            request.setAttribute("playlistname", JSPplaylist);
            request.getRequestDispatcher("/ChangePlaylistName.jsp").forward(request, response);
        }
        else if(request.getParameter("viewtracksfromplaylist") != null) {
            List<TrackModel> trackModels =tm.getTracksFromPlaylist(JSPplaylist);
            request.setAttribute("tracksfromplaylist", trackModels);
            request.getRequestDispatcher("/ViewTracksFromPlaylist.jsp").forward(request, response);
        }
    }


}
