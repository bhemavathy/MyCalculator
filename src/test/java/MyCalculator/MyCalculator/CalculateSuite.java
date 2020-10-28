package MyCalculator.MyCalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculateTest.class,
	CalculateWithInputTest.class,
	InputReturnValuesTest.class,
	ParameterTest.class,
	ReadFileTest.class,
	WriteFileTest.class,
	WriteRandomTest.class
})

public class CalculateSuite {

}
