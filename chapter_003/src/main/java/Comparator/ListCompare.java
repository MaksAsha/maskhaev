package Comparator;

import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
        int min, res;
        min = left.size() <= right.size() ? left.size() : right.size();
        res = Integer.compare(left.size(), right.size());

        for (int i = 0; i < min; i++) {
            if (left.get(i) < right.get(i)) {
                result = -1;
                break;
            }
            if (left.get(i) > right.get(i)) {
                result = 1;
                break;
            }
        }

        if (result == 0) {
            result = res;
        }

        return result;
    }
}
