package lab8part1;

import java.util.Collection;

public abstract class Animal{

    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Animal(){
        this.name = "newborn";
        this.age = 0;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public abstract void makeNoise();
    public abstract void eat(Food food) throws Exception;

    public void eat(Food food, Integer quantity) throws Exception {
        for (int i = 0; i < quantity; i++){
            eat(food);
        }
    }
}
