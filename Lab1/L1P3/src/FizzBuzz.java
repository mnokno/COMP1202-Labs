// definition of the class FizzBuzz
public class FizzBuzz {

    // definition of the method for FizzBuzz class
    public static void main(String[] args){

        // creates a loop that iterates between 1 and 60 with step 1
        for(Integer i = new Integer(1); i < 61; i++){

            // executes scope of this if statement if the current number is a multiple of 3
            if(i % 3 == 0){
                // outputs "Fizz" to the console without a line brake in case we want to add "Buzz"
                System.out.print("Fizz");
            }

            // executes scope of this if statement if the current number is a multiple of 5
            if(i % 5 == 0){
                // outputs "Buzz" to the console without a line brake because,
                // we add a line brake at the end of each iteration
                System.out.print("Buzz");
            }

            // executes scope of this if statement if the current number is nighter number a multiple of 3 or 5
            if(i % 3 != 0 && i % 5 != 0){
                System.out.print(i);
            }

            // Adds the line brake since we have finished this iteration and want to move to the next number
            System.out.println();
        }
    }
}
