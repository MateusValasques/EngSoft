package modelo;

public class Fornecedor {

	private int codigo;
	private String tipo;
	private String cpfcnpj;
	private String nome;
	private String cep;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;

	private String telefone;

	private String celular;
	private String email;
	private String complemento;

	public Fornecedor(int codigo, String tipo, String cpfcnpj, String nome, String cep, String rua, String numero,
			String bairro, String cidade, String uf,String telefone, String celular, String email, String complemento) {
		 this.tipo = tipo;
		 this.cpfcnpj = cpfcnpj;
		 this.nome = nome;
		 this.cep = cep;
		 this.rua = rua;
		 this.numero = numero;
		 this.bairro = bairro;
		 this.cidade = cidade;
		 this. uf = uf;

		 this.telefone = telefone;

		 this.celular = celular;
		 this.email = email;
		 this.complemento = complemento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
