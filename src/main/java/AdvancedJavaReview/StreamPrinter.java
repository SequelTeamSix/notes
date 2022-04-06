package AdvancedJavaReview;

import java.util.Arrays;

public class StreamPrinter {

    public void printArrayUsingStream(String[] in){
        Arrays.stream(in).forEach(name -> System.out.println(name));
    }
    public static void printHello(){
        System.out.println("Hello!");
    }

}
