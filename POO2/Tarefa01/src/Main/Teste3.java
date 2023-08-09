package Main;

public class Teste3 {
	
	public static < T > void imprimeVetor(Object v[]) {
		for(Object e : v) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static void main(String[] args) {
		Double[] arrayDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		System.out.println("Vetor de double: ");
		imprimeVetor(arrayDouble);
		
		Integer[] arrayInt = {1, 2, 3, 4, 5, 6};
		System.out.println("Vetor de int: ");
		imprimeVetor(arrayInt);
		
		Character[] arrayChar = {'E','C','O','0','3','0'};
		System.out.println("Vetor de char: ");
		imprimeVetor(arrayChar);

	}
}
