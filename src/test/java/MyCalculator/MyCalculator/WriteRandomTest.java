package MyCalculator.MyCalculator;

import org.junit.Test;

import CalcRandomInputGenerator.WriteRandom;
import MyCalculatorException.MyCalcException;

public class WriteRandomTest {

	@Test(expected = MyCalcException.class)
	public void writeRanTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

}
