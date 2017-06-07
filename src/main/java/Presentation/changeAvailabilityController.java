package Presentation;

import Domain.Track;
import Model.TrackModel;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class changeAvailabilityController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hoi");
        List<TrackModel> trackmodels = new ArrayList<TrackModel>();
        HttpSession s =request.getSession();
        trackmodels = (List<TrackModel>) s.getAttribute("playlist");
        request.setAttribute("tracksfromplaylist", trackmodels);
        request.getRequestDispatcher("/ChangeAvailability.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hoi");
        HttpSession s = request.getSession();
        String playlistname = (String) s.getAttribute("playlistname");
    }


}
