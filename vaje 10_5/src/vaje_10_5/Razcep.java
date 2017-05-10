package vaje_10_5;

public class Razcep {

	public static void main(String[] args) {
		razcepi(532);
	}
	
	public static void razcepi(int n) {
		char op = '=';
		System.out.print(n);
		for (int d=2; d*d<=n; d++) {
			int e = 0; // kolikokrat je n deljivo z d
			while (n%d==0) {
				n = n/d;
				e++;
			}
			if (e > 0) {
				String niz = " " + op + ' '+ d + '^' + e; 
				System.out.print(niz);
				op = '*';
			}
		}
		if (n > 1) {
			String niz = " " + op + ' '+ n;
			System.out.print(niz);
		}
	}
}