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
    User user1, user2;
    List<User> list;

    @Before
    public void setUp() {
        userConvert = new UserConvert();

        user1 = new User(1, "User1", "Moscow");
        user2 = new User(2, "User2", "Bryansk");
        list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
    }

    @Test
    public void testProcess() throws Exception {
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(user1.getId(), user1);
        expected.put(user2.getId(), user2);

        HashMap<Integer, User> actual = userConvert.process(list);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    /*
    @Test
    public void testProcessEx() throws Exception {
        HashMap<Integer, User> expected = (HashMap<Integer, User>) Arrays.asList(user1, user2)
                .stream().collect(Collectors.toMap(User::getId, user->user));

        HashMap<Integer, User> actual = userConvert.processEx(list);
        Assert.assertThat(actual, Matchers.is(expected));
    }*/
}