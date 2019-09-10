package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	private String limite_credito;
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
						String limite_credito,
						boolean ativo,
						String complemento) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf,telefone, celular,email, complemento);
		
		this.ativo = ativo;
		this.setLimite_credito(limite_credito);
	}
	public String getLimite_credito() {
		return limite_credito;
	}
	public void setLimite_credito(String limite_credito) {
		this.limite_credito = limite_credito;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public ArrayList<Produto> getConta() {
		return conta;
	}
	public void setConta(ArrayList<Produto> conta) {
		this.conta = conta;
	}
	
}