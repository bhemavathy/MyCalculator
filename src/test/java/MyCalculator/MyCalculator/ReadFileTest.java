package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import MyCalculatorException.CalcFileNotFoundException;
import MyCalculatorException.MyCalcException;

public class ReadFileTest {

	@Test(expected = NullPointerException.class)
	public void readNullFileTest() throws MyCalcException, IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Randomnull.csv"));
		bw.close();
		ReadFile rf = new ReadFile();
		rf.readinputfile("Randomnull.csv");

	}

	@Test(expected = CalcFileNotFoundException.class)
	public void readFileFoundTest() throws MyCalcException {

		ReadFile rf = new ReadFile();
		rf.readinputfile("//rand1.csv");

	}

	@Test
	public void readTestToVerifyEachRowSize() throws IOException,
			MyCalcException {

		String[] record2 = new String[] { "2", "*", "3" };
		String[] record3 = new String[] { "4", "+", "5" };

		List<String[]> expectedrecords = new ArrayList<String[]>();

		expectedrecords.add(record2);
		expectedrecords.add(record3);
		for (int i = 0; i < expectedrecords.size(); i++) {

			ReadFile rf = new ReadFile();

			List<InputReturnValues> inputslist = rf
					.readinputfile("Random1.csv");

			for (int j = 0; j < inputslist.size(); j++) {

				Assert.assertEquals(
						Double.parseDouble((expectedrecords.get(j)[0])),
						(inputslist.get(j).getInput1()));
				Assert.assertEquals((expectedrecords.get(j)[1].charAt(0)),
						inputslist.get(j).getOperator());

				Assert.assertEquals(
						Double.parseDouble((expectedrecords.get(j)[0])),
						(inputslist.get(j).getInput1()));
			}
		}

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
