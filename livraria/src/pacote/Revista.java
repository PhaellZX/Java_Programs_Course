package pacote;

import java.time.LocalDate;
import java.util.Objects;

public class Revista extends Publicacao {

	private int edicao;
	private String editora;
	
	public Revista(String titulo, LocalDate data, int edicao, String editora) {
		super(titulo, data);
		this.edicao = edicao;
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return edicao == other.edicao && Objects.equals(editora, other.editora);
	}
	
	@Override
	public String toString() {
		return "Revista: " + getTitulo() + "(" + getData() + ") - Editora "+ getEditora() + " - Edição n:" + getEdicao() + "";
	}

	@Override
	protected String getCod() {
		// TODO Auto-generated method stub
		return null;
	}
}