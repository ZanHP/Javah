package vaje_10_5;

public class Odvod {

	public static void main(String[] args) {
		int[] koef = {1,2,3,4};
		int n = 2;
		System.out.println(java.util.Arrays.toString(n_ti_odvod(koef, n)));
	}
	
	public static int[] n_ti_odvod(int[] koef, int n) {
		int dolzina = koef.length;
		int[] odvod = new int[dolzina];
		if (n == 0) {
			return koef;
		} else {
			for (int i=0 ; i < dolzina; i++) {
				odvod[i] = koef[i] * i;
			}
		}
		return n_ti_odvod(odvod, n-1);		
	}

}
