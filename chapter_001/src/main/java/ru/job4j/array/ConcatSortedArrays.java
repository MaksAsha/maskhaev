package ru.job4j.array;

public class ConcatSortedArrays {

    public int[] concatAndSort(int[] arr1, int[] arr2) {

        int[] out;

        if (arr1 == null && arr2 == null) {
            out = null;
        } else if (arr1 == null) {
            out = arr2;
        } else if (arr2 == null) {
            out = arr1;
        } else if (arr1.length == 0 && arr2.length == 0) {
            out = new int[]{};
        } else {

            int length = arr1.length + arr2.length;
            out = new int[length];
            int k = 0;
            int i = 0;
            int j = 0;
            while (k < length) {
                if (i < arr1.length && j < arr2.length) {
                    if (arr1[i] < arr2[j]) {
                        out[k++] = arr1[i++];
                    } else if (arr1[i] == arr2[j]) {
                        out[k++] = arr1[i++];
                        out[k++] = arr2[j++];
                    } else if (arr1[i] > arr2[j]) {
                        out[k++] = arr2[j++];
                    }
                } else {
                    if (i >= arr1.length) {
                        out[k++] = arr2[j++];
                    } else if (j >= arr2.length) {
                        out[k++] = arr1[i++];
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        ConcatSortedArrays arrays = new ConcatSortedArrays();

        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,2,3,16};
        int[] out = arrays.concatAndSort(arr1, arr2);

        System.out.println(out);
        for(int i:out){
            System.out.println(i+",");
        }
    }

}
