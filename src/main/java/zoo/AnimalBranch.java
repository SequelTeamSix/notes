package zoo;

public class AnimalBranch<T extends Comparable<T>> {

    private T animal;
    AnimalBranch left;
    AnimalBranch right;

    public AnimalBranch() {

    }
    public AnimalBranch(T a){
        animal = a;
    }
    public int compareTo(AnimalBranch<T> a){
        return animal.compareTo(a.animal);
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

    @Override
    public String toString() {
        return animal.toString();
    }

}
