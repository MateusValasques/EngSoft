package modelo;

public class Fornecedor extends Pessoa{
	
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(int codigo,
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
						String complemento) {
		
		super(codigo,tipo,cpfcnpj,nome,cep, rua, numero,bairro,cidade,uf,telefone, celular,email, complemento);
			
	}
	
	

	
}
