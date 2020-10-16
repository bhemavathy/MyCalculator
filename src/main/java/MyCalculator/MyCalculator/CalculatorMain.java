package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CalculatorMain {
	public static void main(String[] args) {

		ReadFile rf = new ReadFile();
		 WriteFile wf = new WriteFile();
		List<InputReturnValues> inputslist = rf.readinputfile();	

		for (InputReturnValues inpValues : inputslist) {

			double output = calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getChar());
			
			wf.writeOutputFile(inpValues , output);			
			
		}
		
		

	}

	public static double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		Calculate calculate = new Calculate();
		switch (operator1) {
		case '+':
			output = calculate.add(value1, value2);
			break;
		case '-':
			output = calculate.sub(value1, value2);
			break;
		case '*':
			output = calculate.multiply(value1, value2);
			break;
		case '/':
			output = calculate.divide(value1, value2);
			break;
		case '%':
			output = calculate.percentage(value1, value2);
			break;
		default:
			System.out.println("Please enter the correct operator");
			break;
		}
		return output;
	}

}
