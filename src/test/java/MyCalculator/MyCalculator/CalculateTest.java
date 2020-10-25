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
		double input2 = 2;
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
	public void calcWithInputTestMul() {
		double actual = GenerateRandomCalcMain.calculateWithInput(2, 3, '*');
		Assert.assertEquals(6d, actual);
	}
	
	@Test
	public void calcWithInputTestAdd() {
		double actual = GenerateRandomCalcMain.calculateWithInput(2, 3, '+');
		Assert.assertEquals(5d, actual);
	}
	
	@Test
	public void calcWithInputTestSub() {
		double actual = GenerateRandomCalcMain.calculateWithInput(2, 3, '-');
		Assert.assertEquals(-1d, actual);
	}
	
	@Test
	public void calcWithInputTestDiv() {
		double actual = GenerateRandomCalcMain.calculateWithInput(1, 3, '/');
		Assert.assertEquals(0.3d, actual, 1e-1);
	}
	
	@Test
	public void calcWithInputTestPer() {
		double actual = GenerateRandomCalcMain.calculateWithInput(1, 3, '%');
		Assert.assertEquals(33.3d, actual, 1e-1);
	}

	@Test
	public void operatorIncTestAdd() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '+');
		Assert.assertEquals(1, GenerateRandomCalcMain.plusop);
	}
	

	@Test
	public void operatorIncTestMul() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '*');
		Assert.assertEquals(1, GenerateRandomCalcMain.multipyop);
	}
	
	
	
	@Test
	public void operatorIncTestDiv() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '/');
		Assert.assertEquals(1, GenerateRandomCalcMain.divideop);
	}
	@Test
	public void operatorIncTestSub() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '-');
		Assert.assertEquals(1, GenerateRandomCalcMain.minusop);
	}

	@Test
	public void operatorIncTestPer() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '%');
		Assert.assertEquals(1, GenerateRandomCalcMain.percop);
	}
	
	@Test(expected = NullPointerException.class)
	public void operatorNullTest() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, (char) 0);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void operatorAlertTest() {
		double out = GenerateRandomCalcMain.calculateWithInput(2, 3, '^');
		
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

	@Test(expected = MyCalcException.class)
	public void writeRanTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

	@Test(expected = NullPointerException.class)
	public void readNullFileTest() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F://Random.csv"));
		String header = br.readLine();
		if ((header = br.readLine()) == null)
			throw new NullPointerException();

	}

	@Test
	public void readTestToVerifyHeader() throws FileNotFoundException,
			MyCalcException {
		BufferedReader br = new BufferedReader(new FileReader("F://Random.csv"));

		try {
			String header = br.readLine();
			String[] actual = header.split(",");
			String[] expected = new String[3];
			expected[0] = "input1";			
			expected[1] = "operator";
			expected[2] = "input2";

			Assert.assertEquals(expected[0] + expected[1] + expected[2], actual[0] + actual[1] + actual[2]);
		} catch (IOException e) {
			throw new MyCalcException("record is not found", e);
		}

	}

	@Test
	public void writeTestToVerifyHeader() throws FileNotFoundException,
			MyCalcException {
		BufferedReader br = new BufferedReader(new FileReader(
				"F://Randomout.csv"));

		try {
			String header = br.readLine();
			String[] actual = header.split(",");
			String[] expected = new String[5];
			expected[0] = "input1";
			expected[2] = "input2";
			expected[1] = "operator";
			expected[3] = "=";
			expected[4] = "result";

			Assert.assertEquals(expected[0] + expected[1] + expected[2]
					+ expected[3] + expected[4], actual[0] + actual[1]
					+ actual[2] + actual[3] + actual[4]);
		} catch (IOException e) {
			throw new MyCalcException("record is not found", e);
		}

	}

	@Test(expected = FileNotFoundException.class)
	public void readFileTest() throws FileNotFoundException, MyCalcException {
		BufferedReader br = new BufferedReader(new FileReader("I://Random.csv"));

	}

	@Test
	public void readTestToVerifyEachValueslength() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F://Random.csv"));

		String header = br.readLine();

		while ((header = br.readLine()) != null) {

			String[] actual = header.split(",");
			Assert.assertEquals(4, actual[0].length());
			Assert.assertEquals(1, actual[1].length());
			Assert.assertEquals(2, actual[2].length());

		}

	}

	@Test
	public void readTestToVerifyContainsOperator() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F://Random.csv"));

		String header = br.readLine();

		while ((header = br.readLine()) != null) {

			String[] actual = header.split(",");

			Assert.assertTrue(
					"Operator is not accepted",
					actual[1].contains("+") || actual[1].contains("-")
							|| actual[1].contains("*")
							|| actual[1].contains("/")
							|| actual[1].contains("%"));
			System.out.println(actual[1]);

		}

	}

}
