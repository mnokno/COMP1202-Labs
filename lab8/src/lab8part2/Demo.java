package lab8part2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Interface is a set of functionality classes can implement as many interfaces as they want
 * while abstract classes act as a parent classes and a class can only extend one abstract class.
 */
public class Demo {

    public static void main(String[] args){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 25; j++){
                switch (i) {
                    case 0 -> animals.add(new Gorilla(String.valueOf(j + 100), j));
                    case 1 -> animals.add(new Parrot(String.valueOf( j + 200), j));
                    default -> animals.add(new Wolf(String.valueOf(j + 300), j));
                }
            }
        }

        for (Animal a: animals){
            System.out.println(a.getName() + " " + a.getAge());
        }

        System.out.println("---------------");
        Collections.sort(animals);
        // to get highest to lowest you simply reverse the collection or change Animal.compareTo

        for (Animal a: animals){
            System.out.println(a.getName() + " " + a.getAge());
        }
    }
}
