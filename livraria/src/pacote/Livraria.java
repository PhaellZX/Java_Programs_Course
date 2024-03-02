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
		 int totalExemplares = 0;
	        for (Impressao impressao : estoque) {
	            if (impressao.getPublicacao().equals(pub)) {
	                totalExemplares++;
	            }
	        }
	        return totalExemplares;
	}
	public Impressao vende(Publicacao pub) { 
		  for (Impressao impressao : estoque) {
	            if (impressao.getPublicacao().equals(pub)) {
	                estoque.remove(impressao);
	                return impressao;
	            }
	        }
	        return null;
	}
	public void addEstoque(Publicacao pub){
		 Impressao impressao = new Impressao(pub.getCod(), pub.getData());
		 estoque.add(impressao);
	}
	public void addEstoque(Publicacao pub, int qtde){
		for (int i = 0; i < qtde; i++) {
            Impressao impressao = new Impressao(pub.getCod(), pub.getData());
            estoque.add(impressao);
        }
	}
}