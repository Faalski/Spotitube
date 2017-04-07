package Presentation;

import Model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        try{
            trackmodels = tm.getTracks();
        }catch(SQLException e){
            System.out.println(e);
        }
        request.setAttribute("tracks", trackmodels);
        request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Hier begint Functional Requirement 5*/
        if(request.getParameter("searchInput") != null) {
            String input = request.getParameter("SearchInput");
            try {
                trackmodels = tm.getTracksByName(input);
            } catch (SQLException e) {
                System.out.println(e);
            }

            request.setAttribute("tracks", trackmodels);
            request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
        }
        else if (request.getParameter("goToPlaylist") != null) {
            response.sendRedirect("ViewTracksFromPlaylist");
        }


    }
}
