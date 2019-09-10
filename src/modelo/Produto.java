package modelo;

public class Produto {

	private String descricao;
	private String codigo_barras;
	private int codigo;
	private int estoque_min;
	private int estoque_max;
	private int quantidade;
	private String unidade;
	private double valor_compra;
	private double valor_venda;
	private double lucro;
	private String tipo;

	public Produto() {

	}

	public Produto(int codigo, String descricao, String codigo_barras, int estoque_min, int estoque_max,
			int quantidade, String unidade, double valor_compra, double valor_venda, double lucro, String tipo) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigo_barras = codigo_barras;
		this.estoque_min = estoque_min;
		this.estoque_max = estoque_max;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.valor_compra = valor_compra;
		this.valor_venda = valor_venda;
		this.lucro = lucro;
		this.tipo = tipo;

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

	public void setCodigo_barras(String string) {
		this.codigo_barras = string;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

}
