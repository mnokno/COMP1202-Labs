package lab8part2;

public abstract class Omnivore extends Animal {
    public Omnivore(String name, int age) {
        super(name, age);
    }
    public Omnivore() {super();}

    public void eat(Food food){
        System.out.println(getName() + " is eating " + food.getName());
    }
}
