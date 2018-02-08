package comparable;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortUserTest {
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