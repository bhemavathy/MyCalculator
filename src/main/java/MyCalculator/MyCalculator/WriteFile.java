package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	BufferedWriter bw = null;

	public WriteFile(BufferedWriter bufferWriter) {

		try {
			this.bw = bufferWriter;
			 String heading = "input1,operator,input2,=,result";
			 bw.append(heading);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
	} 

	public void writeOutputFile(InputReturnValues inpValues, double output) {

		String calcin3 = Double.toString(output);
		double input1 = inpValues.getInput1();
		double input2 = inpValues.getInput2();
		char operator = inpValues.getOperator();

		String result = input1 + "," + operator + "," + input2 + "," + "="
				+ "," + calcin3;

		try {
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bw.append(result);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
