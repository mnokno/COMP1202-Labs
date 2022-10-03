package lab6part3;

public abstract class Carnivore extends Animal {
    public Carnivore(String name, int age) {
        super(name, age);
    }

    public void eat(Food food) throws Exception{
        if (!(food instanceof Meat))
        {
            throw new Exception("Carnivore can only eat Meat!");
        }
        System.out.println(getName() + " is eating " + food.getName());
    }
}
