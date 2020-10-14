package MyCalculator.MyCalculator;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

public class CalculateTest {
	@Ignore
		@Test()		
		public void addTest(){
			double input1=40;
			double input2=50;
			double expres=100;
			double actresult;
			Calculate calculate=new Calculate();
			actresult=calculate.add(input1, input2);
			Assert.assertEquals(expres, actresult);

	}
		
		@Test(timeout=2000)		
		public void subTest() throws InterruptedException{
			double input1=100;
			double input2=50;
			double expres=50;
			double actresult;
			Calculate calculate=new Calculate();
			actresult=calculate.sub(input1, input2);
			Assert.assertEquals(expres, actresult);
			Thread.sleep(3000);

	}
		
		@Test		
		public void mulTest(){
			double input1=100;
			double input2=50;
			double expres=5000;
			double actresult;
			Calculate calculate=new Calculate();
			actresult=calculate.multiply(input1, input2);
			Assert.assertEquals(expres, actresult);

	}
		
		@Test		
		public void divTest(){
			double input1=100;
			double input2=50;
			double expres=5000;
			double actresult;
			Calculate calculate=new Calculate();
			actresult=calculate.divide(input1, input2);
			Assert.assertEquals(expres, actresult);
			//assertThat(actresult, is(expres));
	}
		
		@Test		
		public void percTest(){
			double input1=100;
			double input2=50;
			double expres=5000;
			double actresult;
			Calculate calculate=new Calculate();
			actresult=calculate.percentage(input1, input2);
			Assert.assertEquals(expres, actresult);

	}



}
