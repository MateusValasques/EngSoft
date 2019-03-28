package modelo;

public class Venda extends Pessoa{

	private String forma_pagamento;
	private Cliente cliente;
	private String ponto_referencia;
	private double valor_total;
	
	public Venda() {
		
	}
	public Venda(int codigo,
			String tipo,
			String cpfcnpj,
			String nome,
			String cep,
			String rua,
			String numero,
			String bairro,
			String cidade,
			String uf,
			String ddd_telefone,
			String telefone,
			String ddd_celular,
			String celular,
			String email,
			String complemento,
			String forma_pagamento,
		    Cliente cliente,
		    String ponto_referencia,
		    double valor_total) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf, telefone , celular,email, complemento);
		
		this.forma_pagamento = forma_pagamento;
		this.cliente = cliente;
		this.ponto_referencia = ponto_referencia;
		this.valor_total = valor_total;
	}
	
	
}
