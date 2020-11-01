package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

public class CalculateTest {
	@Ignore
	@Test
	public void addTest() {
		double input1 = 40;
		double input2 = 50;
		double expres = 90;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.add(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

	@Test
	public void addTwoNegTest() {
		double input1 = -40;
		double input2 = -50;
		double expres = -90;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.add(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

	@Test(timeout = 2000)
	public void subTest() throws InterruptedException {
		double input1 = 100;
		double input2 = 50;
		double expres = 50;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.sub(input1, input2);
		Assert.assertEquals(expres, actresult);
		Thread.sleep(2000);

	}

	@Test
	public void mulTest() {
		double input1 = 100;
		double input2 = 50;
		double expres = 5000;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

	@Test
	public void mulTestWithZeroAsOneInput() {

		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(0, 10);
		Assert.assertTrue(0d == actresult);

	}

	@Test
	public void mulTestWithOneNegInput() {

		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(-5, 10);
		Assert.assertTrue(-50d == actresult);

	}

	@Test
	public void divTest() {
		double input1 = 100;
		double input2 = 50;
		double expres = 2;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.divide(input1, input2);
		Assert.assertEquals(expres, actresult);
		// assertThat(actresult, is(expres));
	}

	@Test(expected = RuntimeException.class)
	public void divTestdivideByZero() {
		double input1 = 100;
		double input2 = 0;
		Calculate calculate = new Calculate();
		calculate.divide(input1, input2);

	}

	@Test
	public void percTest() {
		double input1 = 100;
		double input2 = 200;
		double expres = 50;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.percentage(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

}
