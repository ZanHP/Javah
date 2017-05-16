package vaje_10_5;

public class Collatz {

	public static void main(String[] args) {
		// System.out.print(dolzina(6));
		// System.out.print(najvecji(6));
		// zaporedje(6);
		System.out.print(String.join("", "a", "b"));
	}

	public static int dolzina(int n) {
		int dolz = 1;
		if (n == 1) {
			return 1;
		}
		while (n != 1) {
			dolz++;
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
		}
		return dolz;

	}

	public static int najvecji(int n) {
		int naj = n;
		if (n == 1) {
			return 1;
		}
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			if (n > naj) {
				naj = n;
			}
		}
		return naj;
	}
	
	public static void zaporedje(int n) {
		System.out.print(n);

		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
				System.out.print(n);
			} else {
				n = 3 * n + 1;
				System.out.print(n);
			}
		}

	}
}
