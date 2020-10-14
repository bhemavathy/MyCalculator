package MyCalculator.MyCalculator;

import junit.framework.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class CalculateTestSanity {
	@Test		
	public void mulTest(){
		double input1=100;
		double input2=50;
		double expres=5000;
		double actresult;
		Calculate calculate=new Calculate();
		actresult=calculate.multiply(input1, input2);
		assertThat(actresult, is(equalTo(expres)));
		

}
	
	@Test		
	public void divTest(){
		double input1=100;
		double input2=5;
		double expres=20;
		double actresult;
		Calculate calculate=new Calculate();
		actresult=calculate.divide(input1, input2);
		Assert.assertEquals(expres, actresult);

}
}
