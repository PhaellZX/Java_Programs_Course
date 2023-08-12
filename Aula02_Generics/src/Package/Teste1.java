package Package;

public class Teste1 {
	
	public static void imprimeVetor(double v[]) {
		for(double e : v) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static void imprimeVetor(int v[]) {
		for(int e : v) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static void imprimeVetor(char v[]) {
		for(char e : v) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static void main(String[] args) {
		double[] arrayDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		System.out.println("Vetor de double: ");
		imprimeVetor(arrayDouble);
		
		int[] arrayInt = {1, 2, 3, 4, 5, 6};
		System.out.println("Vetor de int: ");
		imprimeVetor(arrayInt);
		
		char[] arrayChar = {'E','C','O','0','3','0'};
		System.out.println("Vetor de char: ");
		imprimeVetor(arrayChar);

	}
}
