package zoo;

//an interface is a guarantee of behavior that can be shared between classes
//for instance: comparable guarantees that two objects of the same class can be compared to each other
//(eg sorted alphabetically)
//why do this?


import cookies.Cookie;

//interfaces are a "contract" of behavior
//IE, everything that implements comparable has a contract to be a comparable object
public class Animal implements Comparable<Animal>{
    String species;
    int temp = 0;
    public Animal(String s) {
        species = s;
    }
//    I want to compare two animals so that we can have them sorted:
//    how is this done?


//    override? this is an annotation
//    an annotation, in some cases its informative for developer,
//    in other cases it actually changes out code
//      how does it change our code?
//      so in java there's something called reflection...
//      meaning that we can make programs that change our java code at runtime
//      rather than compilation

    public int compareTo(Animal a) {
        return a.species.compareTo(this.species);
    }

    public String toString(){
        return species;
    }


    /*abstract classes are basically blueprints
    * interfaces are guarantees of certain behaviors that other classes can expect the
    * class to exhibit (eg a for loop class can expect an object to be able
    * to be iterated
    * */


    /*
    what's the difference between interfaces and abstract classes?
    we implement interfaces and extend abstract classes
     */


}
