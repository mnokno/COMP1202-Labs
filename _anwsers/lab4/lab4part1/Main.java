package lab4part1;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        // gets user input using toolbox
        Toolbox toolbox = new Toolbox();
        int userInput = toolbox.readIntegerFromCmd();

        // print multiplication table of specified number up to 20
        for (int i = 1; i < 21; i++){
            System.out.println(i * userInput);
        }

        // calculates number of iteration required to get over 500

        int current = 0;
        int total = 0;

        while (total < 500){
            current++;
            total += current;
        }

        System.out.println(current);
    }
}
