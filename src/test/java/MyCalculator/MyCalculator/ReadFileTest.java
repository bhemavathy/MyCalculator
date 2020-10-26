package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

public class ReadFileTest {

	@Test(expected = NullPointerException.class)
	public void readNullFileTest() throws MyCalcException, IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(
				"F://rand1.csv"));
		ReadFile rf = new ReadFile(bufferReader);
		rf.readinputfile("F://rand1.csv");

	}

	@Test
	public void readTestToVerifyHeader() throws MyCalcException, IOException {

		BufferedReader bufferReader = new BufferedReader(new FileReader(
				"F://Random.csv"));
		ReadFile rf = new ReadFile(bufferReader);

		String header = bufferReader.readLine();
		String[] actual = header.split(",");
		String[] expected = new String[3];
		expected[0] = "input1";
		expected[1] = "operator";
		expected[2] = "input2";

		Assert.assertEquals(expected[0] + expected[1] + expected[2], actual[0]
				+ actual[1] + actual[2]);

	}

	@Test(expected = FileNotFoundException.class)
	public void readFileFoundTest() throws FileNotFoundException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(
				"I://Random.csv"));
		ReadFile rf = new ReadFile(bufferReader);

	}

	@Test
	public void readTestToVerifyEachValueslength() throws IOException {

		BufferedReader bufferReader = new BufferedReader(new FileReader(
				"F://Random.csv"));
		ReadFile rf = new ReadFile(bufferReader);

		String header = bufferReader.readLine();

		while ((header = bufferReader.readLine()) != null) {

			String[] actual = header.split(",");
			Assert.assertEquals(2, actual[0].length(), 1e2);
			Assert.assertEquals(1, actual[1].length());
			Assert.assertEquals(2, actual[2].length(), 1e2);

		}

	}

	@Test
	public void readTestToVerifyContainsOperator() throws IOException,
			MyCalcException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(
				"F://Random.csv"));
		ReadFile rf = new ReadFile(bufferReader);

		String header = bufferReader.readLine();

		while ((header = bufferReader.readLine()) != null) {

			String[] actual = header.split(",");

			Assert.assertTrue(
					"Operator is not accepted",
					actual[1].contains("+") || actual[1].contains("-")
							|| actual[1].contains("*")
							|| actual[1].contains("/")
							|| actual[1].contains("%"));

		}

	}

}
