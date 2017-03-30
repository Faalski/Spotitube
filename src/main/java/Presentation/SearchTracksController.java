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
 * Created by dimitri on 27-3-17.
 */
@WebServlet(urlPatterns = "/SearchTracks")
public class SearchTracksController extends HttpServlet {
    private TrackModel tm = new TrackModel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestResourceConfig rrc = new RestResourceConfig();
        List<TrackModel> trackmodels = tm.getAllTracks();
        request.setAttribute("tracks", trackmodels);
        request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
    }
}
