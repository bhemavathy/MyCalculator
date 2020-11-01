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

public class CalculateWithInputTest {

	@Test
	public void calcWithInputTestMul() {
		CalculateWithInput cwi = new CalculateWithInput();
		double actual = cwi.calculateWithInput(2, 3, '*');
		Assert.assertEquals(6d, actual);
	}

	@Test
	public void calcWithInputTestAdd() {
		CalculateWithInput cwi = new CalculateWithInput();
		double actual = cwi.calculateWithInput(2, 3, '+');
		Assert.assertEquals(5d, actual);
	}

	@Test
	public void calcWithInputTestSub() {
		CalculateWithInput cwi = new CalculateWithInput();
		double actual = cwi.calculateWithInput(2, 3, '-');
		Assert.assertEquals(-1d, actual);
	}

	@Test
	public void calcWithInputTestDiv() {
		CalculateWithInput cwi = new CalculateWithInput();
		double actual = cwi.calculateWithInput(1, 3, '/');
		Assert.assertEquals(0.3d, actual, 1e-1);
	}

	@Test
	public void calcWithInputTestPer() {
		CalculateWithInput cwi = new CalculateWithInput();
		double actual = cwi.calculateWithInput(1, 3, '%');
		Assert.assertEquals(33.3d, actual, 1e-1);
	}

	@Test
	public void operatorIncTestAdd() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '+');
		Assert.assertEquals(1, cwi.calculate.plusop);
	}

	@Test
	public void operatorIncTestMul() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '*');
		Assert.assertEquals(1, cwi.calculate.multipyop);
	}

	@Test
	public void operatorIncTestDiv() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '/');
		Assert.assertEquals(1, cwi.calculate.divideop);
	}

	@Test
	public void operatorIncTestSub() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '-');
		Assert.assertEquals(1, cwi.calculate.minusop);
	}

	@Test
	public void operatorIncTestPer() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '%');
		Assert.assertEquals(1, cwi.calculate.percop);
	}

	@Test(expected = NullPointerException.class)
	public void operatorNullTest() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, (char) 0);

	}

	@Test(expected = RuntimeException.class)
	public void operatorAlertTest() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '^');

	}

}
