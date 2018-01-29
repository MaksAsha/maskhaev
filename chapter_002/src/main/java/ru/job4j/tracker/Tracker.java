package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position;
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item == null) break;
            else if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = null;
        int k = 0;
        for (Item item : items) {
            if (item == null) break;
            else if (item.getName().equals(key)) {
                k++;
            }
        }

        if (k > 0) {
            result = new Item[k];
            k = 0;
            for (Item item : items) {
                if (item == null) break;
                else if (item.getName().equals(key)) {
                    result[k] = item;
                    k++;
                }
            }
        }
        return result;
    }

    public Item add(Item item) {
        if (position > 99) throw new IndexOutOfBoundsException();

        if (item != null) {
            item.setId(this.generateId());
            this.items[position++] = item;
        }
        return item;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if ((items[i]!=null)&&(items[i].getId().equals(id))) {
                item.setId(this.generateId());
                items[i] = item;
                break;
            }
        }
    }

    public void delete(String id) {
        Item[] result = null;
        if (id != null) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) break;
                else if (items[i].getId().equals(id)) {
                    result = new Item[items.length];
                    if (i == 0) {
                        System.arraycopy(items, 1, result, 0, items.length);
                    }
                    if (i > 0) {
                        System.arraycopy(items, 0, result, 0, i);
                        System.arraycopy(items, i + 1, result, i, position - i);
                    }
                    position--;
                    break;
                }
            }
        }
        if (result != null) {
            items = result;
        }
    }

    public Item[] findAll() {
        Item[] result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                result = Arrays.copyOf(this.items, i);
                break;
            }
        }
        return result;
    }
}
