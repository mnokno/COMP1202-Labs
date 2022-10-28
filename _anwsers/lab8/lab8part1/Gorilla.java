package lab8part1;

public class Gorilla extends Herbivore {

    public Gorilla(String name, int age){
        super(name, age);
    }
    public Gorilla() {super();}

    public void makeNoise(){
        System.out.println("gorilla noise");
    }

}
