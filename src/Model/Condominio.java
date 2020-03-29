package Model;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
	
	private String nome;
	private String cnpj;
	private Endereco endereco;
	private int id;
	private List<Unidade> unidade = new ArrayList<Unidade>();
	private static int contId = 0;
	
	public Condominio() {	
		contId++;
		this.id = contId;		
	}

	public Condominio(String nome, String cnpj, Endereco endereco) {	
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		contId++;
		this.id = contId;
	}

	public String getNome() {
		return nome;
	}

	public Condominio setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Condominio setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Condominio setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}	
	
	public List<Unidade> getUnidade() {
		return unidade;
	}	

	public void addUnidade(Unidade unidade) {
		this.unidade.add(unidade);
	}
	
	public void removeUnidade(Unidade unidade) {
		this.unidade.remove(unidade);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Condominio [id = "+ id  +"nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", [" + unidade + "]";
	}
	
	
	
}
