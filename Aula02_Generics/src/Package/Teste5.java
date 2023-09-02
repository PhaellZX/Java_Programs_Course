package Package;
import java.util.Scanner;
import Package.PrintServices;

public class Teste5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintServices<Integer> ps = new PrintServices<>();
		System.out.print("Quantos valores? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			Integer value = sc.nextInt();
			ps.addValue(value);
		}
		ps.print();
		Integer x = ps.first();
		System.out.println("Primeiro: " + x);
		sc.close();
	}
}
