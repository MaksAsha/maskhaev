package test_collections;

import java.util.*;

public class Test {

    List<String> arrayList = new ArrayList<>();
    List<String> linkedList = new LinkedList<>();
    Set<String> treeSet = new TreeSet<>();

    public final static int SIZE = 1_000_000;
    public final static int DELETE = 10_000;

    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add("text" + i);
        }
        return System.currentTimeMillis() - start;
    }

    public long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove("text" + i);
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {

        long duration;
        Test test = new Test();
        //duration = test.add(test.arrayList, SIZE);
        //System.out.println("Creating duration="+duration);
        //duration = test.delete(test.arrayList, DELETE);
        //System.out.println("Deleting duration="+duration);

        //duration = test.add(test.linkedList, SIZE);
        //System.out.println("Duration="+duration);
        //duration = test.delete(test.linkedList, DELETE);
        //System.out.println("Deleting duration="+duration);

        duration = test.add(test.treeSet, SIZE);
        System.out.println("Duration=" + duration);
        duration = test.delete(test.treeSet, DELETE);
        System.out.println("Deleting duration=" + duration);

    }


}
