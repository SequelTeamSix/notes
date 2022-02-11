

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zoo.Animal;
import zoo.AnimalTree;
import zoo.FakeAnimalException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AnimalTreeTest {

    /*What's junit - a testing framework for Java
    * What's unit testing - unit testing tests a small unit of our code
    * (such as the functionality of a single method of a single class
    *
    * Annotations?
    * @Test
    * @BeforeAll
    * @AfterAll
    * @BeforeEach
    * @AfterEach
    *
    * TDD?
    * Test Driven Development
    *   Tests are written BEFORE implementation,
    *   Progress on implementation can be measured by the completion of additional tests
    *
    * Assert?
    * In order for a test to pass, we must assert that some properties are fulfilled
    * Example: we can assert that some items are equal to each other
    * We can assert that some conditional is true
    *
    * Testing?
    * Expected vs Observed values
    * IE: if we havent added monkey to animaltree,
    * we expect animaltree.contains monkey to return false
    * so we assert that animaltree.contains monkey is NOT true
    *
    * Testing - in a realistic environment, code is updated too often to manually
    * test everything
    * */


    @BeforeAll
    public static void initialSetup(){

    }
    @BeforeEach
    public void setup(){

    }
    @AfterEach
    public void tearDown(){

    }

    @Test
    public void ContainsOneAddedAnimal() throws FakeAnimalException {
        AnimalTree<Animal> tree1 = new AnimalTree<Animal>();
        Animal a1 = new Animal("Giraffe");
        tree1.add(a1);
        assertTrue(tree1.contains(a1));
    }
    @Test
    public void ContainsTwoAddedAnimal() throws FakeAnimalException {
        AnimalTree<Animal> tree1 = new AnimalTree<Animal>();
        Animal a1 = new Animal("Giraffe");
        Animal a2 = new Animal("Lion");
        tree1.add(a1);
        tree1.add(a2);
        assertTrue(tree1.contains(a2));
    }
    @Test
    public void DoesNotContainAnimal() throws FakeAnimalException {
        AnimalTree<Animal> tree1 = new AnimalTree<Animal>();
        Animal a1 = new Animal("Giraffe");
        Animal a2 = new Animal("Lion");
        Animal a3 = new Animal("Monkey");
        tree1.add(a1);
        tree1.add(a2);
        assertTrue(!(tree1.contains(a3)));
    }
}
