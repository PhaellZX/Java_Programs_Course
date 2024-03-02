package atividade02;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int DELAY = 10;
		int STEPS = 100;
		double MAX_AMOUNT = 1000;
		
		var bank = new Bank(4, 100000);
		
		//THREAD 01
		
		System.out.println("THREAD 01");
		
		for(int i = 0; i < STEPS; i++) {
			double amount = MAX_AMOUNT * Math.random();
			bank.transfer(0, 1, amount);
			Thread.sleep((int)(DELAY * Math.random()));
		}
		System.err.println();
		System.out.println(bank.getTotalBalance());
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------------");
		//THREAD 02
		System.out.println("THREAD 02");
		
		for(int i = 0; i < STEPS; i++) {
			double amount = MAX_AMOUNT * Math.random();
			bank.transfer(2, 1, amount);
			Thread.sleep((int)(DELAY * Math.random()));
		}
		System.out.println();
		System.out.println(bank.getTotalBalance());
		System.out.println();
	}

}