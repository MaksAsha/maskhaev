package convertarraylist;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        ConvertList convertList = new ConvertList();
        int[][] arr;

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        arr = convertList.toArray(list, 3);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
    }
}
