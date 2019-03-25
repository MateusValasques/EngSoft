package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	private double limite_credito;
	private boolean ativo;
	private ArrayList <Produto> conta;
	
	public Cliente() {
		
	}
	public Cliente(int codigo,
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
						double limite_credito,
						boolean ativo,
						String complemento) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf,telefone, celular,email, complemento);
		
		this.ativo = ativo;
		this.limite_credito = limite_credito;
	}
}