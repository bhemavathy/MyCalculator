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

	public List<InputReturnValues> readinputfile(String path) throws MyCalcException  {

		String line = "";
		BufferedReader br = null;
		long starttime = System.currentTimeMillis();

		
			
				try {
					br = new BufferedReader(new FileReader(path));
				} catch (FileNotFoundException e) {
					throw new MyCalcException("Not able to locate the file", e);
				}
			
		

		List<InputReturnValues> list = new ArrayList<InputReturnValues>();

		try {
			line = br.readLine();
			if (line ==  null){
				throw new NullPointerException("File is empty");
			}
		} catch (IOException e) {
			throw new MyCalcException("couldn't perform read operation", e);
		}

		try {
			while ((line = br.readLine()) != null) {
				String[] calcin = line.split(",");// use comma as separator
				double input1 = Double.parseDouble(calcin[0]);
				char operator = calcin[1].charAt(0);
				double input2 = Double.parseDouble(calcin[2]);

				System.out.println("Input1 =" + calcin[0] + ",Operator="
						+ calcin[1] + ", Input2=" + calcin[2] );
				InputReturnValues irv = new InputReturnValues();
				irv.setInput1(input1);
				irv.setOperator(operator);
				irv.setInput2(input2);				
				list.add(irv);
			}
		} catch (NumberFormatException e) {
			throw new MyCalcException("Number format is mismathced", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (br != null){
			try {
				br.close();		
				
		} catch (IOException e) {
			throw new MyCalcException("couldn't perform read operation", e);
		}
	}

		long endtime = System.currentTimeMillis();
		long duration = endtime - starttime;
		System.out
				.println("time taken to read this file:" + duration + " millisecs");
		return list;

	}
}
