package Presentation;

import Model.PlaylistModel;
import Model.TrackModel;
import Service.RestResourceConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dimitri on 27-3-17.
 */
@WebServlet(urlPatterns = "/SearchTracks")
public class SearchTracksController extends HttpServlet {
    private TrackModel tm = new TrackModel();
    private List<TrackModel> trackmodels;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestResourceConfig rrc = new RestResourceConfig();
        try{
            trackmodels = tm.getTracks();
        }catch(SQLException e){
            System.out.println(e);
        }
        request.setAttribute("tracks", trackmodels);
        request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RestResourceConfig rrc = new RestResourceConfig();
            String input = request.getParameter("SearchInput");
            try {
                trackmodels = tm.getTracksByName(input);
            } catch (SQLException e) {
                System.out.println(e);
            }

            request.setAttribute("tracks", trackmodels);
            request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);

    }
}
