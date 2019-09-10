package controle;

import java.text.ParseException;

import javax.swing.JOptionPane;

import visão.PainelCadastroCliente;
import visão.PainelCadastroProtudo;

public class Validate_Produto {

	String descricao = new String();
	String codigo_barras = new String();
	String codigo = new String();
	int estoque_min;
	int estoque_max;
	int quantidade;
	String unidade = new String();
	double valor_compra;
	double valor_venda;
	double lucro;
	String tipo = new String();
	PainelCadastroProtudo painelCadastroProtudo;
	String msg_erro = "Valor inválido em:  ";

	public Validate_Produto(PainelCadastroProtudo painelCadastroProtudo) throws ParseException {

		// lucro precisa entrar como txt ou pode ser gerado?
		descricao = painelCadastroProtudo.getTxtDescricao().getText();
		codigo_barras = painelCadastroProtudo.getTxtCodigoDeBarras().getText();
		codigo = painelCadastroProtudo.getTxtCodigo().getText();
		unidade = (String) painelCadastroProtudo.getCbxUnidade().getSelectedItem();
		
		tipo = (String) painelCadastroProtudo.getCbxTipo().getSelectedItem();
		
		//tc para estoque max
		try {

			estoque_max = Integer.parseInt(painelCadastroProtudo.getTxtEstoqueMaximo().getText());
			if (estoque_max < 0) {
				throw new NumeroNegativoexception();
			}

		} catch (NumeroNegativoexception | NumberFormatException e) {

			painelCadastroProtudo.getTxtEstoqueMaximo().setText("");
			msg_erro += "\n-  do Vendedor";
		}
		//t/c para estoque min
		try {

			estoque_min = Integer.parseInt(painelCadastroProtudo.getTxtEstoqueMinimo().getText());
			if (estoque_min < 0) {
				throw new NumeroNegativoexception();
			}

		} catch (NumeroNegativoexception | NumberFormatException e) {
			painelCadastroProtudo.getTxtEstoqueMinimo().setText("");
			msg_erro += "\n- Salário do Vendedor";
		}
		//t/c para quantidade
		try {
			quantidade = Integer.parseInt(painelCadastroProtudo.getTxtQuantidade().getText());
			if (estoque_min < 0) {
				throw new NumeroNegativoexception();
			}

		} catch (NumeroNegativoexception | NumberFormatException e) {
			painelCadastroProtudo.getTxtQuantidade().setText("");
			msg_erro += "\n- Salário do Vendedor";
		}
		
		//try para valor de compra e de venda
		try {
			valor_compra = Double.parseDouble(painelCadastroProtudo.getTxtValorDeCompra().getText());
			valor_venda = Double.parseDouble(painelCadastroProtudo.getTxtValorDeVenda().getText());
			if (valor_compra < 0 || valor_venda < 0) {
				throw new NumeroNegativoexception();
			}

		} catch (NumeroNegativoexception | NumberFormatException e) {
			painelCadastroProtudo.getTxtValorDeVenda().setText("");
			painelCadastroProtudo.getTxtValorDeCompra().setText("");
			msg_erro += "\n- Salário do Vendedor";
		}
		
		lucro = (valor_venda - valor_compra) / valor_compra;
		

	}

	public boolean validacao_produto(PainelCadastroProtudo painelCadastroProtudo) {

		if ("".equals(painelCadastroProtudo.getTxtDescricao().getText())
				|| "".equals(painelCadastroProtudo.getTxtCodigoDeBarras().getText())
				|| "".equals(painelCadastroProtudo.getTxtQuantidade().getText())
				|| "".equals(painelCadastroProtudo.getTxtEstoqueMaximo().getText())
				|| "".equals(painelCadastroProtudo.getTxtEstoqueMinimo().getText())
				|| "-Selecione-".equals(painelCadastroProtudo.getCbxUnidade().getSelectedItem())
				|| "".equals(painelCadastroProtudo.getTxtValorDeCompra().getText())
				|| "".equals(painelCadastroProtudo.getTxtValorDeVenda().getText())
				|| "-Selecione-".equals(painelCadastroProtudo.getCbxTipo().getSelectedItem())
		) {
			JOptionPane.showMessageDialog(null, "Preena os campos corretamente!");
			return false;
		}
		if (estoque_min > estoque_max) {
			JOptionPane.showMessageDialog(null, "Erro: estoque mínimo > estoque máximo");
			return false;
		}

		return true;
	}
	public boolean valor(String x) {
		int cont = 0;
		for (int i = 0; i < x.length(); i++) {

			if (x.charAt(i) == '.') {

				cont++;

			}

		}
		if (cont > 1)
			return false;
		else
			return true;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getEstoque_min() {
		return estoque_min;
	}

	public void setEstoque_min(int estoque_min) {
		this.estoque_min = estoque_min;
	}

	public int getEstoque_max() {
		return estoque_max;
	}

	public void setEstoque_max(int estoque_max) {
		this.estoque_max = estoque_max;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}

	public double getLucro() {
		return lucro;
	}

	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public PainelCadastroProtudo getPainelCadastroProtudo() {
		return painelCadastroProtudo;
	}

	public void setPainelCadastroProtudo(PainelCadastroProtudo painelCadastroProtudo) {
		this.painelCadastroProtudo = painelCadastroProtudo;
	}

}
