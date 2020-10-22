package MyCalculator.MyCalculator;

import java.io.IOException;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

public class CalculateTest {
	@Ignore
	@Test()
	public void addTest() {
		double input1 = 40;
		double input2 = 50;
		double expres = 100;
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
		Thread.sleep(3000);

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
		double expres = 5000;
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

	@Test
	public void calcWithInputTest() {
		double actual = GenerateRandomCalcMain.calculateWithInput(2, 3, '*');
		Assert.assertEquals(6.0, actual);
	}

	@Test
	public void operatorIncTest() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '+');
		// int actualInc = GenerateRandomCalcMain.plusop;
		Assert.assertEquals(1, GenerateRandomCalcMain.plusop);
	}

	@Test
	public void getterSetterTest() {
		double input1 = 100, expinp1 = 100;
		double input2 = 50, expinp2 = 50;
		char operator = '+', expoperator = '+';
		InputReturnValues irv = new InputReturnValues();
		irv.setInput1(input1);
		irv.setInput2(input2);
		irv.setOperator(operator);
		Assert.assertEquals(expinp1, (irv.getInput1()));
		Assert.assertEquals(expinp2, irv.getInput2());
		Assert.assertEquals(expoperator, irv.getOperator());

	}

	@Test
	public void writeRanTest() {
		WriteRandom wr = new WriteRandom("F://GenRandom.csv");
		wr.write(15);
	//	Assert.assertEquals(expected, wr.write(15));
	}
	

	@Test
	public void readRanTest() {
		ReadFile rf = new ReadFile();
		rf.readinputfile("F://GenRandom.csv");
		
	//	Assert.assertEquals(expected, wr.write(15));
	}
}
