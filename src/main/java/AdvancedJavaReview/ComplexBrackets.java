package AdvancedJavaReview;

import java.util.Stack;

public class ComplexBrackets {
    /*
    Same as simple brackets, but we now have not just curlies but square brackets and parantheses
    and these must all correspond to each other
    valid:
    ({[()]([])})
    ()[]
    invalid:
    ({)}
    3 opens - 3 closes
    1 of each open - the 1 of each closed
    ({[})]
    (({[})])



     */
    public static void main(String[] args){
        System.out.println(BracketSolver("[]{}()"));
        System.out.println(BracketSolver("[{()}]"));
        System.out.println(BracketSolver("[(]))]"));
    }

    public static boolean BracketSolver(String in){
        if(in.length() % 2 == 1){
            return false;
        }
        Stack<Character> charStack = new Stack<Character>();
        for(int i = 0; i < in.length(); i++){
            char current = in.charAt(i);
//            if left bracket, push it to a stack
//
            if(current=='(' || current=='{' || current=='['){
                charStack.push(current);
                System.out.println("adding left bracket " + current);
            }else if(current == ')' || current == '}' || current == ']'){
//  [{(([]]
                char popped = charStack.pop();
                System.out.println("comparing right bracket " + popped + "to right bracket " +
                        current);
                if(popped=='('&&current==')'){

                }else if(popped=='{'&&current=='}'){

                }else if(popped=='['&&current==']'){

                }else{
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
