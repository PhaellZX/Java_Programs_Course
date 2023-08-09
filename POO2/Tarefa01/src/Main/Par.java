package Main;

public class Par {
	private int a, b;
	public Par(int a, int b) { this.a = a; this.b = b;}
	public String toString() { return "(" + a + ", " + b + ")"; }
}

public class Main{
	private static void main(String args[]) {
		Pilha<Par> p1 = new Pilha<Par>(10);
		p1.push(new Par(0,10); p1.push(new Par(2,1)); p1.push(new Par(3,4));
		
		System.out.println(p1.pop() + "\n" + p1.pop() + "\n" + p1.pop());
		
		Pilha<Integer> p2 = new Pilha<Integer>(10);
		p2.push(-10); p2.push(100); p2.push(15);
		System.out.println(p2.pop() + "\n" + p2.pop() + "\n" + p2.pop());

	}
}
