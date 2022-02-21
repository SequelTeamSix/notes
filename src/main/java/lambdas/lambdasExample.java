package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class lambdasExample {
    /*
    RandomGenerator random;
    public lambdasExample(){
        random = new RandomGenerator();
    }
    this can be mocked
    Mockito.when(random1.getRandom).thenReturn(.3);
    Mockito.when(random2.getRandom).thenReturn(.6);
    Mockito.when(random3.getRandom).thenReturn(.9);
    public lambdasExample(RandomGenerator random){
        this.random = random;
    }*/

    public static void main(String[] args){
        /*
        java 8 features
        lambdas
        streams
         */

        List<String> name = new ArrayList<>();
        name.add("tyler ruperti");
        name.add("prakash");
        name.add("tyler seufert");
        name.add("shawntaria");
        name.add("max");



        /*whats a consumer?
        a consumer... consumes things
        it takes in input, and returns nothing
        the idea being that is causes "side effects"
        (some operation happens without a return)
        in this case, a consumer is actually consuming a function and returning nothing
        (because it is just running the given function)
         */
        name.forEach(str -> System.out.println(str));
        /*
        name.forEach(
                str -> {
                    str = str.toUpperCase();
                    System.out.println(str);
                }
        );*/
        List<String> everyoneUppercase = name.stream().map(str->str.toUpperCase()).collect(Collectors.toList());
        List<String> onlyTylers = name.stream().filter(str->str.contains("tyler")).collect(Collectors.toList());

        everyoneUppercase.forEach(str -> System.out.println(str));
        onlyTylers.forEach(str -> System.out.println(str));

        /*java collections will be permitted in p1*/



        /*
        functional interfaces: interfaces with one abstract method,
        the abstract method is what's called when we call a lambda
         */


        /*
        stream methods:
        filter: filter into only items that fulfill a conditional
        map: apply some operation to all items
        collect: convert stream to collection
         */


        /*
        functions are reusable blocks of code (like we've been using)
        methods are functions tied to classes
         */

    }
    public void lambdaReplacement(String str){
        str = str.toUpperCase();
        System.out.println(str);
    }
}
