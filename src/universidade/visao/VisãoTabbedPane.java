package universidade.visao;

import java.text.ParseException;

import javax.swing.JTabbedPane;

public class Vis�oTabbedPane extends JTabbedPane{
	private Vis�oDisciplina TelaDisciplina;
	private Vis�oProfessor TelaProfessor;
	private Vis�oAluno TelaAluno;
	private Vis�oTurma TelaTurma;
	private Vis�oCurso TelaCurso;
	
	public Vis�oTabbedPane() throws ParseException{
		inicializaAbas();		
	}
	
	private void inicializaAbas() throws ParseException {
		this.addTab("Aluno", getTelaAluno());
		this.addTab("Curso", getTelaCurso());
		this.addTab("Disciplina", getTelaDisciplina());
		this.addTab("Professor",getTelaProfessor());		
		this.addTab("Turma", getTelaTurma());
		this.setVisible(true);
	}
	
	public Vis�oAluno getTelaAluno() throws ParseException {
		if(TelaAluno == null) {
			TelaAluno = new Vis�oAluno();
		}
		return TelaAluno;
	}
	
	public Vis�oProfessor getTelaProfessor() throws ParseException {
		if(TelaProfessor == null) {
			TelaProfessor = new Vis�oProfessor();			
		}
		return TelaProfessor;
	}
	
	public Vis�oDisciplina getTelaDisciplina() throws ParseException {
		if(TelaDisciplina == null) {
			TelaDisciplina = new Vis�oDisciplina();			
		}
		return TelaDisciplina;
	}
	
	public Vis�oCurso getTelaCurso() throws ParseException {
		if(TelaCurso == null) {
			TelaCurso = new Vis�oCurso();			
		}
		return TelaCurso;
	}
	
	public Vis�oTurma getTelaTurma() throws ParseException {
		if(TelaTurma == null) {
			TelaTurma = new Vis�oTurma();			
		}
		return TelaTurma;
	}
}
