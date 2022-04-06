package AdvancedJavaReview;

public class StringReverse {

    public static String reverse(String s){
        String reverse = "";
        for(int i = s.length(); i > 0; i--){
            reverse+=s.charAt(i-1);
        }
        return reverse;
    }
}
