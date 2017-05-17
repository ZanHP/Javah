package vaje_17_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Frekvence_Besed {

	public static void main(String[] args) throws IOException {
		Set<String> mnoz = preberi_prazne_besede("SloStopWords.txt"); 
		System.out.print(besede("hisa.txt", mnoz));

	}

	private static Set<String> preberi_prazne_besede(String vhodna) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		Set<String> mnoz = new HashSet<String>();
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.isEmpty()) continue;
			StringTokenizer st = new StringTokenizer(vrstica, " .,!?()[]-\"'+");
			while (st.hasMoreTokens()) {
				String beseda = st.nextToken();
				mnoz.add(beseda);
			}
		}
		return mnoz;
	}

	public static Map<String, Integer> besede(String vhodna, Set<String> mnozica) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(vhodna));
		vhod.readLine().trim().toLowerCase();
		Map<String, Integer> slovar = new HashMap<String, Integer>();
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.isEmpty()) continue;
			StringTokenizer st = new StringTokenizer(vrstica, " .,!?()[]-\"'+");
			while (st.hasMoreTokens()) {
				String beseda = st.nextToken();
				if (mnozica.contains(beseda)) {
					continue;
				}					
				if (slovar.containsKey(beseda)) {
					int vrednost = slovar.get(beseda);
					slovar.put(beseda, vrednost + 1);
				} else {
					slovar.put(beseda, 1);
				}
			}
			
				
		
		}
		return slovar;
	}
}
