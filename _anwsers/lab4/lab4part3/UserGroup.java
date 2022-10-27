package lab4part3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class UserGroup {

    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addSampleData(){
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            users.add(new User(Integer.toString(i), random.nextBoolean() ? "admin" : "other", Integer.toString(i)));
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

    public void removeUser(String username){
        // Let's assume that duplicated usernames are not allowed
        int indexToRemove = -1;
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername() == username){
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1){
            users.remove(indexToRemove);
        }
    }

    public Iterator<User> getUserIterator(){
        return users.iterator();
    }

    public void addUser(User user){
        users.add(user);
    }
}
