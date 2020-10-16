package MyCalculator.MyCalculator;

public class Calculate {

	/**
	 * @param input1
	 * @param input2
	 * @return sum
	 */
	public double add(double input1, double input2) {
		double result = input1 + input2;
		return result;
	}

	/**
	 * @param input1
	 * @param input2
	 * @return difference
	 */
	public double sub(double input1, double input2) {
		double result = input1 - input2;
		return result;
	}

	/**
	 * @param input1
	 * @param input2
	 * @return product
	 */
	public double multiply(double input1, double input2) {
		double result = input1 * input2;
		return result;
	}

	/**
	 * @param dividend
	 * @param divisor
	 * @return quotient
	 * @throws Exception
	 */
	public double divide(double dividend, double divisor) {
		double result1 = 0;
		try {
			double result = dividend / divisor;
			return result;
			}
			// System.out.println("Please change the divider, cannot divide by zero");
		 catch (Exception e) {
			System.out.println(e);
		}
		return result1;
		
		

	}

	/**
	 * @param obtainedvalue
	 * @param totalvalue
	 * @return percentage
	 */
	public double percentage(double obtainedvalue, double totalvalue) {
		double result = (obtainedvalue * 100) / totalvalue;
		return result;
	}

}
