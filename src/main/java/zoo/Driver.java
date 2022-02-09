package zoo;

import cookies.Cookie;

public class Driver {

    public static void main(String[] args){

        System.out.println("cat".compareTo("dog"));
        System.out.println("dog".compareTo("cat"));

        Animal a1 = new Animal("giraffe");
        Animal a2 = new Animal("cow");
        Animal a3 = new Animal("shark");
        Animal a4 = new Animal("lion");
        Animal a5 = new Animal("lion");

        System.out.println(a1.compareTo(a2));

        System.out.println(a2.compareTo(a3));



        AnimalTree tree = new AnimalTree();

        tree.add(a1);
        tree.add(a2);
        tree.add(a3);
        tree.add(a4);
        tree.add(a5);
        tree.add(a1);

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


    }
}