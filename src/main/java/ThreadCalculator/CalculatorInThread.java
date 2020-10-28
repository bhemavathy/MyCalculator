package ThreadCalculator;

import java.util.List;

import MyCalculator.MyCalculator.InputReturnValues;
import MyCalculator.MyCalculator.ReadFile;
import MyCalculatorException.MyCalcException;

public class CalculatorInThread extends Thread {

	public static void main(String[] args) throws MyCalcException,
			InterruptedException {
		// TODO Auto-generated method stub
		String path = "Random.csv";
		String outpath = "Randomout.csv";

		ReadFile rf = new ReadFile();

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
		long starttime = System.currentTimeMillis();
		rt1.start();

		rt2.start();

		rt3.start();

		rt1.join();
		rt2.join();
		rt3.join();

		long endtime = System.currentTimeMillis();
		long duration = endtime - starttime;
		System.out.println("time taken to calculate the" + end_index
				+ "outputs using 3 threads:" + duration + " millisecs");
	}

}
