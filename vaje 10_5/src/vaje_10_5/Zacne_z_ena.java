package vaje_10_5;

import java.util.*;

public class Zacne_z_ena {

	public static void main(String[] args) {
		zaporedje(7);
	}
	
	public static void zaporedje(int n) {
		String[] cleni = new String[n];
		cleni[0] = "1";
		int ind = 1; //prvi èlen je že na 0-tem mestu		
		while (ind < n) {
			int ponovitve = 0;
			char trenutni = 'l';
			String clen = "";
			String predhodni = cleni[ind-1];
			// gremo po celem predhodnem èlenu
			for (int i=0; i < predhodni.length(); i++) {
				char stevka = predhodni.charAt(i);
				if (i == 0) {
					trenutni = stevka;
					ponovitve++;
				} else {
					if (trenutni == stevka) {
						ponovitve++;
					} else {
						clen = clen + ponovitve + trenutni;
						ponovitve = 1;
						trenutni = stevka;
					}	
				}
				if (i == cleni[ind-1].length() - 1 && trenutni == stevka) {
					clen = clen + ponovitve + trenutni;
				}				
			}			
			cleni[ind] = clen;
			ind++;
		}			
		System.out.print(Arrays.toString(cleni));		
	}
}
