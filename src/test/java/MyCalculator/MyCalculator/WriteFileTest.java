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

import CalcRandomInputGenerator.WriteRandom;
import MyCalculatorException.MyCalcException;

public class WriteFileTest {

	@Test(expected = MyCalcException.class)
	public void writeRanTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

	@Test
	public void writeTestToVerifyHeader() throws IOException, MyCalcException {
		WriteFile wf = new WriteFile("Randomout.csv");
		wf.writerclose();
		BufferedReader br = new BufferedReader(new FileReader("Randomout.csv"));
		String line = br.readLine();
		String [] actual = line.split(",");
		String[] expected = new String[5];
		expected[0] = "input1";
		expected[2] = "input2";
		expected[1] = "operator";
		expected[3] = "=";
		expected[4] = "result";

		Assert.assertEquals(expected[0] + expected[1] + expected[2]
				+ expected[3] + expected[4], actual[0] + actual[1] + actual[2]
						+ actual[3] + actual[4]  );

	}

}
