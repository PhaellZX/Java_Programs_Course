package pacote;

public class Main {

	public static void main(String[] args) {
		Moto moto1 = new Moto("Biz");
		Moto moto2 = new Moto("Suzuki");
		Moto moto3 = new Moto("Honda");
	
		moto1.acelera(40);
		moto1.acelera(40);
		moto1.acelera(40);
		moto1.acelera(40);
		
		moto1.abastecer(50);
		System.out.println(moto1.toString());
		
	}
}
