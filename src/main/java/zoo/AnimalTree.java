package zoo;

public class AnimalTree<T extends Comparable<T>> {

    AnimalBranch<T> head;

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
    public boolean add(T a){
        if(head ==null){
            Driver.log.info("Added as head: "+ a);
            head = new AnimalBranch(a);
        }else{
            AnimalBranch current = head;
            while(true) {
//                how do we decide if go left or right in the search tree?
//                we do this by having a method that compares the new item to whatever
//                branch we're looking at
                if (current.getAnimal().compareTo(a) < 0) {
                    Driver.log.info("Current animal: " + current + ", Branching left");
//                    what if we need to move left, but that space is empty?
//                    we set that new item to the new animal
//                    we also exit out of the add method: our job is complete
                    if (current.left == null) {
                        current.left = new AnimalBranch(a);
                        System.out.println("Added animal: " + a);
                        return true;
                    } else {
//                       what if the left node is already taken?
//                        the animal must then continue search the left and right of that node
//                        in which, we'll be going back to the while loop with a new
//                        current node
                        current = current.left;
                    }
                } else if (current.getAnimal().compareTo(a) > 0) {
                    Driver.log.info("Current animal: " + current + "Branching right");
                    if (current.right == null) {
                        current.right = new AnimalBranch(a);
                        Driver.log.info("Added animal: " + a);
                        return true;
                    } else {
                        current = current.right;
                    }
                }else{
                    Driver.log.info("Species " + a + "already exists!");
                    return false;
                }
            }
        }

        return false;

    }
    public boolean contains(T a){
        if(head ==null){
            System.out.println("Added as head: "+ a);
            return false;
        }else{
            AnimalBranch current = head;
            while(true) {
//                how do we decide if go left or right in the search tree?
//                we do this by having a method that compares the new item to whatever
//                branch we're looking at
                if (current.getAnimal().compareTo(a) < 0) {
                    Driver.log.info("Current animal: " + current + ", Branching left");
//                    what if we need to move left, but that space is empty?
//                    we set that new item to the new animal
//                    we also exit out of the add method: our job is complete
                    if (current.left == null) {
                        Driver.log.info("Animal does not exist: " + a);
                        return false;

                    } else {
//                       what if the left node is already taken?
//                        the animal must then continue search the left and right of that node
//                        in which, we'll be going back to the while loop with a new
//                        current node
                        current = current.left;
                    }
                } else if (current.getAnimal().compareTo(a) > 0) {
                    Driver.log.info("Current animal: " + current + "Branching right");
                    if (current.right == null) {
                        current.right = new AnimalBranch(a);
                        Driver.log.info("Animal does not exist: " + a);
                        return false;
                    } else {
                        current = current.right;
                    }
                }else{
                    Driver.log.info("Species " + a + "already exists!");
                    return true;
                }
            }
        }
    }

    public void traverse(){
        System.out.println("STARTING TRAVERSAL: ");
        AnimalBranch<T> current = head;
        traverseHelper(head);
    }
    public void traverseHelper(AnimalBranch<T> current){
//        print 'visiting branch for first time'
        System.out.println("Visiting branch "+ current+ " for the first time");
//        check the left branch
        if(current.getLeft()!=null){
//        if left branch is not null, then recurse to left branch
//          traverseHelper(left)
            System.out.println("Navigating to left branch");
            traverseHelper(current.getLeft());
        }
//        if we get to this point, the left hand side has been fully
//        explored
        System.out.println("Returned to "+current+" from left branch");
        if(current.getRight()!=null) {
//        if right branch is not null, then recurse to right branch
//          traverseHelper(right)
            traverseHelper(current.getRight());
        }
//        if we get to this point, right hand branch has been fully explored
        System.out.println("Returned to "+current+" from right branch");
        System.out.println(current+" Has been fully explored");
//        print 'branch has been fully explored'
//        we return from here
    }
/*
time complexity:

if the tree were balanced:
searching for an animal would scale logarithmically with regards
to expanding the total amounts of animals

compared to eg an unsorted array, in which case searching for something would expand
linearly with regards to the total amount of items
(ie, we iterate through everything)

eg:
linked list insert is O(1)
array insert is O(1)
tree insert is O(log(n))

let's say we have data structures where we maintain sorting
linked list insert in order is O(n)
array insert in order is O(n)
tree insert in order is O(log(n))
 */

}
