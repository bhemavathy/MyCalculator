package MyCalculator.MyCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hamcrest.core.IsEqual;

import MyCalculatorException.MyCalcException;

public class GenerateRandomCalcMain {

	public static void main(String[] args) throws MyCalcException, IOException {

		String path = "Random.csv";
		String outpath = "Randomout.csv";

		ReadFile rf = new ReadFile();
		List<InputReturnValues> inputslist = rf.readinputfile(path);

		WriteFile wf = new WriteFile(outpath);

		CalculateWithInput cwi = new CalculateWithInput();
		for (InputReturnValues inpValues : inputslist) {

			double output = cwi.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}

		wf.writerclose();

		System.out
				.println(cwi.plusop
						+ " times addition has been implemented in this random generator calculator");
		System.out
				.println(cwi.minusop
						+ " times subtratcor has been implemented in this random generator calculator");
		System.out
				.println(cwi.multipyop
						+ " times multiplier has been implemented in this random generator calculator");
		System.out
				.println(cwi.divideop
						+ " times division has been implemented in this random generator calculator");
		System.out
				.println(cwi.percop
						+ " times percentage has been implemented in this random generator calculator");

	}

}
