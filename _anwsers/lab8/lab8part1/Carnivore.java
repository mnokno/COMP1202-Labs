package lab8part1;

public abstract class Carnivore extends Animal {
    public Carnivore(String name, int age) {
        super(name, age);
    }
    public Carnivore() {super();}

    public void eat(Food food) throws Exception{
        if (!(food instanceof Meat))
        {
            throw new Exception("Carnivore can only eat Meat!");
        }
        System.out.println(getName() + " is eating " + food.getName());
    }
}
