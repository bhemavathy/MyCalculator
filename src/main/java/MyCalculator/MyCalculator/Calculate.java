package MyCalculator.MyCalculator;

public class Calculate {

	public double add(double input1, double input2) {
		double result = input1 + input2;
		return result;
	}

	public double sub(double input1, double input2) {
		double result = input1 - input2;
		return result;
	}

	public double multiply(double input1, double input2) {
		double result = input1 * input2;
		return result;
	}

	public double divide(double input1, double input2) {
		if (input2==0){		
		System.out.println("Please change the divider, cannot divide by zero");
		}
		double result = input1 / input2;
		return result;
		}

	public double percentage(double input1, double input2) {
		double result = (input1 * 100) / input2;
		return result;
	}

	public double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;

		switch (operator1) {
		case '+':
			output = this.add(value1, value2);
			break;
		case '-':
			output = this.sub(value1, value2);
			break;
		case '*':
			output = this.multiply(value1, value2);
			break;
		case '/':
			output = this.divide(value1, value2);
			break;
		case '%':
			output = this.percentage(value1, value2);
			break;
		default:
			System.out.println("Please enter the correct operator");
			break;
		}
		return output;
	}

}
