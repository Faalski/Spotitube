package Presentation;

import Domain.Track;
import Model.TrackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Lars on 24-3-2017.
 */
@WebServlet(urlPatterns = "/ViewTracksFromPlaylist")
public class ViewTracksFromPlaylistController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
