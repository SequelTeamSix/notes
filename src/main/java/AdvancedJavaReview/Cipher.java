package AdvancedJavaReview;

public class Cipher {
    public static void main(String[] args){
//        string should be abcde, and we are saying we are working with a increment of 1 for cipher
        String scrambled = "abcdef";
        System.out.println(decipher(scrambled, 1));
        for(int i = 0; i < 255; i++){
//            System.out.println(i + ": " +(char)i);
        }
    }
    public static String decipher(String in, int increment){
        String deciphered = "";
        char[] charArray = in.toCharArray();
//        consider: chars are just numbers (they are represented as characters, but this is an illusion
        for(int i = 0; i < charArray.length; i++){
//            increment char values
            charArray[i]= (char) (charArray[i]-increment);
//            if char is less than 'a': then we shift over to the end of the alphabet
            if(charArray[i]<'a'){
                charArray[i]= (char) (charArray[i]+26);
            }
            deciphered+=charArray[i];
        }
        return deciphered;
    }
}
