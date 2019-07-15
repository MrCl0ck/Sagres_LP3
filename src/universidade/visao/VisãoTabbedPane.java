package universidade.visao;

import java.text.ParseException;

import javax.swing.JTabbedPane;

public class VisãoTabbedPane extends JTabbedPane{
	private VisãoDisciplina TelaDisciplina;
	private VisãoProfessor TelaProfessor;
	private VisãoAluno TelaAluno;
	private VisãoTurma TelaTurma;
	private VisãoCurso TelaCurso;
	
	public VisãoTabbedPane() throws ParseException{
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
	
	public VisãoAluno getTelaAluno() throws ParseException {
		if(TelaAluno == null) {
			TelaAluno = new VisãoAluno();
		}
		return TelaAluno;
	}
	
	public VisãoProfessor getTelaProfessor() throws ParseException {
		if(TelaProfessor == null) {
			TelaProfessor = new VisãoProfessor();			
		}
		return TelaProfessor;
	}
	
	public VisãoDisciplina getTelaDisciplina() throws ParseException {
		if(TelaDisciplina == null) {
			TelaDisciplina = new VisãoDisciplina();			
		}
		return TelaDisciplina;
	}
	
	public VisãoCurso getTelaCurso() throws ParseException {
		if(TelaCurso == null) {
			TelaCurso = new VisãoCurso();			
		}
		return TelaCurso;
	}
	
	public VisãoTurma getTelaTurma() throws ParseException {
		if(TelaTurma == null) {
			TelaTurma = new VisãoTurma();			
		}
		return TelaTurma;
	}
}
