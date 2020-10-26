package MyCalculator.MyCalculator;

import java.util.List;

public class ReadThread extends Thread {

	private List<InputReturnValues> inputslist;

	public ReadThread(List<InputReturnValues> list, int start, int end) {
		inputslist = list.subList(start, end);

	}

	public void run() {

		GenerateRandomCalcMain grc = new GenerateRandomCalcMain();
		for (InputReturnValues inpValues : inputslist) {

			double output = grc.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			System.out.println(Thread.currentThread().getName());
			System.out.println(output);

		}

	}
}
