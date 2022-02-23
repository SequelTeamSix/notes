package servlets;

import com.revature.dao.ArtistDAO;
import com.revature.model.Artist;
import com.revature.service.ArtistService;
import com.revature.service.PaintingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h3>Welcome to the Addition Servlet!</h3>");

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        out.println("<p>"+num1+" + "+num2+" = "+(num1+num2)+"</p>");

        out.println("<p>Here are my favorite artists: </p>");

        RequestDispatcher rd = request.getRequestDispatcher("artists");
        rd.include(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("myNumber", num1+num2);
        out.println("<p>Those were my favorite artists!</p>");
        out.println("<a href='secret'>Click for the secret servlet!</a>");

    }
}
