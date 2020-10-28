package MyCalculator.MyCalculator;

public class CalculateWithInput {

	public int plusop, minusop, multipyop, divideop, percop;
	
	public double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		Calculate calculate = new Calculate();
		if (operator1 == 0) {
			throw new NullPointerException();
		}

		switch (operator1) {
		case '+':
			output = calculate.add(value1, value2);
			plusop++;
			break;
		case '-':
			output = calculate.sub(value1, value2);
			minusop++;
			break;
		case '*':
			output = calculate.multiply(value1, value2);
			multipyop++;
			break;
		case '/':
			output = calculate.divide(value1, value2);
			divideop++;
			break;
		case '%':
			output = calculate.percentage(value1, value2);
			percop++;
			break;
		default:
			System.out.println("Please enter the correct operator");
			throw new RuntimeException("Operator is invalid");

		}
		return output;
	}

}
