package lab8part1;

public class Main {

    public static void main(String[] args) {
        Wolf wolf = new Wolf("Tom", 10);
        Parrot parrot = new Parrot("Jessy", 4);
        Meat meat = new Meat("meat");
        Plant plant = new Plant("plant");

        try{
            wolf.eat(plant);
            parrot.eat(meat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
