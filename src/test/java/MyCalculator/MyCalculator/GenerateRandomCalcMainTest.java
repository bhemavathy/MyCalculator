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

public class GenerateRandomCalcMainTest {
	

	@Test
	public void calcWithInputTestMul() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double actual = grc.calculateWithInput(2, 3, '*');
		Assert.assertEquals(6d, actual);
	}
	
	@Test
	public void calcWithInputTestAdd() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double actual = grc.calculateWithInput(2, 3, '+');
		Assert.assertEquals(5d, actual);
	}
	
	@Test
	public void calcWithInputTestSub() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double actual = grc.calculateWithInput(2, 3, '-');
		Assert.assertEquals(-1d, actual);
	}
	
	@Test
	public void calcWithInputTestDiv() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double actual = grc.calculateWithInput(1, 3, '/');
		Assert.assertEquals(0.3d, actual, 1e-1);
	}
	
	@Test
	public void calcWithInputTestPer() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double actual = grc.calculateWithInput(1, 3, '%');
		Assert.assertEquals(33.3d, actual, 1e-1);
	}

	@Test
	public void operatorIncTestAdd() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '+');
		Assert.assertEquals(1, grc.plusop);
	}
	

	@Test
	public void operatorIncTestMul() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '*');
		Assert.assertEquals(1, grc.multipyop);
	}
	
	
	
	@Test
	public void operatorIncTestDiv() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '/');
		Assert.assertEquals(1, grc.divideop);
	}
	@Test
	public void operatorIncTestSub() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '-');
		Assert.assertEquals(1, grc.minusop);
	}

	@Test
	public void operatorIncTestPer() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '%');
		Assert.assertEquals(1, grc.percop);
	}
	
	@Test(expected = NullPointerException.class)
	public void operatorNullTest() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, (char) 0);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void operatorAlertTest() {
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		double out = grc.calculateWithInput(2, 3, '^');
		
	}
	

}
