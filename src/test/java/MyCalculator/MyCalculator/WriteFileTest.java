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

public class WriteFileTest {

	@Test(expected = MyCalcException.class)
	public void writeRanTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

	@Test
	public void writeTestToVerifyHeader() throws IOException, MyCalcException {
		BufferedWriter bufferWriter = null;

		bufferWriter = new BufferedWriter(new FileWriter("F://Randomout.csv"));

		WriteFile wf = new WriteFile(bufferWriter);
		String actual = "input1,operator,input2,=,result";
		bufferWriter.append(actual);

		String[] actualarr = actual.split(",");

		String[] expected = new String[5];
		expected[0] = "input1";
		expected[2] = "input2";
		expected[1] = "operator";
		expected[3] = "=";
		expected[4] = "result";

		Assert.assertEquals(expected[0] + expected[1] + expected[2]
				+ expected[3] + expected[4], actualarr[0] + actualarr[1]
				+ actualarr[2] + actualarr[3] + actualarr[4]);

	}

}
