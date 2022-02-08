package cookies;

public class CookieList {

    CookieChain head;

    public CookieList(){

    }

    public void addCookie(Cookie c){

//         1. we make the new link in the cookiechain point to the current head
//        2. we make the head point to the new cookiechain

         CookieChain newChainLink = new CookieChain(c, head);
         head = newChainLink;

    }

    public void traverseCookies(){
        CookieChain currentCookie = head;
        while(currentCookie!=null){

            System.out.println(currentCookie.thisCookie);
            currentCookie = currentCookie.nextCookieLink;

        }
    }


}
