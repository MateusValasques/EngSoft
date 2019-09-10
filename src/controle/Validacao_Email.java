package controle;

import javax.swing.JOptionPane;

public class Validacao_Email {

	public boolean verificacao(String email) {
		
		int cont = 0;
		for (int i = 0; i < email.length(); i++) {

			if (email.charAt(i) == '@') {

				cont++;
				
			}
		}

		if (cont != 1) {
			JOptionPane.showMessageDialog(null, "E-mail sem @");
			return false;
		}
		
		cont = 0;

		if(email.charAt(0) == '@') {
			
			JOptionPane.showMessageDialog(null, "E-mail começando com @");
			return false;
			
		}
		
		if(!email.substring(email.length() - 4, email.length()).equals(".com") && !email.substring(email.length() - 7, email.length()).equals(".com.br")) {
			System.out.println(email.substring(email.length() - 4, email.length()));
			return false;
		}
			
		return true;

	}

}
