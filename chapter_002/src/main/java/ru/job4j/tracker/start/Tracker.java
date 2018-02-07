package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private List<Item> items = new ArrayList<>();
    private int position;
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item == null) {
                break;
            } else if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public List<Item> findByName(String key) {

        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item add(Item item) {

        if (item != null) {
            item.setId(this.generateId());
            items.add(item);
        }
        return item;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(this.generateId());
                items.set(i, item);
                break;
            }
        }
    }

    public void delete(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
            }
        }
    }

    public List<Item> findAll() {
        return items;
    }
}
