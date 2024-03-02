package pacote;

import java.util.ArrayList;

public class Livraria {
	private ArrayList<Impressao> estoque;
	private String nome;
	
	public Livraria(String nome) {
		this.nome = nome;
	}

	public ArrayList<Impressao> getEstoque() {
		return estoque;
	}

	public void setEstoque(ArrayList<Impressao> estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getExemplares(Publicacao pub) {
		return 0;
	}
	public Impressao vende(Publicacao pub) { // PAREI AQUI
		Impressao i = new Impressao(i.getCod(), i.getData());
		return i;
	}
	public ArrayList<Impressao> addEstoque(Publicacao pub){
		return null;
	}
	public ArrayList<Impressao> addEstoque(Publicacao pub, int qtde){
		return null;
	}
}
