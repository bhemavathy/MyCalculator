package MyCalculator.MyCalculator;

public class InputReturnValues {
private double input1;
private double input2;
private char operator;

public double getInput1(){
	return input1;
}
public void setInput1(double value1){
	this.input1 = value1;
}
public double getInput2(){
	return input2;
}
public void setInput2(double value2){
	this.input2 = value2;
}
public char getChar(){
	return operator;
}
public void setChar(char op){
	this.operator = op;
}
}
