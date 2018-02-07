package listmap;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list){
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list){
            map.put(user.getId(), user);
        }
        return map;
    }

    /*
    public HashMap<Integer, User> processEx(List<User> list){
        HashMap<Integer, User> map;
        map = (HashMap<Integer, User>)list.stream().collect(Collectors.toMap(User::getId, user->user));
        return map;
    }*/

}
