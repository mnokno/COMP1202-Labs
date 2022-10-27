package lab4part3;

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

        UserGroup userGroup = new UserGroup();
        userGroup.addSampleData();
        userGroup.printUsernames();

        System.out.println("--------------------------------");

        UserGroup administrators = new UserGroup();
        Iterator<User> allUsers = userGroup.getUserIterator();
        while (allUsers.hasNext()){
            User next = allUsers.next();
            if (next.getUserType() == "admin"){
                administrators.addUser(next);
            }
        }
        administrators.printUsernames();

        System.out.println("--------------------------------");

        // This only changes user type but does not remove the user from the current user group
        // which is named administrators which implies it should only contain admin type users.
        // This can be fixed by removing the admin after being changed to a user
        administrators.getUser(administrators.getUsers().size() - 1).setUserType("user");

        administrators.printUsernames();
        System.out.println("::::::::::::::");
        userGroup.printUsernames();
    }
}
