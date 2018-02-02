package ru.job4j.tracker.start;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void testAskWhenEnterNotNumber() throws Exception {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        input.ask("Enter", MenuEnum.getMenuItems());
        Assert.assertThat(
                mem.toString(),
                Matchers.is(String.format("Please, enter validate menu item value%n"))
        );
    }

    @Test
    public void testAskWhenEnterNumberNotInRange() throws Exception {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"100", "1"}));
        input.ask("Enter", MenuEnum.getMenuItems());
        Assert.assertThat(
                mem.toString(),
                Matchers.is(String.format("Please, enter validate menu item value%n"))
        );
    }

    @Test
    public void testAskWhenEnterActualCommand() throws Exception {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"1", "1"}));
        int actual = input.ask("Enter", MenuEnum.getMenuItems());
        Assert.assertThat(
                actual,
                Matchers.is(1)
        );
    }
}