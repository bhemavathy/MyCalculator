package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class WriteRandom {

	static BufferedWriter bw = null;
	long starttime;

	public WriteRandom(String path) throws MyCalcException {

		try {
			bw = new BufferedWriter(new FileWriter(path));
		} catch (IOException e) {
			throw new CalcIOException("couldn't perform write operation", e);
		}
		String heading = "input1,operator,input2";
		starttime = System.currentTimeMillis();
		try {
			bw.append(heading);
		} catch (IOException e) {
			throw new CalcIOException("couldn't write heading", e);
		}

	}

	public void write(int noOfValues) throws MyCalcException {

		Random rg = new Random();
		String[] op = { "+", "-", "*", "/", "%" };

		for (int i = 0; i < noOfValues; i++) {
			double input1 = (Math.round(rg.nextDouble() * 100.0));
			double input2 = (Math.round(rg.nextDouble() * 100.0));
			int operator = (rg.nextInt(op.length));

			String inputs = input1 + "," + op[operator] + "," + input2;

			try {
				bw.newLine();
			} catch (IOException e) {
				throw new CalcIOException("couldn't add new line", e);
			}

			try {
				bw.append(inputs);
			} catch (IOException e) {
				throw new CalcIOException("couldn't write inputs", e);
			}

		}
		long endtime = System.currentTimeMillis();
		try {
			bw.close();
		} catch (IOException e) {
			throw new CalcIOException("couldn't close the file", e);
		}

		long duration = endtime - starttime;
		System.out.println("time taken to write" + noOfValues
				+ "random inputs into file:" + duration + " ms");
	}

}
