package servlets;

import com.revature.model.Artist;
import com.revature.service.ArtistService;
import com.revature.service.PaintingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Welcome to the Addition Servlet!");

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        out.println(num1+" + "+num2+" = "+(num1+num2));

        out.println("Here are my favorite artists: ");
        ArtistService as = new ArtistService();
        for(Artist a : as.getAllArtists()){
            out.println(a);
        }
    }



}
