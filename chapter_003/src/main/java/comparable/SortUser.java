package comparable;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        for (User user : list) {
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        User user1 = new User("Mike", 20);
        User user2 = new User("Nika", 18);
        User user3 = new User("Alex", 30);
        List<User> list = Arrays.asList(user1, user2, user3);
        Set<User> users = sortUser.sort(list);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
