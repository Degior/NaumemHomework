package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ArrayList<User> users = (ArrayList<User>) createUsers(100000, 0);
        ArrayList<User> users2 = (ArrayList<User>) createUsers(10000, 14322);
        List<User> duplicates = User.findDuplicates(users, users2);
        System.out.println(duplicates);
    }

    public static List<User> createUsers(int count, int start) {
        ArrayList<User> users = new ArrayList<User>();
        for (int i = start; i < count + start; i++) {
            users.add(new User("user" + i, "user" + i + "@example.com", new byte[0]));
        }
        return users;
    }

}
