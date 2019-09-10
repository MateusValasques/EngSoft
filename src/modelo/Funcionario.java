package modelo;

public class Funcionario extends Pessoa{
	
	private boolean cancela_compra;
	private String dt_cadastro;
	private String login;
	private String senha;
	private String conta;
	private String agencia;

	public Funcionario(int codigo,
						String tipo,
						String cpfcnpj,
						String nome,
						String cep,
						String rua,
						String numero,
						String bairro,
						String cidade,
						String uf,
						String telefone,
						String celular,
						String email,
						String complemento,
						boolean cancela_compra,
				 	    String login,
				 	    String senha,
					    String conta,
					    String agencia) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf,telefone, celular,email, complemento);
		this.cancela_compra = cancela_compra;
		this.login = login;
		this.senha = senha;
		this.conta = conta;
		this.agencia = agencia;
	}

	public boolean getCancela_compra() {
		return cancela_compra;
	}

	public void setCancela_compra(boolean cancela_compra) {
		this.cancela_compra = cancela_compra;
	}

	public String getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(String dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
}
