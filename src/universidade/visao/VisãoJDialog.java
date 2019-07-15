package universidade.visao;

import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Vis�oJDialog extends JDialog {
	public Vis�oJDialog(JFrame frame, Vis�oDisciplina disciplina){
		super(frame,"Cadastrar Nova Disciplina", true);
		this.getContentPane().add(disciplina);
		this.setSize(frame.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.repaint();
		this.validate();
	}
}
