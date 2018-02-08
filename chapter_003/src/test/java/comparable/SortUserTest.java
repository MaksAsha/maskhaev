package comparable;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortUserTest {
    @Test
    public void sortNameLength() throws Exception {
        SortUser sortUser = new SortUser();
        User user1 = new User("Mihael", 20);
        User user2 = new User("Nika", 18);
        User user3 = new User("Aleksander", 30);
        User user4 = new User("Mihael", 13);
        List<User> list = Arrays.asList(user1, user2, user3, user4);
        List<User> expected = Arrays.asList(user2, user1, user4, user3);
        List<User> actual = sortUser.sortNameLength(list);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void sortByAllFields() throws Exception {
        SortUser sortUser = new SortUser();
        User user1 = new User("Mihael", 20);
        User user2 = new User("Nika", 18);
        User user3 = new User("Aleksander", 30);
        User user4 = new User("Mihael", 13);
        List<User> list = Arrays.asList(user1, user2, user3, user4);
        List<User> expected = Arrays.asList(user3, user4, user1, user2);
        List<User> actual = sortUser.sortByAllFields(list);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void sort() throws Exception {
        SortUser sortUser = new SortUser();
        User user1 = new User("Mike", 20);
        User user2 = new User("Nika", 18);
        User user3 = new User("Alex", 30);
        List<User> list = Arrays.asList(user1, user2, user3);
        List<User> actual = sortUser.sort(list).stream().collect(Collectors.toList());
        List<User> expected = Arrays.asList(user2, user1, user3);
        Assert.assertThat(actual, Matchers.is(expected));
    }

}