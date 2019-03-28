package controle;
/**
 * 
 * @author Murilo Silva Santana
 * 
 * @edited Flávia de Jesus Correia
 * */
import java.text.ParseException;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


/**
 * 
 * # - qualquer número de '0' a '9' pode ser inserido
 * U - qualquer letra de 'a' a 'z' pode ser inserida, a máscara converterá as letras minusculas em maiusculas
 * L - qualquer letra de 'a' a 'z' pode ser inserida, a máscara converterá as letras maiusculas em minusculas
 * ? - qualquer letra de 'a' a 'z' pode ser inserida, a máscara manterá a letra inserida
 * A - qualquer letra ('a' a 'z') ou numero ('0' a '9') pode ser inserido
 * H - qualquer caractere em hexadecimal ('0' a '9' e 'a' a 'f') pode ser inserido
 * * - qualquer caractere pode ser inserido, ('0' a '9', 'a' a 'z', espaços, chaves, etc.)
 *  
 * */
public class FormataMascaras {
	public MaskFormatter mascara = null;
	public String string;
	// construtor padrão
	void Formata(String formato, int opcao) {
		if(opcao == 1) {
			try{
				mascara =  new MaskFormatter(formato);
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}else if(opcao == 2){
			try{
				mascara = new MaskFormatter("*******************************************************************");
				mascara.setValidCharacters(" àáâãéêíóôúabcçdefghijklmnopqrstuvwxyzÀÁÂÃÉÊÍÓÔÚABCÇDEFGHIJKLMNOPQRSTUVWXYZ");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
			
		}else if(opcao == 3){
			try{
				mascara = new MaskFormatter("*****");
				mascara.setValidCharacters("0123456789");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}
		
		
		
	}
	
	// construtor que recebe uma String para o formato da máscara
	// retorna a máscara com o formato inserido pelo usuário
	
	
	// retorna máscara CPF
	public DefaultFormatterFactory getCPF() {
		Formata("###.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	public DefaultFormatterFactory getCidade() {
		Formata("###.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna máscara RG
	public DefaultFormatterFactory getRG() {
		Formata("##.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	public DefaultFormatterFactory getNumero() {
		Formata("", 3);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna mascara para matricula
	public DefaultFormatterFactory getMatricula() {
		Formata("#########", 1);
		return new DefaultFormatterFactory(mascara);
	}
	// retorna máscara telefone
	public DefaultFormatterFactory getCelular() {
		Formata("(##) # ####-####", 1);
		return new DefaultFormatterFactory(mascara);
		
		
	}
	public DefaultFormatterFactory getCnpj() {
		Formata("##.###.###/####-## ", 1);
		return new DefaultFormatterFactory(mascara);
		
		
	}
	public DefaultFormatterFactory gettelefone() {
		Formata("(##) ####-####", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
//	// retorna máscara CEP
//	public DefaultFormatterFactory getCEP() {
//		Formata("##.###-###", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	// retorna máscara Data
	public DefaultFormatterFactory getData() {
		Formata("##/##/####", 1);
		return new DefaultFormatterFactory(mascara);
	}
//	
//	//retorna máscara Agência Bancária
//	public DefaultFormatterFactory getAgencia() {
//		Formata("####", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	//retorna máscara Número da Conta Corrente/Poupança
//	public DefaultFormatterFactory getNumeroConta() {
//		Formata("#########", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
//	public DefaultFormatterFactory getQuantia() {
//		Formata("########", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	//retorna máscara para nome 
	public DefaultFormatterFactory getNome() {
		Formata("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna máscara para qualquer campo de endereço
	public DefaultFormatterFactory getEndereco() {
		Formata("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	public DefaultFormatterFactory getCep() {
		Formata("#####-###", 1);
		return new DefaultFormatterFactory(mascara);
	}
		
	
}
