package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import CalcRandomInputGenerator.WriteRandom;
import MyCalculatorException.MyCalcException;

public class WriteRandomTest {

	@Test(expected = MyCalcException.class)
	public void writeRanFileTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}
	
	@Test
	public void writeRanTest() throws MyCalcException, IOException {
	 String[] record1 = new String[] { "input1", "operator", "input2" };
		
		WriteRandom wr = new WriteRandom("Random1.csv");
		
		
		BufferedReader br = new BufferedReader(new FileReader("Randomout.csv"));
		String line = br.readLine();
		String [] actual = line.split(",");
	
		Assert.assertEquals(record1[0].toString(), actual[0].toString() );
		Assert.assertEquals(record1[1].toString(), actual[1].toString() );
		Assert.assertEquals(record1[2].toString(), actual[2].toString() );

	}

}
