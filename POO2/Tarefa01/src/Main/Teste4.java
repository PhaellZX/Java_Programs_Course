package Main;

public class Teste4 {
	
	public static < T > void imprimeVetor(Object v[]) {
		for(Object e : v) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static < T extends Comparable< T >> T maior(T v[]) {
		T max = v[0];
		for( T e : v) { if (e.compareTo(max) > 0) max = e; }
		return max;
	}
	
	public static void main(String[] args) {
		Double[] arrayDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		System.out.println("Vetor de double: ");
		imprimeVetor(arrayDouble);
		System.out.println("Maior elemento: " + maior(arrayDouble));
		
		Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
		System.out.println("Vetor de int: ");
		imprimeVetor(arrayInt);
		System.out.println("Maior elemento: " + maior(arrayInt));
		
		Character[] arrayChar = {'E','C','O','0','3','0'};
		System.out.println("Vetor de char: ");
		imprimeVetor(arrayChar);
		System.out.println("Maior elemento: " + maior(arrayChar));

	}
}
