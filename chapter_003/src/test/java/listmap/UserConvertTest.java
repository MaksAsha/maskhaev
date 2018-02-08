package listmap;

import convertarraylist.ConvertList;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class UserConvertTest {

    UserConvert userConvert;
    User user1, user2, user3;
    List<User> list;

    @Test
    public void testProcess() throws Exception {
        userConvert = new UserConvert();

        user1 = new User(1, "User1", "Moscow");
        user2 = new User(2, "User2", "Bryansk");
        user3 = new User(3, "", "");
        list = new ArrayList<>();

        HashMap<Integer, User> expected = new HashMap<>();
        list.add(user1);
        list.add(user2);
        expected.put(user1.getId(), user1);
        expected.put(user2.getId(), user2);

        HashMap<Integer, User> actual = userConvert.process(list);

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testProcessWhenListIsEmpty() throws Exception {
        userConvert = new UserConvert();
        HashMap<Integer, User> expected = new HashMap<>();
        list = new ArrayList<>();

        HashMap<Integer, User> actual = userConvert.process(list);

        Assert.assertThat(actual, Matchers.is(expected));
    }
}