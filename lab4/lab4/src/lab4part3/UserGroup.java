package lab4part3;

import lab4part2.User;

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

    public void removeFirstUser(){
        users.remove(0);
    }

    public void removeLastUser(){
        users.remove(users.size() - 1);
    }

    public void removerUser(String username){
        // Let's assume that duplicated usernames are not allowed
        //TODO
    }
}
