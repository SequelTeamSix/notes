package challenges;

public class Challenges {
    public static void main(String[] args){
        /*
        MODULOS AND 2D ARRAYS

        Modulo operator:
        %: remainder after division
        x % y == 0
        this means that x is directly divisible by y
         */

        Integer[] myArr = {9,1,2,8,4,5,4,7,8};
        Integer[][] myArrSquared = new Integer[3][3];

        for(int i = 0; i < myArr.length; i++){
            myArrSquared[ i / 3 ][ i % 3 ] = myArr[i];
        }
        for(int i = 0; i < myArrSquared.length ; i++){
            for(int j = 0; j < myArrSquared[i].length ; j++){

                /*you may have seen this before, but we have print and println
                meaning println adds a new line character (\n) after the print
                 */
                System.out.print(myArrSquared[i][j]);
            }
            System.out.print("\n");
        }

        /*STRING MANIPULATION:*/

        String aString = "abc123";
        System.out.println("char at index 1 of "+ aString+ ": "+aString.charAt(1));
        System.out.println("index of '1': "+ aString.indexOf('1'));
        System.out.println("substring starting at index 4: " + aString.substring(4));
        System.out.println("substring index 3 to 5: " + aString.substring(3, 5));
        System.out.println("split aString on 'c':");
        String[] aStringSplit= aString.split("c");
        for(int i = 0; i < aStringSplit.length; i++){
            System.out.println(aStringSplit[i]);
        }
        /*
        best string methods:
        charAt(integer of index)

        find index of character:
        remember that chars use single quotes
        indexOf(char ' ')

        with substrings: the first index is inclusive and 0 indexed
        and the last index is exclusive
        str=str.substring(integer of first index)
        str=str.substring(integer of first index, integer of last index)

        string[] strarr = str.split(): turns a string into an array of strings using some string
        (usually space) to separate the string
        split(string to split with, usually " ")

        str= str.toUpperCase()
        str= str.toLowerCase()

        trim: eliminates whitespace at beginning/end of string
        trim()
         */

        /*

        PRIMITIVE VARIABLE MANIPULATIONS, ESPECIALLY CHARS

         */

        int a = 0;
        double b = 2.2;
//        what will casting do in this situation?
//        it will actually truncate (round down) the double b
//        especially in cases where whole numbers are expected, but you have a double
        a = (int) b;
        System.out.println(Math.floor(2.2));
        System.out.println(Math.ceil(2.2));
        System.out.println(Math.round(2.2));

        /*chars
        chars, even though they are appear as characters, they are actually numbers
        meaning, we can modify chars numerically
         */
        System.out.println("printing 'a' as int: "+ (int) 'a');
        System.out.println("printing 'a' + 5: "+ (char)('a'+5));




        /*
        You *are* allowed to use any method in coding challenges
        including:
        Collections,
        the most useful being ArrayLists and HashMaps,
        some form of set (for unique values)

        /*math functions:
        POW, FLOOR, CEIL, ROUND, MAX, MIN, SQRT, ABS (absolute value, especially for distance)
        RANDOM (with no args, random returns a random double 0-1, and you can multiply this
        by x amount to get random number 0-x)
        ARRAYS:
        sort, asList() (convert to collections list), toArray
        STREAMS:
        toStream(), filter(), map(), collect() -> asList()
         */

        /*
        usually, file reading code is provided for you
        in which case, you can, depending on the type of file reader,
        iterate through it using
        a while loop with the condition (line = fileReader.nextLine());
        To convert a String that should be an int to int:
        int a = Integer.parseInt("5");
        otherwise, you will get an error if you try
        a = "5";
        (unless you're a silly javascript developer)

        autoboxing/autounboxing
        happens automatically (as per the name)
        for converting Integer -> int
        and vice versa, and for all primitive types
         */

        /*for general coding challenge advice:
        if a problem seems hard, always turn to pseudocode
            write out the steps to solving a problem yourself
            kind of like how we may think of sorting or searching
            before we learned those algorithms:
            this is the first step to thinking through a new problem
        and printing out the current state of whatever variable/array
        you are working on in any iteration of your logic
        (like how we were printing out for every iteration of
        binary tree, sort, etc)

        as always, even if you can't solve the problem, submit *something*
        before the time is up
         */
    }
}
