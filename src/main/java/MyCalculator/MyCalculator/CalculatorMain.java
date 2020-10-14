package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CalculatorMain {
	public static void main(String[] args) {
		String line = "";

		try {
			//BufferedReader br = new BufferedReader(new FileReader("F:\\Inputs.csv"));
			BufferedReader br = new BufferedReader(new FileReader("Inputs.csv"));
			//BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Inputsout.csv"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("Inputsout.csv"));
			String heading = "input1,operator,input2,result";
			bw.append(heading);

			while ((line = br.readLine()) != null) {
				String[] calcin = line.split(",");// use comma as separator
				double input1 = Double.parseDouble(calcin[0]);
				char operator = calcin[1].charAt(0);
				double input2 = Double.parseDouble(calcin[2]);

				System.out.println("Input1 =" + calcin[0] + ",Operator="
						+ calcin[1] + ", Input2=" + calcin[2] + "]");

				Calculate calculate = new Calculate();
				double output = calculate.calculateWithInput(input1, input2,
						operator);

				String calcin3 = Double.toString(output);
				String result = calcin[0] + "," + calcin[1] + "," + calcin[2]
						+ "," + calcin3;
				bw.newLine();
				bw.append(result);

			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
		} catch (IOException e) {
			System.out.println("No file found!");
		}

	}

}
