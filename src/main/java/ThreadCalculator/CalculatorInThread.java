package ThreadCalculator;

import java.util.List;

import MyCalculator.MyCalculator.CalculateWithInput;
import MyCalculator.MyCalculator.GenerateRandomCalcMain;
import MyCalculator.MyCalculator.InputReturnValues;
import MyCalculator.MyCalculator.ReadFile;
import MyCalculatorException.MyCalcException;

public class CalculatorInThread {

	public static void main(String[] args) throws MyCalcException,
			InterruptedException {
		// TODO Auto-generated method stub
		String path = "Random.csv";

		ReadFile rf = new ReadFile();
		CalculateWithInput cwi = new CalculateWithInput();

		long starttime = System.currentTimeMillis();

		List<InputReturnValues> inputslist = rf.readinputfile(path);

		System.out.println(inputslist.size());

		int itemsPerThread = 3;
		int i = 0;

		while (i < inputslist.size()) {

			ReadThread rt1 = new ReadThread(inputslist, i, itemsPerThread, cwi);

			i = i + itemsPerThread;
			itemsPerThread = itemsPerThread + itemsPerThread;

			rt1.start();
			rt1.join();

		}

		System.out.println(cwi.calculate);

		long endtime = System.currentTimeMillis();
		long duration = endtime - starttime;
		System.out.println("time taken to calculate the"
				+ "outputs using  threads:" + duration + " millisecs");
	}

}
