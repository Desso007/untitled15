package edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AnimalSolverTest {

    @Test
    public void testSortAnimalsByHeight() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        List<Animal> sortedAnimals = AnimalProcessor.sortAnimalsByHeight(animals);

        Assertions.assertEquals(3, sortedAnimals.size());
        Assertions.assertEquals("Bird", sortedAnimals.get(0).name());
        Assertions.assertEquals("Cat", sortedAnimals.get(1).name());
        Assertions.assertEquals("Dog", sortedAnimals.get(2).name());
    }

    @Test
    public void testSortAnimalsByWeight() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        int k = 2;
        List<Animal> sortedAnimals = AnimalProcessor.sortAnimalsByWeight(animals, k);

        Assertions.assertEquals(k, sortedAnimals.size());
        Assertions.assertEquals("Dog", sortedAnimals.get(0).name());
        Assertions.assertEquals("Cat", sortedAnimals.get(1).name());
    }

    @Test
    public void testCountAnimalsByType() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        Map<Animal.Type, Integer> countByType = AnimalProcessor.countAnimalsByType(animals);

        Assertions.assertEquals(3, countByType.size());
        Assertions.assertEquals(1, countByType.get(Animal.Type.CAT));
        Assertions.assertEquals(1, countByType.get(Animal.Type.DOG));
        Assertions.assertEquals(1, countByType.get(Animal.Type.BIRD));
    }

    @Test
    public void testFindAnimalWithLongestName() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Doggy", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Birdie", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        Animal animalWithLongestName = AnimalProcessor.findAnimalWithLongestName(animals);

        Assertions.assertNotNull(animalWithLongestName);
        Assertions.assertEquals("Birdie", animalWithLongestName.name());
    }

    @Test
    public void testGetMoreNumerousGender() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Doggy", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Birdie", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        String moreNumerousGender = AnimalProcessor.getMoreNumerousGender(animals);

        Assertions.assertEquals("equal", moreNumerousGender);
    }

    @Test
    public void testFindHeaviestAnimalsOfEachType() {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 4, false),
                new Animal("Doggy", Animal.Type.DOG, Animal.Sex.F, 7, 40, 6, true),
                new Animal("Birdie", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 2, false)
        );

        Map<Animal.Type, Animal> heaviestByType = AnimalProcessor.findHeaviestAnimalsOfEachType(animals);

        Assertions.assertEquals(3, heaviestByType.size());
        Assertions.assertEquals("Cat", heaviestByType.get(Animal.Type.CAT).name());
        Assertions.assertEquals("Doggy", heaviestByType.get(Animal.Type.DOG).name());
        Assertions.assertEquals("Birdie", heaviestByType.get(Animal.Type.BIRD).name());
    }
}