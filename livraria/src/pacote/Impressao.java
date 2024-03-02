package pacote;

import java.time.LocalDate;
import java.util.Objects;

public class Impressao {
	private Publicacao publicacao;
	private String cod;
	private LocalDate data;
	private static int cont = 0;
	
	public Impressao(String cod, LocalDate data) {
		this.cod = cod + cont;
		this.data = data;
		cont++;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Exemplar: " + getCod() + "| Data impressão: " + getData() + "\nRevista: "+ getPublicacao().getTitulo() + " - " + getPublicacao().getEditora() + " - edição n:" + getPublicacao().getEdicao();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impressao other = (Impressao) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(data, other.data)
				&& Objects.equals(publicacao, other.publicacao);
	}
	
	
}