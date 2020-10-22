package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GenerateRandomCalcMain {

	static int plusop, minusop, multipyop, divideop, percop;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "Random.csv";
		String outpath = "Randomout.csv";

		WriteRandom wr = new WriteRandom(path);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the numbers of values to be generated as an input: ");
		int noOfValue = sc.nextInt();
		wr.write(noOfValue);
				
		ReadFile rf = new ReadFile();

		List<InputReturnValues> inputslist = rf.readinputfile(path);

		BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(
				outpath, true));
		WriteFile wf = new WriteFile(bufferWriter);

		for (InputReturnValues inpValues : inputslist) {

			double output = calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}

		try {
			bufferWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Map<Character,Long> map =
		// inputslist.stream().collect(Collectors.groupingBy(InputReturnValues::getChar,Collectors.counting()));

		System.out
				.println(plusop
						+ " times addition has been implemented in this random generator calculator");
		System.out
				.println(minusop
						+ " times subtratcor has been implemented in this random generator calculator");
		System.out
				.println(multipyop
						+ " times multiplier has been implemented in this random generator calculator");
		System.out
				.println(divideop
						+ " times division has been implemented in this random generator calculator");
		System.out
				.println(percop
						+ " times percentage has been implemented in this random generator calculator");

	}

	public static double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		Calculate calculate = new Calculate();
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
			break;
		}
		return output;
	}

}
