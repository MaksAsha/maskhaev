package comparable;

import java.util.*;

public class SortUser {

    class UserComparator implements Comparator<User> {
        public int compare(User a, User b) {
            return a.getName().length() - b.getName().length();
        }
    }

    class UserComparatorEx implements Comparator<User> {
        public int compare(User a, User b) {
            int res = a.getName().compareTo(b.getName());
            return res != 0 ? res : a.getAge() - b.getAge();
        }
    }

    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>();
        for (User user : list) {
            users.add(user);
        }
        return users;
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator comparator = new UserComparator();
        Collections.sort(users, comparator);

        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator comparator = new UserComparatorEx();
        Collections.sort(users, comparator);

        return users;
    }

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        User user1 = new User("Mihael", 20);
        User user2 = new User("Nika", 18);
        User user3 = new User("Aleksander", 30);
        User user4 = new User("Mihael", 13);
        List<User> list = Arrays.asList(user1, user2, user3, user4);
        sortUser.sortNameLength(list);

        for (User user : sortUser.sortByAllFields(list)) {
            System.out.println(user);
        }
    }
}
