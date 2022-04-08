package cookies;

public class CookieChain {
//contains memory address of cookie
    Cookie thisCookie;
//    contains memory address of next link
    CookieChain nextCookieLink;

    public CookieChain(Cookie c, CookieChain link){
//        all we are doing is manipulating memory addresses
        this.thisCookie = c;
        this.nextCookieLink = link;
    }
}