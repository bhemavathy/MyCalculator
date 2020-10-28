package MyCalculator.MyCalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import MyCalculatorException.MyCalcException;

public class ReadFileTest {

	@Test(expected = NullPointerException.class)
	public void readNullFileTest() throws MyCalcException, IOException {

		ReadFile rf = new ReadFile();
		rf.readinputfile("//rand1.csv");

	}

	@Test(expected = FileNotFoundException.class)
	public void readFileFoundTest() throws FileNotFoundException {

		ReadFile rf = new ReadFile();

	}

	@Test
	public void readTestToVerifyEachRowSize() throws IOException,
			MyCalcException {

		// String[] record1 = new String[] { "input1", "operator", "input2" };
		String[] record2 = new String[] { "2", "*", "3" };
		String[] record3 = new String[] { "4", "+", "5" };

		List<String[]> expectedrecords = new ArrayList<String[]>();
		// expectedrecords.add(record1);
		expectedrecords.add(record2);
		expectedrecords.add(record3);

		ReadFile rf = new ReadFile();

		List<InputReturnValues> inputslist = rf.readinputfile("Random.csv");

		Assert.assertEquals(expectedrecords.size(), inputslist.size());

	}

	@Test
	public void readTestToVerifyContainsOperator() throws IOException,
			MyCalcException {

		ReadFile rf = new ReadFile();

		List<InputReturnValues> inputslist = rf.readinputfile("Random.csv");

		for (InputReturnValues inpValues : inputslist) {

			char op = inpValues.getOperator();

			Assert.assertTrue("Operator is not accepted", (op == '+'
					|| op == '-' || op == '*' || op == '/' || op == '%'));
		}

	}

}
