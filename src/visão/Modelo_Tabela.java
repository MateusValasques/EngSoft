package visão;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Modelo_Tabela extends AbstractTableModel {

	private ArrayList linhas = null;
	private String[] colunas = null;

	public Modelo_Tabela(ArrayList lin, String[] col) {

		setLinhas(lin);
		setColunas(col);

	}

	public ArrayList getLinhas() {

		return linhas;
	}
	
	public void setLinhas(ArrayList dados) {
	
		linhas = dados;
		
	}
	
	public String[] getColunas() {
	
		
		return colunas;
		
		
	}

	public void setColunas(String[] nomes) {
		
		colunas = nomes;
		
	}
	
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
//		System.out.println(linhas.size());
		return linhas.size();
	}
	
	public String ColunmName(int numCol){
		
		return colunas[numCol];
		
	}

	@Override
	public Object getValueAt(int numLin, int numcol) {
		// TODO Auto-generated method stub
		
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numcol];
	}

}
