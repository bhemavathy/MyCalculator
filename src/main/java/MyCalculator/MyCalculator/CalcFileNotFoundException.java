package MyCalculator.MyCalculator;

import java.io.FileNotFoundException;

public class CalcFileNotFoundException extends Exception {
	
    public CalcFileNotFoundException(String string, FileNotFoundException ex) {
        super(string, ex);

}
}
