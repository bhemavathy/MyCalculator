package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class WriteRandom {

	static BufferedWriter bw = null;
	long starttime = System.nanoTime();

	public WriteRandom(String path) {

		try {
			bw = new BufferedWriter(new FileWriter(path));
			String heading = "input1,input2,operator,=,result";
			bw.append(heading);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public void write(int noOfValues) {
		
		Random rg = new Random();
		String[] op = { "+", "-", "*", "/", "%" };

		for (int i = 0; i < noOfValues; i++) {
			double input1 = (rg.nextDouble()) * 100;
			double input2 = (rg.nextDouble()) * 100;
			int operator = (rg.nextInt(op.length));

			String inputs = input1 + "," + op[operator] + "," + input2;
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.append(inputs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long endtime = System.nanoTime();

		long duration = endtime - starttime;
		System.out.println("time taken to write  10 random inputs into file:"
				+ duration + "in ns");
	}

}
