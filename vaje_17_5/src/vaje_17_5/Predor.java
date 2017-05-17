package vaje_17_5;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Predor {

	public static void main(String[] args) throws IOException {
		System.out.print(prekrskarji("podatki.txt", "prekrskarji.txt"));
	}

	public static int prekrskarji(String vhodna, String izhodna) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		PrintWriter izhod = new PrintWriter(new FileWriter(izhodna));
		
		DecimalFormatSymbols sym = new DecimalFormatSymbols(); 
		sym.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", sym);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		int stevilo = 0;
		
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.isEmpty()) continue;
			String[] besede = vrstica.split(" +");
			double hitrost = 622.0 / (Integer.parseInt(besede[1]) - Integer.parseInt(besede[0])) * 3.6;
			if (hitrost > 80.0) {
				izhod.println(besede[2] + " " + df.format(hitrost));
				stevilo++;
			}
		}
		vhod.close();
		izhod.close();
		return stevilo;
	}
}
		

