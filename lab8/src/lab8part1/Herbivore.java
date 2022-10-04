package lab8part1;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws Exception{
        if (!(food instanceof Plant))
        {
            throw new Exception("Carnivore can only eat Plants!");
        }
        System.out.println(getName() + " is eating " + food.getName());
    }
}
