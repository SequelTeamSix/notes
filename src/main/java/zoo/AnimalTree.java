package zoo;

public class AnimalTree {

    AnimalBranch head;

    public AnimalTree() {

    }


//    process:
//    check if head exists
//    if exists, check if left child exists
//    if left child exists, switch currently examined branch to left child
//    new branch is greater than current branch, so check if right child exists
//    right child does not exist, so we set current.right to a new animalBranch

//    our toolbox:
//    we will need to keep track of the current branch
//    we will need to continue while a empty slot has not been found
//    we will need to check if head is null first

//    return true if adding was successful
    public boolean add(Animal a){
        if(head ==null){
            System.out.println("Added as head: "+ a.species);
            head = new AnimalBranch(a);
        }else{
            AnimalBranch current = head;
            while(true) {
//                how do we decide if go left or right in the search tree?
//                we do this by having a method that compares the new item to whatever
//                branch we're looking at
                if (current.getAnimal().compareTo(a) == -1) {
                    System.out.println("Current animal: " + a.species + "Branching left");
//                    what if we need to move left, but that space is empty?
//                    we set that new item to the new animal
//                    we also exit out of the add method: our job is complete
                    if (current.left == null) {
                        current.left = new AnimalBranch(a);
                        System.out.println("Added animal: " + a.species);
                        return true;
                    } else {
//                       what if the left node is already taken?
//                        the animal must then continue search the left and right of that node
//                        in which, we'll be going back to the while loop with a new
//                        current node
                        current = current.left;
                    }
                } else if (current.getAnimal().compareTo(a) == 1) {
                    System.out.println("Current animal: " + a.species + "Branching right");
                    if (current.right == null) {
                        current.right = new AnimalBranch(a);
                        System.out.println("Added animal: " + a.species);
                        return true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }

        return false;

    }

}
