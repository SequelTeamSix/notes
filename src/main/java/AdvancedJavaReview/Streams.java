package AdvancedJavaReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args){
        String[] names = {"Tyler R", "Tyler S", "Tyler D", "Max", "Josue", "Cullen"};
/*        the streams api is a useful way for us to perform operations on data within
            collections on an individual level

            streams have a couple useful methods:
          map, foreach, filter, collect
 */
//        printArrayUsingStream(names);
        ArrayList<String> onlyTylers = (ArrayList<String>) Arrays.stream(names).filter(name -> name.contains("Tyler")).collect(Collectors.toList());

        for(String B : onlyTylers){
            System.out.println(B);
        }
        StreamPrinter sp = new StreamPrinter();
        sp.printArrayUsingStream(names);
        StreamPrinter.printHello();
        Math.min(1,2);
        System.out.println(StringReverse.reverse("Tyler"));

        Arrays.stream(names).map(StringReverse::reverse).forEach(System.out::println);
    }

}
