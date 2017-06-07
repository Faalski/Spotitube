package Presentation;

import Model.TrackModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchTracksControllerTest {
    @Mock
    TrackModel tm;
    @Mock
    HttpServletRequest mockRequest;
    @Mock
    HttpServletResponse mockResponse;
    @Mock
    RequestDispatcher mockReqDispatcher;

    SearchTracksController stc = new SearchTracksController();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        tm = mock(TrackModel.class);
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockReqDispatcher = mock(RequestDispatcher.class);

        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockReqDispatcher);

    }

    @Test
    public void doGetTest() throws Exception {
        stc.doGet(mockRequest,mockResponse);

        verify(mockRequest).getRequestDispatcher(Matchers.eq("/SearchTracks.jsp"));
        verify(mockReqDispatcher).forward(mockRequest, mockResponse);
    }

    @Test
    public void doPostTestSearch() throws Exception {
        when(mockRequest.getParameter("submitInput")).thenReturn("A");
        when(mockRequest.getParameter("SearchInput")).thenReturn("a");

        stc.doPost(mockRequest,mockResponse);

        verify(mockRequest).getParameter("SearchInput");
        verify(mockRequest).getRequestDispatcher(Matchers.eq("/SearchTracks.jsp"));
        verify(mockReqDispatcher).forward(mockRequest, mockResponse);
    }

    @Test
    public void doPostTestViewPlayListRedirect() throws Exception {
        when(mockRequest.getParameter("goToPlaylist")).thenReturn("A");

        stc.doPost(mockRequest,mockResponse);

        verify(mockResponse).sendRedirect("ViewTracksFromPlaylist");
    }

    @Test
    public void doPostTestSearchRedirect() throws Exception {
        when(mockRequest.getParameter("filter")).thenReturn("A");

        stc.doPost(mockRequest,mockResponse);

        verify(mockResponse).sendRedirect("SearchTracks");
    }
}
