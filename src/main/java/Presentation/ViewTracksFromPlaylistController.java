package Presentation;

import Domain.Track;
import Model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lars on 30-3-2017.
 */
@WebServlet("/ViewTracksFromPlaylist")
public class ViewTracksFromPlaylistController extends HttpServlet {
    List<TrackModel> trackmodels = new ArrayList<TrackModel>();
    private TrackModel tm = new TrackModel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s =request.getSession();
        String playlist = (String)s.getAttribute("playlistname");
        trackmodels =tm.getTracksFromPlaylist(playlist);
        request.setAttribute("tracksfromplaylist", trackmodels);
        request.getRequestDispatcher("/ViewTracksFromPlaylist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s =request.getSession();
        String playlist = (String)s.getAttribute("playlistname");
        s.setAttribute("playlist", trackmodels);
        String title = request.getParameter("title");
        String performer = request.getParameter("performer");
        if(request.getParameter("DeleteTrack") != null) {
            tm.deleteTrackFromPlaylist(title, performer, playlist);
            response.sendRedirect("ViewTracksFromPlaylist");
        }
        else if(request.getParameter("changeAvailability") != null) {
            response.sendRedirect("ChangeAvailability");
        }


    }
}
