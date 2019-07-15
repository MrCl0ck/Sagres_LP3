package universidade.controle;

import java.text.ParseException;

import javax.swing.JFrame;

//import universidade.visao.VisãoFrame;

public class Main {
	private static JFrame frame = new JFrame("Sagreviiiss");
	
	public static void main(String[] args) throws ParseException {
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		new ControladorTabbedPane(frame);
		frame.repaint();
		frame.validate();
		frame.setVisible(true);

	}
}