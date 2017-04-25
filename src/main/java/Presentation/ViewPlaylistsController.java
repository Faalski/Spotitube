package Presentation;

import Model.PlaylistModel;
import Model.TrackModel;

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


public class ViewPlaylistsController extends HttpServlet {
    PlaylistModel pm = new PlaylistModel();
    List<TrackModel> trackmodels = new ArrayList<TrackModel>();
    String owner;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PlaylistModel> playlistmodels = new ArrayList<PlaylistModel>();
        HttpSession session=request.getSession();
        owner = (String)session.getAttribute("owner");
        playlistmodels = pm.getAllPlaylists(owner);
        request.setAttribute("playlists", playlistmodels);
        request.getRequestDispatcher("/ViewPlaylist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlistname");
        HttpSession session=request.getSession();
        session.setAttribute("playlistname", playlist);
        session.setAttribute("checktracks", trackmodels);

        if(request.getParameter("changename") != null) {
            request.getRequestDispatcher("/ChangePlaylistName.jsp").forward(request, response);
        }
        else if(request.getParameter("viewtracksfromplaylist") != null) {
            response.sendRedirect("ViewTracksFromPlaylist");
        }
        else if(request.getParameter("deleteplaylist") != null) {
            /*Hier begint Functional Requirement 6*/
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
