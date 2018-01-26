package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayDuplicateTest {

    ArrayDuplicate arrayDuplicate;

    @Before
    public void setUp() {
        arrayDuplicate = new ArrayDuplicate();

    }

    @Test
    public void testRemoveAny() throws Exception {
        String[] data = new String[]{"Мир", "Привет", "Привет", "Мир", "Привет", "Супер", "Мир", "Мир"};

        String[] result = arrayDuplicate.remove(data);
        String[] expected = new String[]{"Привет", "Мир", "Супер"};
        Assert.assertThat(result, Matchers.arrayContainingInAnyOrder(expected));
    }

    @Test
    public void testRemoveAllEquals() throws Exception {
        String[] data = new String[]{"Мир", "Мир", "Мир", "Мир", "Мир"};

        String[] result = arrayDuplicate.remove(data);
        String[] expected = new String[]{"Мир"};
        Assert.assertThat(result, Matchers.arrayContainingInAnyOrder(expected));
    }

}