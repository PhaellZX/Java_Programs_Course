package Main;

public class Pilha < T > {

	private int max, topo;
	private T[] elementos;
	
	public Pilha(int max) {
		topo = -1;
		this.max = max;
		elementos = ( T[] ) new Object[max];
	}
	
	public void push(T e) throws Error{
		if(topo < (max-1)) elementos[++topo] = e;
		else throw new Error();
	}
	
	public T pop() throws Error{
		if(topo >= 0) return elementos[topo--] = null;
		else throw new Error();
	}
	
	public void imprimir() {
		for(T e : elementos) System.out.printf(e + " ");
			System.out.println();
	}
	
	public static void main(String[] args) {
		Pilha <Integer> p = new Pilha(10);
		
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		p.push(5);
		p.imprimir();
		p.pop();
		p.pop();
		p.imprimir();
		
	}
}
