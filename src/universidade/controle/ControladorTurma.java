package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;

import universidade.visao.VisãoAluno;
import universidade.visao.VisãoDisciplina;
import universidade.visao.VisãoProfessor;
import universidade.visao.VisãoTabbedPane;
import universidade.visao.VisãoTurma;

public class ControladorTurma implements ActionListener{
	private VisãoTurma turmaJPanel;
	
	public ControladorTurma(VisãoTabbedPane turmaAba) throws ParseException{
		turmaJPanel = new VisãoTurma();
		turmaJPanel = turmaAba.getTelaTurma();
		eventosAdd();
	}
	
	public void eventosAdd() {
		//turmaJPanel.getCadastrarJButton().addActionListener(this);
		//turmaJPanel.getCancelarJButton().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	
	}
}
