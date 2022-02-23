package frontControllerDesignPattern;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

public class RequestHelper {

    public static String process (HttpServletRequest request){
        PaintingController pc = new PaintingController();
        ArtistController ac = new ArtistController();
        switch(request.getRequestURI()) {
            case "/JavaReactAzure/paintingAPI/painting":
                return pc.painting(request);
            case "/JavaReactAzure/paintingAPI/artist":
                return ac.artist(request);
            default:
                return "not implemented: "+request.getRequestURI();
        }
    }
}
