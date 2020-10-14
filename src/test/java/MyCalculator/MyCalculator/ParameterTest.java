package MyCalculator.MyCalculator;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;


@RunWith(value=Parameterized.class)
public class ParameterTest {
	private double num1;
	private double num2;
	private double expres;
	
	public ParameterTest(double num1, double num2, double expres){
		this.num1=num1;
		this.num2=num2;
		this.expres=expres;
	}

	@Parameters
	public static Collection<Object[]> inputs(){
		return Arrays.asList(new Object[][]{
			{1,1,1},
			{2,2,4},
			{3,3,9}
		});
	}
	
@Test
public void mul_Test(){
	
	Calculate calculate=new Calculate();
	double actresult=calculate.multiply(num1, num2);
	assertThat(actresult, is(expres));			
		
	}

@Test
public void add_Test(){
	Calculate calculate=new Calculate();
	double actresult=calculate.add(num1, num2);
	assertThat(actresult, is(equalTo(expres)));	
}
	
	
}
