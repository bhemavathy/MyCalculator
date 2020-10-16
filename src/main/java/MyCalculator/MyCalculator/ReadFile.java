package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public List<InputReturnValues> readinputfile() {


		//String path = "Inputs.csv";
		String line = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Inputs.csv"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<InputReturnValues> list = new ArrayList<InputReturnValues>();
		//InputReturnValues irv = new InputReturnValues();	
		try {
			
			try {
				while ((line = br.readLine()) != null) {				
					String[] calcin = line.split(",");// use comma as separator
					double input1 = Double.parseDouble(calcin[0]);
					char operator = calcin[1].charAt(0);
					double input2 = Double.parseDouble(calcin[2]);

					System.out.println("Input1 =" + calcin[0] + ",Operator="
							+ calcin[1] + ", Input2=" + calcin[2] + "]");
					InputReturnValues irv = new InputReturnValues();				
					irv.setInput1(input1);
					irv.setInput2(input2);
					irv.setChar(operator);
					list.add(irv);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
