package cookies;

public class Cookie extends Object implements Comparable<Cookie> {

/*whats a class?
a class is a blueprint for an object

whats an object?
an object is an instance of a class
objects have states (variables) and behaviors (methods)
 */
    /*access modifiers:
    public,
    private,
    default,
    protected
     */
    private int numChips;
    private double grams;
    private String type;
    public boolean edible;

    /*
        overloading:
        multiple methods can have same name if parameters have different types
     */
    public Cookie(){

    }

    public int getNumChips() {
        return numChips;
    }

    public void setNumChips(int numChips) {
        this.numChips = numChips;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public Cookie(String abcd){
        this.type = abcd;
    }
    public Cookie(String abcd, double grams){
        this.type = abcd;
        this.grams = grams;
    }

    /*
    Cookie()
    Cookie("vanilla");

    we cant overload with return types:
    m1() supposed to return int
    m1() supposed to return boolean
     */
    /*
    the object class gives us many methods, including but not limited to
    hashcode - what we currently get when we print objects (unique identifier)
    tostring - automatic conversion to string representation (to make us better at printing objects)
    tostring - should be overwritten
    equals - is it equivalent to another object?

    cookie c1 = new cookie
    cookie c2 = new cookie
    c1==c2;
    false, because java is trying to see if the memory addresses are identical
    c2 = c1;
    c1==c2
    true, because the memory addresses are identical

    c1.equals(c2)
    but this needs to be implemented by us!


     */
//    overwriting the toString method provided for us by the Object class:
    public String toString(){
        return type;
    }

    @Override
    public int compareTo(Cookie o) {
        return 0;
    }
}
