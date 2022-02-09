package cookies;

/*

Package?
organization of my java program structure
allows me to organize related classes together
if there is a class we are using in another package, we will need to import

 */

/*classes?
everything in java's a class!
especially objects, which are instances of classes
 */

public class Driver {
/*main is just the entry point for running our program
we can put all of our code in main i guess, but this is very disorganized
 */
    public static void main(String[] args){

        /*variables:
        basic unit of storage
        java has primitives and objects
        all a primitive is, is that a variable is stored
        as itself and not as a memory reference
        java is what we call "strongly typed"
        meaning that we always have to designate what type a variable is

        variable defaults:

        boolean false;
        numerics are 0;
        objects(strings included) are null
         */

//        8 bits (1 byte)
//
        boolean myBoolean = false;
        boolean myBoolean2 = false;
        byte myByte = 123;
//      16 bits
        short s = 1234;
        char myChar = 'a';
//        whole number, maxes at just over 2 billion, 32 bits
        int myInt = 12345;
//        floats have an accuracy issue, don't use them
        float myFloat = 1.0000001F;
//        much larger than ints, potentially, 64 bits
        long myLong = 1234567890L;
        double myDouble = 222.22222222;

//        realistically, you're going to be using just booleans, ints, doubles

/*        those are primitives... now we'll talk about objects, which are different,
    because objects are represented by an address to an allocated memory space

    (strings and arrays are special, not representative of objects as a whole)

    string are *immutable*
    arrays: values within arrays can change, but the size of the array must be constant
    this is because in order to store variables, we *always* need to know how much
    space they will take up beforehand

    in some languages, yes, arrays do not have a constant size
    (like javascript, which is a very silly language)
    but in java this is mandatory
 */

        String myString = "Hello";
        Integer[] arrayOfIntegers = new Integer[16];

//        wrappers:
//        a object 'wrapped' around a primitive type,
//        or rather an object that just contains a primitive type + useful methods
//        java has a built feature called autoboxing/autounboxing to convert primitives to
//        their wrapped types and vice versa
        int changeThisToInt = Integer.parseInt("5");

//        this doesn't exist, this is why we use wrappers:
//        int.changeThisToIntPlease("5");

        if(myBoolean){
//            do this
        }else if(myBoolean2){

        }else{

        }
        while(myBoolean && myBoolean2){
//            block scope: we can access a variable within only its own block
            int myScopedInt = 0;
            myScopedInt =5;

//            do that while conditional is true
        }
//        :(
//        myScopedInt =5;
        for(int i = 0; i < 16; i++){
            arrayOfIntegers[i] = 2;
//            i++ is just shorthand for i=i+1;
        }

/*
    enhanced for loops: an alternative to for loops
    with built in iteration over arrays or java's built in collections
    anything you can do with a enhanced for can be done with for

 */
//        do while: like a while loop, when we have to guarantee that at least a single
//        iteration is performed

        do{

        }while(myBoolean2);
//        switch statements

        /*

        && and
        || or
        == 'is' (eg 4==4)
        != 'is not'
        ! not


        numeric operators:
        *
        /
        +
        -

        niche:
        % (remainder, eg 7%4=3)
        >> (bitshifts, dont worry about it)

         */
        myBoolean = returnTruePlease();

        Math.sqrt(4);








//        starting objects:
        /*java has created a new object for us! yay!
        it has given us a memory address
         */
        Cookie c1 = new Cookie();
        Cookie c2 = c1;
//        we can modify public variables outside of the object
        c1.edible = true;
        c1.setType("chocolate chip");
//        we cannot access private variables directly
//        c1.type = "chocolate";
//        this is the core of encapsulation:
//        encapsulation: we only have access to the information we need,
//        we care about hiding data
//        and restricting access

        Cookie c3 = new HyperCookie();
        Cookie c4 = new Cookie("oatmeal", 100);

        Cookie[] cookiesArray = new Cookie[4];

        cookiesArray[0]=c1;
        cookiesArray[1]=c2;
        cookiesArray[2]=c3;
        cookiesArray[3]=c4;
        myInt = cookiesArray.length;
//        make myInt 4


//        realistically, is it necessary? no, it's just considered best practice

//        how many cookies physically stored?
//        1: memory is allocated with 'new'


//        arrays are a great way to store things...
//        but i was to make something more complicated
//        how about this:
//        i have cookiesArray size 4..
//        i want to add another cookie..
//        i can't do this..
//        how do i add another cookie??

//        i want to introduce data structures
//        sneak peak into project 0: you will not be allowed to use
//        java's built in collections
//        you'll have to make your own

//        option 1: make an array backed storage
//        option 2: make something else?


//        System.out.println(c1);

        CookieList myList = new CookieList();
        myList.addCookie(c1);
        myList.addCookie(c2);
        myList.addCookie(c3);
        myList.addCookie(c4);

        myList.traverseCookies();



        Object[] myObjects = new Object[16];

        myObjects[0]=c1;
        myObjects[1]=myString;

        System.out.println(myObjects[0]);
        System.out.println(myObjects[1]);


    }

    /*what is a method?
    reusable block of code that is ran when it is called
    you can pass data to method (known as parameters)

    method vs function?
    just a naming thing
    method is a function tied to a class (everything is tied to a class in java)
    function not tied to anything (you see this in js for instance)
     */
    /*static?
    the existence of this method is not tied to the creation of an object:
    rather it is tied to the class in general
    meaning that the method is not individualized to a particular object
    but we can call it as long as the class exists

    return type?
    can be anything
    including void (return nothing)
     */

    public static boolean returnTruePlease(){
        return true;
    }

}
