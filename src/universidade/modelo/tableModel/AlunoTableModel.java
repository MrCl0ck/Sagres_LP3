package universidade.modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import universidade.modelo.ModeloAluno;

public class AlunoTableModel extends AbstractTableModel{
	private	ArrayList<ModeloAluno> listaAlunos;
	private String[] colunas = new String[]{"Nome","Curso","Matrícula"};
	
	public AlunoTableModel () {
		this.listaAlunos = new ArrayList<>();		
	}
	
	
	public void addAluno(ModeloAluno disciplina) {
		this.listaAlunos.add(disciplina);
		fireTableDataChanged();
	}	
	
	public void removerAluno(int linhaIndice) {
		this.listaAlunos.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloAluno getAluno(int linhaIndice) {
		return this.listaAlunos.get(linhaIndice);
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
		return this.listaAlunos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return this.listaAlunos.get(linha).getNomeString();
		case 1:
			return this.listaAlunos.get(linha).getCursoString();		
		case 2:
			return this.listaAlunos.get(linha).getMatriculaString();			
		default:
			return this.listaAlunos.get(linha);
		} 
	}

}
