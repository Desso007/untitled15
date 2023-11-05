import java.util.*;
import java.util.stream.Collectors;

public class AnimalSolverTest {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Gender.M, 5, 30, 4, false),
                new Animal("Dog", Animal.Type.DOG, Animal.Gender.F, 7, 40, 6, true),
                new Animal("Bird", Animal.Type.BIRD, Animal.Gender.M, 2, 20, 2, false)
        );

        // Problem 1: Sort animals by height from smallest to largest
        List<Animal> sortedByHeight = AnimalSolver.sortAnimalsByHeight(animals);
        System.out.println("Sorted by height:");
        for (Animal animal : sortedByHeight) {
            System.out.println(animal.getName() + " - " + animal.getHeight());
        }

        // Problem 2: Sort animals by weight from heaviest to lightest and select the first k
        int k = 2;
        List<Animal> sortedByWeight = AnimalSolver.sortAnimalsByWeight(animals, k);
        System.out.println("\nSorted by weight (top " + k + "):");
        for (Animal animal : sortedByWeight) {
            System.out.println(animal.getName() + " - " + animal.getWeight());
        }

        // Problem 3: Count animals of each type
        Map<Animal.Type, Integer> countByType = AnimalSolver.countAnimalsByType(animals);
        System.out.println("\nCount by type:");
        for (Map.Entry<Animal.Type, Integer> entry : countByType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Problem 4: Find the animal with the longest name
        Animal animalWithLongestName = AnimalSolver.findAnimalWithLongestName(animals);
        System.out.println("\nAnimal with longest name: " + animalWithLongestName.getName());

        // Problem 5: Determine which gender is more numerous
        String moreNumerousGender = AnimalSolver.getMoreNumerousGender(animals);
        System.out.println("\nMore numerous gender: " + moreNumerousGender);

        // Problem 6: Find the heaviest animal of each type
        Map<Animal.Type, Animal> heaviestByType = AnimalSolver.findHeaviestAnimalsOfEachType(animals);
        System.out.println("\nHeaviest by type:");
        for (Map.Entry<Animal.Type, Animal> entry : heaviestByType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
    }
}
