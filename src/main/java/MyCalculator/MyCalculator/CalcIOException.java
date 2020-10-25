package MyCalculator.MyCalculator;


import java.io.IOException;

public class CalcIOException  extends Exception {
	
    public CalcIOException(String string, IOException ex1) {
        super(string, ex1);

}

}
