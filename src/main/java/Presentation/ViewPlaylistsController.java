package Presentation;

import Domain.Playlist;
import Domain.Track;
import Model.PlaylistModel;
import Model.TrackModel;
import Service.RestResourceConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lars on 23-3-2017.
 */
@WebServlet(urlPatterns = "/ViewPlaylist")
public class ViewPlaylistsController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();
    private TrackModel tm = new TrackModel();
    List<TrackModel> trackmodels = new ArrayList<TrackModel>();
    String owner = "harry";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PlaylistModel> playlistmodels = new ArrayList<PlaylistModel>();
        playlistmodels = pm.getAllPlaylists(owner);
        request.setAttribute("playlists", playlistmodels);
        request.getRequestDispatcher("/ViewPlaylist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlistname");
        HttpSession session=request.getSession(true);
        session.setAttribute("playlistname",playlist);

        if(request.getParameter("changename") != null) {
            request.getRequestDispatcher("/ChangePlaylistName.jsp").forward(request, response);
        }
        else if(request.getParameter("viewtracksfromplaylist") != null) {
            response.sendRedirect("ViewTracksFromPlaylist");
            //request.getRequestDispatcher("ViewTracksFromPlaylist").forward(request, response);
        }
        else if(request.getParameter("deleteplaylist") != null) {
            try {
                pm.deletePlaylist(owner, playlist);
                response.sendRedirect("ViewPlaylist");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(request.getParameter("addTrack") != null) {
            response.sendRedirect("SearchTracks");
        }
    }


}
