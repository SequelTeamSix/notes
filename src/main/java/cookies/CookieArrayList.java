package cookies;

public class CookieArrayList {
//    pseudocode
//    variables needed:
//    Array of something;
//    The current amount of somethings;

//    Constructor that creates an initial array of some size;

//    Get method that returns the something of a given index;

//    Add method
//    First, check that the arraylist will not break if we try to add at the next index:
//    IE, check if the current amount of somethings+1 is not greater that the array size
//    if it is greater:
//          Copy the elements of the current array to a new array.
//          set the pointer of the arrayList's internal array to the new array.
//    that adds things at an index that is currently unused
//    (this will be the current size)




//    a method that can return a boolean determining if your array list contains a certain item
//    (if you had an arraylist of objects, as opposed to primitives, you may need to implement and use .equals)
//    a method that can determine if your arraylist is identical to another one
//    (again, .equals)
//    a method that sets a given index to a particular value

    Cookie[] cookieList = new Cookie[16];
    public Cookie get(int i){
        return cookieList[i];
//        in a particular index in cookielist, we have a memory address
//        pointing to a cookie object
//        by returning a index, we can recieve the memory address into a cookie
//        object in whatever object is calling arrayList.get();

        /*
        the reason why java may ask you to use static methods and object:
        you're likely trying to use methods that arent actually tied to the existence
        of a real object
        and rather trying to call the class's methods directly

        > make objects!!! <
         */
    }

}
