package lab4part2;

import java.util.ArrayList;

public class UserGroup {

    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addSampleData(){
        for (int i = 0; i < 10; i++){
            users.add(new User(Integer.toString(i), Integer.toString(i), Integer.toString(i)));
        }
    }

    public User getUser(int index){
        return  users.get(index);
    }

    public void printUsernames(){
        for (User user : users){
            System.out.println(user.getUsername() + " " + user.getUserType());
        }
    }
}
