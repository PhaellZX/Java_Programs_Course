package pacote;

import java.time.LocalDate;

public abstract class Publicacao {
	private String titulo;
	private LocalDate data;
	
	public Publicacao(String titulo, LocalDate data) {
		this.titulo = titulo;
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	protected abstract String getEditora();
	protected abstract int getEdicao();
	protected abstract String getCod();
	
}