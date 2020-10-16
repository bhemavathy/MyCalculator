package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {

	public void writeOutputFile(InputReturnValues inpValues, double output) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Inputsout.csv", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
//		String heading = "input1,operator,input2,=,result";
//		try {
//			bw.append(heading);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String calcin3 = Double.toString(output);
		double input1 = inpValues.getInput1();
		double input2 = inpValues.getInput2();
		char operator = inpValues.getChar();

		String result = input1 + "," + operator + "," + input2 + "," + "=" + ","
				+ calcin3;

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

		try {

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
