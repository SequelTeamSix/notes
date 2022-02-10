package zoo;

public class AnimalBranch<T extends Comparable<T>> implements Comparable<AnimalBranch>{

    private T animal;
    AnimalBranch left;
    AnimalBranch right;

    public AnimalBranch() {

    }
    public AnimalBranch(T a){
        animal = a;
    }
    public int compareTo(AnimalBranch a){
        return animal.compareTo((T) a.getAnimal());
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public AnimalBranch getLeft() {
        return left;
    }

    public void setLeft(AnimalBranch left) {
        this.left = left;
    }

    public AnimalBranch getRight() {
        return right;
    }

    public void setRight(AnimalBranch right) {
        this.right = right;
    }


}
