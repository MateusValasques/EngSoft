package controle;
/**
 * 
 * @author Murilo Silva Santana
 * 
 * @edited Fl�via de Jesus Correia
 * */
import java.text.ParseException;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


/**
 * 
 * # - qualquer n�mero de '0' a '9' pode ser inserido
 * U - qualquer letra de 'a' a 'z' pode ser inserida, a m�scara converter� as letras minusculas em maiusculas
 * L - qualquer letra de 'a' a 'z' pode ser inserida, a m�scara converter� as letras maiusculas em minusculas
 * ? - qualquer letra de 'a' a 'z' pode ser inserida, a m�scara manter� a letra inserida
 * A - qualquer letra ('a' a 'z') ou numero ('0' a '9') pode ser inserido
 * H - qualquer caractere em hexadecimal ('0' a '9' e 'a' a 'f') pode ser inserido
 * * - qualquer caractere pode ser inserido, ('0' a '9', 'a' a 'z', espa�os, chaves, etc.)
 *  
 * */
public class FormataMascaras {
	public MaskFormatter mascara = null;
	public String string;
	// construtor padr�o
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
				mascara.setValidCharacters(" ����������abc�defghijklmnopqrstuvwxyz����������ABC�DEFGHIJKLMNOPQRSTUVWXYZ");
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
	
	// construtor que recebe uma String para o formato da m�scara
	// retorna a m�scara com o formato inserido pelo usu�rio
	
	
	// retorna m�scara CPF
	public DefaultFormatterFactory getCPF() {
		Formata("###.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	public DefaultFormatterFactory getCidade() {
		Formata("###.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna m�scara RG
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
	// retorna m�scara telefone
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
	
//	// retorna m�scara CEP
//	public DefaultFormatterFactory getCEP() {
//		Formata("##.###-###", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	// retorna m�scara Data
	public DefaultFormatterFactory getData() {
		Formata("##/##/####", 1);
		return new DefaultFormatterFactory(mascara);
	}
//	
//	//retorna m�scara Ag�ncia Banc�ria
//	public DefaultFormatterFactory getAgencia() {
//		Formata("####", 1);
//		return new DefaultFormatterFactory(mascara);
//	}
//	
	//retorna m�scara N�mero da Conta Corrente/Poupan�a
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
	//retorna m�scara para nome 
	public DefaultFormatterFactory getNome() {
		Formata("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna m�scara para qualquer campo de endere�o
	public DefaultFormatterFactory getEndereco() {
		Formata("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	public DefaultFormatterFactory getCep() {
		Formata("#####-###", 1);
		return new DefaultFormatterFactory(mascara);
	}
		
	
}
