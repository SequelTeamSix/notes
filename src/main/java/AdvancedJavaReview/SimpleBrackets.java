package AdvancedJavaReview;

public class SimpleBrackets {
    public static void main(String[] args){
//        we take in a string of curly brackets {{}},
//        and we check if it's 'valid'
//        meaning, we never close brackets that were never opened
//        and we finish the string with all brackets closed
//        meaning:
//        valid:
        /* {}, {{}}, , {{}{}}
        invalid:
        }}{{, {{}, {{}}{
         */
        System.out.println(checkValidBraces("{{}}"));
        System.out.println(checkValidBraces("}}{{"));
        System.out.println(checkValidBraces("}"));
    }
    public static boolean checkValidBraces(String in){
        int lefties = 0;
        for(int i = 0; i < in.length(); i++){
            if(lefties < 0){
                return false;
            }
            if(in.charAt(i)=='{'){
                lefties++;
            }else if(in.charAt(i)=='}'){
                lefties--;
            }

        }
        return lefties == 0;

    }
}
