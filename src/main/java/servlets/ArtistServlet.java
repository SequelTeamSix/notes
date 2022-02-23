package servlets;

import com.revature.model.Artist;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/artists")
public class ArtistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();


        List<Artist> as= new ArrayList<Artist>();
        as.add(new Artist("Kandinsky", 1));
        as.add(new Artist("Klee", 1));
        as.add(new Artist("Varo", 1));

        for(Artist a : as) {
            out.println(a);
        }
    }
}
