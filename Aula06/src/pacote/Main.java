package pacote;

public class Main {

	public static void main(String[] args) {
		Estudante e1 = new Estudante("Eduarda", "021", "ADS");
		
		System.out.println("Nome: " + e1.nome);
		System.out.println("Matricula:" + e1.matricula);
		System.out.println("Curso: " + e1.curso);
	}
}
