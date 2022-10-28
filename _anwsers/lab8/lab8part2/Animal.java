package lab8part2;

public abstract class Animal implements Comparable<Animal> {

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

    @Override
    public int compareTo(Animal other){
        return -Integer.compare(other.age, this.age);
    }
}
