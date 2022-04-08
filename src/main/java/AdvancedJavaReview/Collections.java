package AdvancedJavaReview;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeSet;

public class Collections {
    public static void main(String[] args) {
        HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
        TreeSet<String> myTreeSet = new TreeSet<>();
        Stack<String> myStack = new Stack<String>();
//        this is basically our queue:
        ArrayDeque<String> myDeque = new ArrayDeque<>();
//        StringReverse reverse = new StringReverse();
        myHashMap.put(1, "string 1");
        myHashMap.put(2, "string 2");
        System.out.println(myHashMap.get(2));
        myStack.push("item 1");
        myStack.push("item 2");
        myStack.push("item 3");
        System.out.println(myStack.pop());
        myStack.push("item 4");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
//      when talking about the stack vs heap, you might talk about the 'call stack' -
//        because this ordering reflects how methods are called and later returned to
        myDeque.add("deque 1");
        myDeque.add("deque 2");
        myDeque.add("deque 3");
        myDeque.add("deque 4");
        myDeque.add("deque 5");
        myDeque.add("deque 6");
//        look without removing
        System.out.println(myDeque.peek());
//        pop, poll, remove, removefirst equivalent
        System.out.println(myDeque.pop());
        System.out.println(myDeque.remove());
        System.out.println(myDeque.removeLast());

    }
}
