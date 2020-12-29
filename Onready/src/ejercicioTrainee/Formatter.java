package ejercicioTrainee;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {
		
	public static String moneyFormatter(double importe) {
		
		DecimalFormat formato = new DecimalFormat("$#,###.00");
		DecimalFormatSymbols sym = new DecimalFormatSymbols(Locale.ITALIAN); //ITALIAN coincide con ARG
		formato.setDecimalFormatSymbols(sym);
		
		return formato.format(importe);
	}
}
