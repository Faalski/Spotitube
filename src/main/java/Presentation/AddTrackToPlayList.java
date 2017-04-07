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
import java.util.List;

/*Hier begint Functional Requirement 2*/
@WebServlet(urlPatterns = "/AddTrackToPlayList")
public class AddTrackToPlayList extends HttpServlet {
    private PlaylistModel pm = new PlaylistModel();
    private TrackModel tm = new TrackModel();
    private List<TrackModel> trackmodels;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tn = request.getParameter("TrackName");
        String pn = request.getParameter("PerformerName");
        HttpSession s =request.getSession();
        String pl = (String)s.getAttribute("playlistname");
        try {
            pm.AddTrackToPlayList(tn, pn, pl);
            trackmodels = tm.getTracks();
        }catch(SQLException e){
            System.out.println(e);
        }
        request.setAttribute("tracks", trackmodels);
        request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
    }
}
