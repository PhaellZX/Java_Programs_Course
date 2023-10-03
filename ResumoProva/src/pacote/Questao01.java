package pacote;

class Box<T> {
	private T content;

public Box(T content) {
    this.content = content;
 }

public T getContent() {
    return content;
	}
}


public class Questao01 {
	public static void main(String[] args) {
     Box<String> stringBox = new Box<>("Olá, Generics!");

     Box<Integer> integerBox = new Box<>(42);
     
     String stringValue = stringBox.getContent();
     int intValue = integerBox.getContent();

     System.out.println("Conteúdo da caixa de string: " + stringValue);
     System.out.println("Conteúdo da caixa de inteiro: " + intValue);
	}
}

