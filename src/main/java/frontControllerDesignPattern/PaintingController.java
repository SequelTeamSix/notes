package frontControllerDesignPattern;

import javax.servlet.http.HttpServletRequest;

public class PaintingController {
    public String painting(HttpServletRequest request){
        PaintingRepository pr = new PaintingRepository();
        if(request.getMethod().equals("GET")){
            int paintingNum = Integer.parseInt(request.getParameter("paintingNum"));
            return pr.getPainting(paintingNum).toString();
        }else if (request.getMethod().equals("POST")) {
            /*implement adding a painting using request parameters later*/
            return "method not implemented";
        }else{
            return "method not implemented";
        }
    }
}
