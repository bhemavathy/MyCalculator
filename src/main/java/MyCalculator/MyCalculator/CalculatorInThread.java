package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CalculatorInThread extends Thread {

	public static void main(String[] args) throws MyCalcException {
		// TODO Auto-generated method stub
		String path = "Random.csv";
		String outpath = "Randomout.csv";

		WriteRandom wr = new WriteRandom(path);

		Scanner sc = new Scanner(System.in);
		System.out
				.print("Please enter the numbers of values to be generated as an input: ");
		int noOfValue = sc.nextInt();
		wr.write(noOfValue);

		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new CalcFileNotFoundException("File is not found", e);
		}
		ReadFile rf = new ReadFile(bufferReader);

		List<InputReturnValues> inputslist = rf.readinputfile(path);

		int start_index = 0;
		int end_index = inputslist.size() - 1;
		int firstend_secondstart = Math.round(inputslist.size() / 3);
		int secondend_thirdstart = Math.round((inputslist.size() / 3) * 2);

		ReadThread rt1 = new ReadThread(inputslist, start_index,
				firstend_secondstart);
		ReadThread rt2 = new ReadThread(inputslist, firstend_secondstart,
				secondend_thirdstart);
		ReadThread rt3 = new ReadThread(inputslist, secondend_thirdstart,
				end_index);

		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		Thread t3 = new Thread(rt3);

		t1.start();
		// System.out.println(t1.getName());
		t2.start();
		// System.out.println(t2.getName());
		t3.start();
		// System.out.println(t3.getName());
		// try {
		// bufferWriter.close();
		// } catch (IOException e) {
		//
		// }

	}

	public static double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		Calculate calculate = new Calculate();
		if (operator1 == 0) {
			throw new NullPointerException();
		}
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
			throw new RuntimeException("Operator is invalid");

		}
		return output;
	}

}
