package Model;

public class Unidade {
	
	private String nomeResponsavel;
	private String cpf;
	private String numero;
	
	
	public Unidade() {		
	}

	public Unidade(String nomeResponsavel, String cpf, String numero) {		
		this.nomeResponsavel = nomeResponsavel;
		this.cpf = cpf;
		this.numero = numero;
	}
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public Unidade setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
		return this;
	}
	public String getCpf() {
		return cpf;
	}
	public Unidade setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public Unidade setNumero(String numero) {
		this.numero = numero;
		return this;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nomeResponsavel == null) ? 0 : nomeResponsavel.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Unidade other = (Unidade) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nomeResponsavel == null) {
			if (other.nomeResponsavel != null)
				return false;
		} else if (!nomeResponsavel.equals(other.nomeResponsavel))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Unidade [nomeResponsavel=" + nomeResponsavel + ", cpf=" + cpf + ", numero=" + numero + "]";
	}	
}
