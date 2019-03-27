package controle;

import java.text.ParseException;

import visão.painelCadastroFornecedor;

public class Validate_Fornecedor {

	painelCadastroFornecedor painel_Cadastro_Fornecedor;
	String tipo = new String();
	String cpfcnpj = new String();
	String nome = new String();
	String cep = new String();
	String rua = new String();
	String numero = new String();
	String bairro = new String();
	String cidade = new String();
	String uf = new String();
	String telefone = new String();
	String celular = new String();
	String email = new String();
	String complemento = new String();

	public Validate_Fornecedor(painelCadastroFornecedor painel_Cadastro_Fornecedor)
			 {

		tipo = (String) painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem();
		cpfcnpj = painel_Cadastro_Fornecedor.getTxtCpfCnpj().getText();
		nome = painel_Cadastro_Fornecedor.getTxtNome().getText();
		cep = painel_Cadastro_Fornecedor.getTxtCep().getText();
		rua = painel_Cadastro_Fornecedor.getTxtRua().getText();
		numero = painel_Cadastro_Fornecedor.getTxtNumero().getText();
		bairro = painel_Cadastro_Fornecedor.getTxtBairro().getText();
		cidade = painel_Cadastro_Fornecedor.getTxtCidade().getText();
		uf = (String) painel_Cadastro_Fornecedor.getCbxUf().getSelectedItem();
		telefone = painel_Cadastro_Fornecedor.getTxtTelefone().getText();
		celular = painel_Cadastro_Fornecedor.getTxtCelular().getText();
		email = painel_Cadastro_Fornecedor.getTxtEmail().getText();
		complemento = painel_Cadastro_Fornecedor.getTxtComplemento().getText();

	}

	boolean validacao_Fornecedor(painelCadastroFornecedor painel_Cadastro_Fornecedor) {

		if ("".equals(painel_Cadastro_Fornecedor.getTxtCpfCnpj().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtNome().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtCep().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtRua().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtNumero().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtBairro().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtCidade().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtTelefone().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtCelular().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtEmail().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtComplemento().getText())
				|| "-Selecione-".equals(painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem())
				|| "-Selecione-".equals(painel_Cadastro_Fornecedor.getCbxUf().getSelectedItem()))

			return false;

		return true;

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
