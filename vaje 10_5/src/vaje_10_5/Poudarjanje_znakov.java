package vaje_10_5;

public class Poudarjanje_znakov {

	public static void main(String[] args) {
		//v_veliko("bjjjjlablo");
		ozn_v_veliko("Zadnja *novica* danes!");
	}
	
	public static void v_veliko(String niz) {
		for (int index = 0; index < niz.length(); index++) {
			char crka = niz.charAt(index);
			System.out.print(Character.toUpperCase(crka) + " ");
		}
	}
	
	public static void ozn_v_veliko(String niz) {
		boolean vecati = false;
		for (int index = 0; index < niz.length(); index++) {
			if (niz.charAt(index) == '*') {
				vecati = !vecati;
			}
			if (!vecati) {
				char crka1 = niz.charAt(index);
				System.out.print(crka1 + " ");
			}
			if (vecati) {
				char crka2 = niz.charAt(index);
				System.out.print(Character.toUpperCase(crka2) + " ");
			}

		}
	}

}

