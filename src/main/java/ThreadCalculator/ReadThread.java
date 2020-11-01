package ThreadCalculator;

import java.util.List;

import MyCalculator.MyCalculator.CalculateWithInput;
import MyCalculator.MyCalculator.GenerateRandomCalcMain;
import MyCalculator.MyCalculator.InputReturnValues;

public class ReadThread extends Thread {

	private List<InputReturnValues> inputslist;
	private CalculateWithInput cwi;
	

	public ReadThread(List<InputReturnValues> list, int start, int end, CalculateWithInput cwi2) {
		inputslist = list.subList(start, end);
		cwi = cwi2;
	}
	
	public  void run() {
		long starttime = System.currentTimeMillis();

		
			
		
		for (InputReturnValues inpValues : inputslist) {

			double output = cwi.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());
			
			double input1 = inpValues.getInput1();
			double input2 = inpValues.getInput2();
			char op = inpValues.getOperator();
			
			String result = input1 + " " + op + " " + input2 + " " + "="
					+ " " + output;
			System.out.println(Thread.currentThread().getName());
			System.out.println(result);
			
		}
		

		}
	
		
//		System.out
//		.println(cwi.plusop
//				+ " times addition has been implemented in this random generator calculator");
//System.out
//		.println(cwi.minusop
//				+ " times subtratcor has been implemented in this random generator calculator");
//System.out
//		.println(cwi.multipyop
//				+ " times multiplier has been implemented in this random generator calculator");
//System.out
//		.println(cwi.divideop
//				+ " times division has been implemented in this random generator calculator");
//System.out
//		.println(cwi.percop
//				+ " times percentage has been implemented in this random generator calculator");


	
}
