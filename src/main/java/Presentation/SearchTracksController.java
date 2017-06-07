package Presentation;

import Model.TrackModel;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Singleton
public class SearchTracksController extends HttpServlet {
    private TrackModel tm = new TrackModel();
    private List<TrackModel> trackmodels;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        trackmodels = tm.getTracks();
        request.setAttribute("tracks", trackmodels);
        request.getRequestDispatcher("/SearchTracks.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Hier begint Functional Requirement 5*/

        if(request.getParameter("submitInput") != null) {
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
        else if (request.getParameter("filter") != null) {
            response.sendRedirect("SearchTracks");
        }
    }
}
