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
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dimitri on 30-3-17.
 */
@WebServlet(urlPatterns = "/AddTrackToPlayList")
public class AddTrackToPlayList extends HttpServlet {
    private PlaylistModel pm = new PlaylistModel();
    private TrackModel tm = new TrackModel();
    private List<TrackModel> trackmodels;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestResourceConfig rrc = new RestResourceConfig();
        String tn = request.getParameter("TrackName");
        String pn = request.getParameter("PerformerName");
        String pl = "kaklijst";
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
