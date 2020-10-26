package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hamcrest.core.IsEqual;

public class GenerateRandomCalcMain {

	public int plusop, minusop, multipyop, divideop, percop;

	public static void main(String[] args) throws MyCalcException, IOException {

		String path = "Random.csv";
		String outpath = "Randomout.csv";

		WriteRandom wr = new WriteRandom(path);

		Scanner sc = new Scanner(System.in);
		System.out
				.print("Please enter the numbers of values to be generated as an input: ");
		int noOfValue = sc.nextInt();
		wr.write(noOfValue);

		BufferedReader bufferReader = null;

		bufferReader = new BufferedReader(new FileReader(path));

		ReadFile rf = new ReadFile(bufferReader);
		List<InputReturnValues> inputslist = rf.readinputfile(path);

		BufferedWriter bufferWriter = null;

		bufferWriter = new BufferedWriter(new FileWriter(outpath));

		WriteFile wf = new WriteFile(bufferWriter);
		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();

		for (InputReturnValues inpValues : inputslist) {

			double output = grc.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}

		bufferWriter.close();

		System.out
				.println(grc.plusop
						+ " times addition has been implemented in this random generator calculator");
		System.out
				.println(grc.minusop
						+ " times subtratcor has been implemented in this random generator calculator");
		System.out
				.println(grc.multipyop
						+ " times multiplier has been implemented in this random generator calculator");
		System.out
				.println(grc.divideop
						+ " times division has been implemented in this random generator calculator");
		System.out
				.println(grc.percop
						+ " times percentage has been implemented in this random generator calculator");

	}

	public double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		Calculate calculate = new Calculate();
		if (operator1 == 0) {
			throw new NullPointerException();
		}

		switch (operator1) {
		case '+':
			output = calculate.add(value1, value2);
			plusop++;
			break;
		case '-':
			output = calculate.sub(value1, value2);
			minusop++;
			break;
		case '*':
			output = calculate.multiply(value1, value2);
			multipyop++;
			break;
		case '/':
			output = calculate.divide(value1, value2);
			divideop++;
			break;
		case '%':
			output = calculate.percentage(value1, value2);
			percop++;
			break;
		default:
			System.out.println("Please enter the correct operator");
			throw new RuntimeException("Operator is invalid");

		}
		return output;
	}

}
