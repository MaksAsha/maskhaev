package ru.job4j.array;

public class ArrayConcat {

    int SORT_TYPE = 1;

    //SORT_TYPE==1, quicksort
    //SORT_TYPE==2, bubblesort
    public ArrayConcat(int SORT_TYPE) {
        this.SORT_TYPE = SORT_TYPE;
    }

    //сначала объединяем в один массив, затем сортируем в конечном массиве
    public int[] concatAndSort(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 == null) {
            return null;
        } else if (arr1 == null) {
            return sort(SORT_TYPE, arr2);
        } else if (arr2 == null) {
            return sort(SORT_TYPE, arr1);
        } else if (arr1.length == 0 && arr2.length == 0) {
            return new int[]{};
        }

        int length = arr1.length + arr2.length;
        int[] out = new int[length];

        System.arraycopy(arr1, 0, out, 0, arr1.length);
        System.arraycopy(arr2, 0, out, arr1.length, arr2.length);

        return sort(SORT_TYPE, out);
    }

    public int[] sort(int type, int[] arr) {
        int[] out = null;

        if (type == 1) {
            out = quickSort(arr, 0, arr.length - 1);
        }
        if (type == 2) {
            out = bubbleSort(arr);
        }
        return arr;
    }

    //Вариант 1 Быстрая сортировка (быстрый, эффективный алгоритм)
    private int[] quickSort(int[] arr, int first, int last) {
        int i = first, j = last, x = arr[(first + last) / 2];
        do {
            while (arr[i] < x) i++;
            while (arr[j] > x) j--;

            if (i <= j) {
                if (i < j) {
                    int l = arr[i];
                    arr[i] = arr[j];
                    arr[j] = l;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last)
            quickSort(arr, i, last);
        if (first < j)
            quickSort(arr, first, j);

        return arr;
    }

    //Вариант 2 Пузырьковая сортировка (медленный алгоритм)
    private int[] bubbleSort(int[] arr) {
        int length = arr.length;

        for (int j = 0; j < length - 1; j++) {
            for (int i = 0; i < length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int k = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = k;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) throws InterruptedException {

    }
}
