package Model;

public class Endereco {

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;
	
	public Endereco() {		
	}
	
	public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, Estado estado,
			String cep) {		
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Endereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Endereco setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public Endereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public Endereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Endereco setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public Estado getEstado() {
		return estado;
	}

	public Endereco setEstado(Estado estado) {
		this.estado = estado;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Endereco setCep(String cep) {
		this.cep = cep;
		return this;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}	
	
}
