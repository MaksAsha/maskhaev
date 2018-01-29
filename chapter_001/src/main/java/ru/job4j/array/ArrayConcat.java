package ru.job4j.array;

public class ArrayConcat {


    public int[] concatAndSort(int[] arr1, int[] arr2){
        int length = 0;
        int[] out = null;
        if ((arr1 == null) && (arr2 == null)) throw new IllegalArgumentException();

        if (arr1 != null) {length = arr1.length;}
        if (arr2 != null) {length += arr2.length;}
        out = new int[length];

        if (length > 0){
            int offset = 0;
            if ((arr1!=null)&&(arr1.length>0)) {System.arraycopy(arr1, 0, out, 0, arr1.length); offset = arr1.length;}
            if ((arr2!=null)&&(arr2.length>0)) {System.arraycopy(arr2, 0, out, offset, arr2.length);}

            for (int j = 0; j < out.length - 1; j++) {
                for (int i = 0; i < out.length - 1 - j; i++) {
                    if (out[i] > out[i + 1]) {
                        int k = out[i];
                        out[i] = out[i + 1];
                        out[i + 1] = k;
                    }
                }
            }
        }
        return out;
    }
}
