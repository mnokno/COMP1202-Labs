package lab8part1;

public class Parrot extends Herbivore {

    public Parrot(String name, int age){
        super(name, age);
    }
    public Parrot() {super();}

    public Parrot(int age){
        super("Polly", age);
    }

    public void makeNoise(){
        System.out.println("parrot noise");
    }
}
