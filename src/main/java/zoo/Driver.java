package zoo;

import cookies.Cookie;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Driver {

    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args){

        log.info("Hello logger!");

        System.out.println("cat".compareTo("dog"));
        System.out.println("dog".compareTo("cat"));
        Animal a1 = null;
        Animal a2 = null;
        Animal a3 = null;
        Animal a4 = null;
        Animal a5 = null;
        Animal a6 = null;

        try {
            a1 = new Animal("giraffe");
            a2 = new Animal("cow");
            a3 = new Animal("shark");
            a4 = new Animal("lion");
            a5 = new Animal("lion");
            a6 = new Animal("zebra");
        }catch(FakeAnimalException e){
            Driver.log.warn("Not real");
        }

        System.out.println(a1.compareTo(a2));

        System.out.println(a2.compareTo(a3));




        AnimalTree<Animal> tree = new AnimalTree<Animal>();
        AnimalTree<Cookie> tree2 = new AnimalTree<Cookie>();


        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Cookie> list2 = new ArrayList<>();

        /*
        why do we do this?
        the alternative is to have separate data structure implementations for all
        of the classes we're using
         */

        tree.add(a1);
        tree.add(a2);
        tree.add(a3);
        tree.add(a4);
        tree.add(a5);
        System.out.println("does the tree contain lion?");
        System.out.println(tree.contains(a5));
        System.out.println("does the tree contain zebra?");
        System.out.println(tree.contains(a6));

        /*
        Lists
            -ordered elements
            Array lists
            Linked lists
        Sets
            -unique elements
            Hashsets
            Treesets
        Queues
            -elements must be entered/removed in a specific order
            -stacks, queues
            arraydeque, priorityqueue
        Maps
            -key/value pairs, not necessarily iterable
            -treemap, hashmap


         */

        try{
            Animal a7 = new Animal("Bigfoot");
            tree.add(a7);
            if(tree.contains(a7)){
                Driver.log.info("Bigfoot's in the zoo!");
            }
        } catch (FakeAnimalException e) {
            Driver.log.warn("Not real");
        }


    }
}