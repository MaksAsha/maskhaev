package ru.job4j.dummybot;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Maksim Askhaev (maksim.askhaev@gmail.com)
 * Тесты класса DummyBot
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {

    DummyBot bot;

    @Before
    public void initTest() {
        bot = new DummyBot();
    }

    @Test
    public void testAnswerWhenGreet() throws Exception {
        Assert.assertThat(bot.answer("Привет, бот!"), Matchers.is("Привет, умник!"));
    }

    @Test
    public void testAnswerWhenBye() throws Exception {
        Assert.assertThat(bot.answer("Пока"), Matchers.is("До скорой встречи!"));
    }

    @Test
    public void testAnswerWhenUnknown() throws Exception {
        Assert.assertThat(bot.answer("Как дела?"), Matchers.is("Это фраза ставит меня в тупик. Спросите другой вопрос!"));
    }

}