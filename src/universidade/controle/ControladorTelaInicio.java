package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import universidade.visao.VisãoTelaInicial;

public class ControladorTelaInicio implements ActionListener{
	private VisãoTelaInicial telaInicial  = new VisãoTelaInicial();
	private JFrame frameI;
	
	public JFrame getFrameI() {
		return frameI;
	}

	public ControladorTelaInicio(JFrame frame) throws ParseException{
		frameI = new JFrame();
		frameI = frame;
		frameI.setSize(420,300);
		frameI.setContentPane(telaInicial);
		frameI.setLocationRelativeTo(null);
		frameI.repaint();
		frameI.validate();
		addEventos();
	}
	
	public void addEventos() {
		telaInicial.getLogarButton().addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == telaInicial.getLogarButton()) {
			if(telaInicial.getLoginTextField().getText().equals("Admin") && telaInicial.getSenhaPasswordField().getText().equals("0000")) {
				telaInicial.setVisible(false);
				try {
					new ControladorTabbedPane(frameI);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}