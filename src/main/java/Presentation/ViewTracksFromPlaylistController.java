package Presentation;

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


public class ViewTracksFromPlaylistController extends HttpServlet {
    List<TrackModel> trackmodels = new ArrayList<TrackModel>();
    private TrackModel tm = new TrackModel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Hier begint Functional Requirement 7*/
        HttpSession s =request.getSession();
        String playlist = (String)s.getAttribute("playlistname");
        trackmodels =tm.getTracksFromPlaylist(playlist);
        request.setAttribute("tracksfromplaylist", trackmodels);
        request.getRequestDispatcher("/ViewTracksFromPlaylist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s =request.getSession();
        String playlist = (String)s.getAttribute("playlistname");
        String title = request.getParameter("title");
        String performer = request.getParameter("performer");
        for (TrackModel tm: trackmodels) {
                if(tm.getTitle().equals(title)) {
                    if(tm.getPerformer().equals(performer)) {
                        this.tm = tm;
                    }
                }
            }
            /*Hier begint Functional Requirement 4*/
        if(request.getParameter("DeleteTrack") != null) {
            tm.deleteTrackFromPlaylist(title, performer, playlist);
            response.sendRedirect("ViewTracksFromPlaylist");
        }
        else if(request.getParameter("changeAvailability") != null) {
            try {
                tm.changeAvailability(tm, playlist);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("ViewTracksFromPlaylist");
        }


    }
}
