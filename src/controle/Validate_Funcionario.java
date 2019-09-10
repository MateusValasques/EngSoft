package controle;

import java.text.ParseException;

import javax.swing.JOptionPane;

import visão.PainelCadastroFuncionario;
import visão.painelCadastroForncedor;

public class Validate_Funcionario {
	
	PainelCadastroFuncionario painelCadastroFuncionario;
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
	String Agencia = new String();
	String Conta = new String();
	String Login = new String();
	String Senha = new String();
	boolean cancela;
	
	public Validate_Funcionario(PainelCadastroFuncionario painelCadastroFuncionario) throws ParseException{
		
		tipo = (String) painelCadastroFuncionario.getCbxTipo().getSelectedItem();
		if (tipo == "CPF")
			cpfcnpj = painelCadastroFuncionario.getTxtCpf().getText();
		else if (tipo == "CNPJ")
			cpfcnpj = painelCadastroFuncionario.getTxtCNPJ().getText();
		nome = painelCadastroFuncionario.getTxtNome().getText();
		nome.replace("  ", "");
		cep = painelCadastroFuncionario.getTxtCep().getText();
		rua = painelCadastroFuncionario.getTxtRua().getText();
		numero = painelCadastroFuncionario.getTxtNumero().getText();
		bairro = painelCadastroFuncionario.getTxtBairro().getText();
		cidade = painelCadastroFuncionario.getTxtCidade().getText();
		uf = (String) painelCadastroFuncionario.getCbxUf().getSelectedItem();
		telefone = painelCadastroFuncionario.getTxtTelefone().getText();
		celular = painelCadastroFuncionario.getTxtCelular().getText();
		email = painelCadastroFuncionario.getTxtEmail().getText();
		complemento = painelCadastroFuncionario.getTxtComplemento().getText();
		Conta = painelCadastroFuncionario.getTxtConta().getText();
		Login = painelCadastroFuncionario.getTxtLogin().getText();
		Senha = painelCadastroFuncionario.getTxtSenha().getText();
		Agencia = painelCadastroFuncionario.getTxtAgencia().getText();
		
		
		
		cidade.replace("  ", "");
		numero.replace("  ", "");
		bairro.replace("  ", "");
		rua.replace("  ", "");
		
	}
	
	boolean validacao_Funcionario(PainelCadastroFuncionario painelCadastroFuncionario) throws ParseException {

		Validacao_Email validacaoEmail = new Validacao_Email();
		if(painelCadastroFuncionario.getRdbtnCancelaCompra().isSelected() == true) {
			cancela = true;
		}
		else if(painelCadastroFuncionario.getRdbtnNoCancelaCompra().isSelected() == true)
			cancela = false;
		
		else if(!painelCadastroFuncionario.getRdbtnCancelaCompra().isSelected() 
				&& !painelCadastroFuncionario.getRdbtnNoCancelaCompra().isSelected() == false) {
			return false;
		}
		if ("".equals(painelCadastroFuncionario.getTxtCpf().getText())
				|| "".equals(painelCadastroFuncionario.getTxtNome().getText())
				|| "     -   ".equals(painelCadastroFuncionario.getTxtCep().getText())
				|| "".equals(painelCadastroFuncionario.getTxtRua().getText())
				|| "".equals(painelCadastroFuncionario.getTxtNumero().getText())
				|| "".equals(painelCadastroFuncionario.getTxtConta().getText())
				|| "".equals(painelCadastroFuncionario.getTxtAgencia().getText())
				|| "".equals(painelCadastroFuncionario.getTxtLogin().getText())
				|| "".equals(painelCadastroFuncionario.getTxtSenha().getText())
				|| "".equals(painelCadastroFuncionario.getTxtConfirmaSenha().getText())
				|| "".equals(painelCadastroFuncionario.getTxtBairro().getText())
				|| "".equals(painelCadastroFuncionario.getTxtCidade().getText())
				|| "(  )     -    ".equals(painelCadastroFuncionario.getTxtTelefone().getText())
				|| "".equals(painelCadastroFuncionario.getTxtCelular().getText())
				|| "".equals(painelCadastroFuncionario.getTxtEmail().getText())
				|| "".equals(painelCadastroFuncionario.getTxtComplemento().getText())
				|| "-Selecione-".equals(painelCadastroFuncionario.getCbxTipo().getSelectedItem())
				|| "-Selecione-".equals(painelCadastroFuncionario.getCbxUf().getSelectedItem())
				|| validacaoEmail.verificacao(painelCadastroFuncionario.getTxtEmail().getText()) == false)
			return false;
		if ("   .   .   -  ".equals(painelCadastroFuncionario.getTxtCpf().getText())
				&& "CPF".equals(painelCadastroFuncionario.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if ("  .   .   /    -   ".equals(painelCadastroFuncionario.getTxtCNPJ().getText())
				&& "CNPJ".equals(painelCadastroFuncionario.getCbxTipo().getSelectedItem())) {
			return false;
		}
		if(isCPF(painelCadastroFuncionario.getTxtCpf().getText()) == false) {
			System.out.println("oi");
			return false;
		}
		if(!painelCadastroFuncionario.getTxtSenha().getText().equals(painelCadastroFuncionario.getTxtConfirmaSenha().getText())) {
			JOptionPane.showMessageDialog(null, "Senhas não conferem!");
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

	public String getAgencia() {
		return Agencia;
	}

	public void setAgencia(String agencia) {
		Agencia = agencia;
	}

	public String getConta() {
		return Conta;
	}

	public void setConta(String conta) {
		Conta = conta;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public boolean getCancela() {
		return cancela;
	}

	public void setCancela(boolean cancela) {
		this.cancela = cancela;
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
	

