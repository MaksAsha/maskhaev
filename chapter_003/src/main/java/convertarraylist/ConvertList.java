package convertarraylist;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {


    public final List<Integer> toList(final int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    public final int[][] toArray(final List<Integer> list, int rows) {
        int cols = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cols];
        int col = 0, row = 0;
        for (int i : list) {
            array[row][col++] = i;
            if (col == cols) {
                col = 0;
                row++;
            }
        }
        return array;
    }

    public final List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();

        for (int[] arr : list) {
            for (int i : arr) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
