package pacote;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Livro extends Publicacao {
	
	private int paginas;
	private String autores[];
	
	public Livro(String titulo, LocalDate data, int paginas, String ... autores) {
		super(titulo, data);
		this.paginas = paginas;
		this.autores = autores;
	}
	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String[] getAutores() {
		return autores;
	}

	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Arrays.equals(autores, other.autores) && paginas == other.paginas;
	}
	
	@Override
	public String toString() {
		return "Livro: " + getTitulo() + "(" + getData() + ") "+ getPaginas() + " paginas - Autores: " + getAutores() + "";
	}
	@Override
	protected String getEditora() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected int getEdicao() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}	
