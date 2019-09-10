package controle;

import java.text.ParseException;

import javax.swing.JOptionPane;

import visão.PainelCadastroCliente;
import visão.painelCadastroForncedor;

public class Validate_Cliente {

	PainelCadastroCliente painelCadastroCliente;
	int codigo;
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
	String limiteCompra = new String();
	boolean ativo;

	public Validate_Cliente(PainelCadastroCliente painelCadastroCliente) throws ParseException {

		tipo = (String) painelCadastroCliente.getCbxTipo().getSelectedItem();
		if (tipo == "CPF")
			cpfcnpj = painelCadastroCliente.getTxtCpf().getText();
		else if (tipo == "CNPJ")
			cpfcnpj = painelCadastroCliente.getTxtCNPJ().getText();
		nome = painelCadastroCliente.getTxtNome().getText();
		cep = painelCadastroCliente.getTxtCep().getText();
		rua = painelCadastroCliente.getTxtRua().getText();
		numero = painelCadastroCliente.getTxtNumero().getText();
		bairro = painelCadastroCliente.getTxtBairro().getText();
		cidade = painelCadastroCliente.getTxtCidade().getText();
		uf = (String) painelCadastroCliente.getCbxUf().getSelectedItem();
		telefone = painelCadastroCliente.getTxtTelefone().getText();
		celular = painelCadastroCliente.getTxtCelular().getText();
		email = painelCadastroCliente.getTxtEmail().getText();
		complemento = painelCadastroCliente.getTxtComplemento().getText();
		limiteCompra = painelCadastroCliente.getTxtLimiteCredito().getText();

		nome.replace("  ", "");
		cidade.replace("  ", "");
		numero.replace("  ", "");
		bairro.replace("  ", "");
		rua.replace("  ", "");
		limiteCompra.replace(",", ".");
		
		
			

	}

	boolean validacao_Cliente(PainelCadastroCliente painelCadastroCliente) throws ParseException {

		
		Validacao_Email validacaoEmail = new Validacao_Email();
		if (painelCadastroCliente.getRbtnAtivo().isSelected() == true) {
			ativo = true;
		} else if (painelCadastroCliente.getRbtnNaoAtivo().isSelected() == true)
			ativo = false;

		else if (!painelCadastroCliente.getRbtnAtivo().isSelected()
				&& !painelCadastroCliente.getRbtnNaoAtivo().isSelected() == false) {
			return false;
		}
		if ("".equals(painelCadastroCliente.getTxtCpf().getText())
				|| "".equals(painelCadastroCliente.getTxtNome().getText())
				|| "     -   ".equals(painelCadastroCliente.getTxtCep().getText())
				|| "".equals(painelCadastroCliente.getTxtRua().getText())
				|| "".equals(painelCadastroCliente.getTxtNumero().getText())
				|| "".equals(painelCadastroCliente.getTxtLimiteCredito().getText())
				|| "".equals(painelCadastroCliente.getTxtBairro().getText())
				|| "".equals(painelCadastroCliente.getTxtCidade().getText())
				|| "(  )     -    ".equals(painelCadastroCliente.getTxtTelefone().getText())
				|| "".equals(painelCadastroCliente.getTxtCelular().getText())
				|| "".equals(painelCadastroCliente.getTxtEmail().getText())
				|| "".equals(painelCadastroCliente.getTxtComplemento().getText())
				|| "-Selecione-".equals(painelCadastroCliente.getCbxTipo().getSelectedItem())
				|| "-Selecione-".equals(painelCadastroCliente.getCbxUf().getSelectedItem())
				|| validacaoEmail.verificacao(painelCadastroCliente.getTxtEmail().getText()) == false)
			return false;
		if ("   .   .   -  ".equals(painelCadastroCliente.getTxtCpf().getText())
				&& "CPF".equals(painelCadastroCliente.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if ("  .   .   /    -   ".equals(painelCadastroCliente.getTxtCNPJ().getText())
				&& "CNPJ".equals(painelCadastroCliente.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if(valor(limiteCompra) == false)
			return false;
		
		if (isCPF(painelCadastroCliente.getTxtCpf().getText()) == false) {
			System.out.println("oi");
			return false;
		}

		return true;

	}

	public boolean valor(String x) {
		int cont = 0;
		for (int i = 0; i < x.length(); i++) {

			if (x.charAt(i) == '.') {

				cont++;

			}

		}
		if (cont > 1)
			return false;
		else
			return true;
	}

	public boolean isCPF(String cpf) {

		String x = cpf;
		x = x.replace(".", ""); // substitui o ponto por uma String vazia
		x = x.replace("-", ""); // substitui o traço por uma String vazia
		x = x.replace("/", ""); // substitui a barra por uma String vazia
		if (x.equals("00000000000") || x.equals("11111111111") || x.equals("22222222222") || x.equals("33333333333")
				|| x.equals("44444444444") || x.equals("55555555555") || x.equals("66666666666")
				|| x.equals("77777777777") || x.equals("88888888888") || x.equals("99999999999") || x.length() != 11)
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
		x = x.replace(".", ""); // substitui o ponto por uma String vazia
		x = x.replace("-", ""); // substitui o traço por uma String vazia
		x = x.replace("/", ""); // substitui a barra por uma String vazia
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

	public PainelCadastroCliente getPainelCadastroCliente() {
		return painelCadastroCliente;
	}

	public void setPainelCadastroCliente(PainelCadastroCliente painelCadastroCliente) {
		this.painelCadastroCliente = painelCadastroCliente;
	}

	public String getLimiteCompra() {
		return limiteCompra;
	}

	public void setLimiteCompra(String limiteCompra) {
		this.limiteCompra = limiteCompra;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
