package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;

import universidade.visao.Vis�oAluno;
import universidade.visao.Vis�oDisciplina;
import universidade.visao.Vis�oProfessor;
import universidade.visao.Vis�oTabbedPane;
import universidade.visao.Vis�oTurma;

public class ControladorTurma implements ActionListener{
	private Vis�oTurma turmaJPanel;
	
	public ControladorTurma(Vis�oTabbedPane turmaAba) throws ParseException{
		turmaJPanel = new Vis�oTurma();
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
