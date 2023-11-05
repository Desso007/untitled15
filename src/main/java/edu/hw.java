package edu;
import java.util.*;
import java.util.stream.Collectors;

public class hw {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Animal("Cat", Animal.Type.CAT, Animal.Gender.M, 5, 30, 4, false),
                new Animal("Dog", Animal.Type.DOG, Animal.Gender.F, 7, 40, 6, true),
                new Animal("Bird", Animal.Type.BIRD, Animal.Gender.M, 2, 20, 2, false)
        );


        List<Animal> sortedByHeight = sortAnimalsByHeight(animals);
        System.out.println("Sorted by height:");
        for (Animal animal : sortedByHeight) {
            System.out.println(animal.getName() + " - " + animal.getHeight());
        }


        int k = 2;
        List<Animal> sortedByWeight = sortAnimalsByWeight(animals, k);
        System.out.println("\nSorted by weight (top " + k + "):");
        for (Animal animal : sortedByWeight) {
            System.out.println(animal.getName() + " - " + animal.getWeight());
        }


        Map<Animal.Type, Integer> countByType = countAnimalsByType(animals);
        System.out.println("\nCount by type:");
        for (Map.Entry<Animal.Type, Integer> entry : countByType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        Animal animalWithLongestName = findAnimalWithLongestName(animals);
        System.out.println("\nAnimal with longest name: " + animalWithLongestName.getName());


        String moreNumerousGender = getMoreNumerousGender(animals);
        System.out.println("\nMore numerous gender: " + moreNumerousGender);


        Map<Animal.Type, Animal> heaviestByType = findHeaviestAnimalsOfEachType(animals);
        System.out.println("\nHeaviest by type:");
        for (Map.Entry<Animal.Type, Animal> entry : heaviestByType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }

    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream()
                .sorted(Comparator.comparingInt(Animal::getHeight))
                .collect(Collectors.toList());
    }

    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {
        return animals.stream()
                .sorted(Comparator.comparingInt(Animal::getWeight).reversed())
                .limit(k)
                .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::getType, Collectors.summingInt(a -> 1)));
    }

    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
                .max(Comparator.comparingInt(a -> a.getName().length()))
                .orElse(null);
    }

    public static String getMoreNumerousGender(List<Animal> animals) {
        long males = animals.stream().filter(a -> a.getGender() == Animal.Gender.M).count();
        long females = animals.size() - males;

        if (males > females) {
            return "males";
        } else if (females > males) {
            return "females";
        } else {
            return "equal";
        }
    }

    public static Map<Animal.Type, Animal> findHeaviestAnimalsOfEachType(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviestByType = new HashMap<>();

        for (Animal animal : animals) {
            if (!heaviestByType.containsKey(animal.getType()) || animal.getWeight() > heaviestByType.get(animal.getType()).getWeight()) {
                heaviestByType.put(animal.getType(), animal);
            }
        }

        return heaviestByType;
    }

}

