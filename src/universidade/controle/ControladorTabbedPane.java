package universidade.controle;

import java.text.ParseException;

import javax.swing.JFrame;

import universidade.visao.Vis�oTabbedPane;

public class ControladorTabbedPane{
	
	private Vis�oTabbedPane abas;
	private JFrame frameT = new JFrame();
	
	public ControladorTabbedPane(JFrame frame) throws ParseException{
		frameT = frame;
		abas = new Vis�oTabbedPane();
		frameT.setContentPane(abas);
		frameT.setSize(785, 640);
		frameT.setLocationRelativeTo(null);
		frameT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameT.repaint();
		frameT.validate();
		eventosAdd();		
	}	

	public void eventosAdd() throws ParseException {
		new ControladorAluno(abas, frameT);
		new ControladorCurso(abas, frameT);
		new ControladorDisciplina(abas, frameT);
		new ControladorProfessor(abas, frameT);
		//new ControladorTurma(abas);
	}
}

