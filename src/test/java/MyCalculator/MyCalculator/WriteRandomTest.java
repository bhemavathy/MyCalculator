package MyCalculator.MyCalculator;

import org.junit.Test;

public class WriteRandomTest {

	@Test(expected = MyCalcException.class)
	public void writeRanTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

}
