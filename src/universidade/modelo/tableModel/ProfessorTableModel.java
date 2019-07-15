package universidade.modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import universidade.modelo.ModeloProfessor;

public class ProfessorTableModel extends AbstractTableModel{
	private	ArrayList<ModeloProfessor> listaProfessor;
	private String[] colunas = new String[]{"Nome","Área","Matrícula", "Carga Horária"};
	
	public ProfessorTableModel () {
		this.listaProfessor = new ArrayList<>();		
	}
	
	
	public void addProfessor(ModeloProfessor professor) {
		this.listaProfessor.add(professor);
		fireTableDataChanged();
	}	
	
	public void removerProfessor(int linhaIndice) {
		this.listaProfessor.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloProfessor getDisciplina(int linhaIndice) {
		return this.listaProfessor.get(linhaIndice);
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaProfessor.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return this.listaProfessor.get(linha).getNomeString();
		case 1:
			return this.listaProfessor.get(linha).getAreaString();		
		case 2:
			return this.listaProfessor.get(linha).getMatriculaString();	
		case 3:
			return this.listaProfessor.get(linha).getCargaHorariaString();
		default:
			return this.listaProfessor.get(linha);
		} 
	}

}
