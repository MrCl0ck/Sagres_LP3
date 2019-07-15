package universidade.modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import universidade.modelo.ModeloDisciplina;

public class DisciplinaTableModel extends AbstractTableModel{
	private	ArrayList<ModeloDisciplina> listaDisciplinas;
	private String[] colunas = new String[]{"Nome","Curso","Código","Semestre"};
	
	public DisciplinaTableModel () {
		this.listaDisciplinas = new ArrayList<>();		
	}
	
	
	public void addDisciplina(ModeloDisciplina disciplina) {
		this.listaDisciplinas.add(disciplina);
		fireTableDataChanged();
	}	
	
	public void removerDisciplina(int linhaIndice) {
		this.listaDisciplinas.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloDisciplina getDisciplina(int linhaIndice) {
		return this.listaDisciplinas.get(linhaIndice);
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
		return this.listaDisciplinas.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return this.listaDisciplinas.get(linha).getNomeDisciplina();
		case 1:
			return this.listaDisciplinas.get(linha).getCursoDisciplina();			
		case 2:
			return this.listaDisciplinas.get(linha).getCodigoDisciplina();			
		case 3:
			return this.listaDisciplinas.get(linha).getSemestreDisciplina();
		default:
			return this.listaDisciplinas.get(linha);
		} 
	}

}
