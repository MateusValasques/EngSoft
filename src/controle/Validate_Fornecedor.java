package controle;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import visão.painelCadastroForncedor;

public class Validate_Fornecedor {

	painelCadastroForncedor painel_Cadastro_Fornecedor;
	private int codigo;
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

	public Validate_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor) throws ParseException {

		tipo = (String) painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem();
		if (tipo == "CPF")
			cpfcnpj = painel_Cadastro_Fornecedor.getTxtCpf().getText();
		else if (tipo == "CNPJ")
			cpfcnpj = painel_Cadastro_Fornecedor.getTxtCnpj().getText();
		nome = painel_Cadastro_Fornecedor.getTxtNome().getText();
		nome.replace("  ", "");
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

		cidade.replace("  ", "");
		numero.replace("  ", "");
		bairro.replace("  ", "");
		rua.replace("  ", "");

	}

	boolean validacao_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor) throws ParseException {

		Validacao_Email validacaoEmail = new Validacao_Email();

		if ("".equals(painel_Cadastro_Fornecedor.getTxtCpf().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtNome().getText())
				|| "     -   ".equals(painel_Cadastro_Fornecedor.getTxtCep().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtRua().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtNumero().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtBairro().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtCidade().getText())
				|| "(  )     -    ".equals(painel_Cadastro_Fornecedor.getTxtTelefone().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtCelular().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtEmail().getText())
				|| "".equals(painel_Cadastro_Fornecedor.getTxtComplemento().getText())
				|| "-Selecione-".equals(painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem())
				|| "-Selecione-".equals(painel_Cadastro_Fornecedor.getCbxUf().getSelectedItem())
				|| validacaoEmail.verificacao(painel_Cadastro_Fornecedor.getTxtEmail().getText()) == false)
			return false;
		if ("   .   .   -  ".equals(painel_Cadastro_Fornecedor.getTxtCpf().getText())
				&& "CPF".equals(painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if ("  .   .   /    -   ".equals(painel_Cadastro_Fornecedor.getTxtCnpj().getText())
				&& "CNPJ".equals(painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if(isCPF(painel_Cadastro_Fornecedor.getTxtCpf().getText()) == false) {
			System.out.println("oi");
			return false;
		}
			
		
		
		return true;

	}

	public boolean isCPF(String cpf) {

		
		String x = cpf;
		x = x.replace(".",""); // substitui o ponto por uma String vazia 
		x = x.replace("-",""); // substitui o traço por uma String vazia 
		x = x.replace("/",""); // substitui a barra por uma String vazia
		if (x.equals("00000000000") || x.equals("11111111111") || x.equals("22222222222")
				|| x.equals("33333333333") || x.equals("44444444444") || x.equals("55555555555")
				|| x.equals("66666666666") || x.equals("77777777777") || x.equals("88888888888")
				|| x.equals("99999999999") || x.length() != 11)
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (x.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			// Calculo do segundo Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (x.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == x.charAt(9)) && (dig11 == x.charAt(10)))
				return (true);
			else
				return (false);
		} catch (Exception e) {
			return (false);
		}
	}

	public boolean isCNPJ(String cnpj) {
		
		String x = cnpj;
		x = x.replace(".",""); // substitui o ponto por uma String vazia 
		x = x.replace("-",""); // substitui o traço por uma String vazia 
		x = x.replace("/",""); // substitui a barra por uma String vazia
		if (x.equals("00000000000000") || x.equals("11111111111111") || x.equals("22222222222222")
				|| x.equals("33333333333333") || x.equals("44444444444444") || x.equals("55555555555555")
				|| x.equals("66666666666666") || x.equals("77777777777777") || x.equals("88888888888888")
				|| x.equals("99999999999999") || x.length() != 14)
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			// Calculo do primeiro Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (x.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do segundo Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (x.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == x.charAt(12)) && (dig14 == x.charAt(13)))
				return (true);
			else
				return (false);
		} catch (Exception e) {
			return (false);
		}
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
