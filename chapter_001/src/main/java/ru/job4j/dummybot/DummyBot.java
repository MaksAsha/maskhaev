package ru.job4j.dummybot;

/**
 * @author Maksim Askhaev (maksim.askhaev@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {

        String answer = "Это фраза ставит меня в тупик. Спросите другой вопрос!";

        if (question.equals("Привет, бот!")) {
            answer = "Привет, умник!";
        } else if (question.equals("Пока")) {
            answer = "До скорой встречи!";
        }

        return answer;
    }

    public static void main(String[] args) {
        DummyBot bot = new DummyBot();
        System.out.println(bot.answer("Пока"));
    }

}
