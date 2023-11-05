package edu;

public class Animal {


    public static Object Sex;
    private final String name;
    private final Type type;
    private final Gender gender;
    private final int age;
    private final int height;
    private final int weight;
    private final boolean bites;

    public Animal(String name, Type type, Gender gender, int age, int height, int weight, boolean bites) {
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bites = bites;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public boolean bites() {
        return bites;
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Gender {
        M, F
    }
}
