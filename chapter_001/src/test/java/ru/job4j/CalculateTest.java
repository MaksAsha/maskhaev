package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test
*@author Maksim Askhaev
*@version $id$
*@Since 0.1
*/

public class CalculateTest {

/**
*Тест
*/
@Test
public void whenTakeNameThenThreeEchoPlusName() {
	String input = "Maksim Askhaev";
	String expect = "Echo, echo, echo : Maksim Askhaev";
	Calculate calc = new Calculate();
	String result = calc.echo(input);
	assertThat(result, is(expect));
}

}