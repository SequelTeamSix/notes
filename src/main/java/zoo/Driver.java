package zoo;

import cookies.Cookie;

public class Driver {

    public static void main(String[] args){

        System.out.println("cat".compareTo("dog"));
        System.out.println("dog".compareTo("cat"));

        AnimalTree tree = new AnimalTree();
        tree.add(new Animal("giraffe"));
        tree.add(new Animal("cow"));
        tree.add(new Animal("shark"));
        tree.add(new Animal("lion"));
        tree.add(new Animal("gerbil"));
        tree.add(new Animal("gorilla"));


    }
}