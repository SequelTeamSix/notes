package frontControllerDesignPattern;

import javax.servlet.http.HttpServletRequest;

public class ArtistController {
    ArtistRepository ar = new ArtistRepository();
    public String artist(HttpServletRequest request){
        if(request.getMethod().equals("GET")){
            int artistNum = Integer.parseInt(request.getParameter("artistNum"));
            return ar.getArtist(artistNum).toString();
        }else if (request.getMethod().equals("POST")) {
            /*implement adding a painting using request parameters later*/
            return "method not implemented";
        }else{
            return "method not implemented";
        }
    }
}
