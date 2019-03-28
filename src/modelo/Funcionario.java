package modelo;

public class Funcionario extends Pessoa{
	
	private boolean cancela_compra;
	private String rg;
	private String uf_rg;
	private String dt_cadastro;
	private String login;
	private String senha;
	private String conta;
	private String agencia;
	
	public Funcionario() {
		
	}
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
						String rg,
					    String uf_rg,
				 	    String dt_cadastro,
				 	    String login,
				 	    String senha,
					    String conta,
					    String agencia) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf,telefone, celular,email, complemento);
		this.cancela_compra = cancela_compra;
		this.rg = rg;
		this.uf_rg = uf_rg;
		this.dt_cadastro = dt_cadastro;
		this.login = login;
		this.senha = senha;
		this.conta = conta;
		this.agencia = agencia;
	}
}
