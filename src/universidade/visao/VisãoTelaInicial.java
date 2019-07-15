package universidade.visao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VisãoTelaInicial extends JPanel {
	//private V_Inicio panelInicio = (V_Inicio) new JPanel();
	private JLabel loginLabel;
	private JLabel senhaLabel;
	private JLabel tituloLabel;
	private JTextField loginTextField;
	private JPasswordField senhaPasswordField;
	private JButton logarButton;
	/**
	 * Create the panel.
	 */
	public VisãoTelaInicial() {
		super(null);
		inicializaComponentesInicio();
	}
	
	public void inicializaComponentesInicio() {
		this.add(getLoginLabel());
		this.add(getSenhaLabel());
		this.add(getTituloLabel());
		this.add(getLoginTextField());
		this.add(getSenhaPasswordField());
		this.add(getLogarButton());
	}
	
	public JLabel getLoginLabel() {
		if(loginLabel == null) {
			loginLabel = new JLabel("Login:");
			loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			loginLabel.setBounds(62, 108, 33, 20);
		}
		return loginLabel;
	}
	
	public JLabel getSenhaLabel() {
		if(senhaLabel == null) {
			senhaLabel = new JLabel("Senha:");
			senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			senhaLabel.setBounds(62, 149, 43, 20);
		}		
		return senhaLabel;
	}
	
	public JLabel getTituloLabel() {
		if(tituloLabel == null) {
			tituloLabel = new JLabel("UnCad");
			tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			tituloLabel.setBounds(176, 31, 66, 33);
		}
		return tituloLabel;
	}
	public JTextField getLoginTextField() {
		if (loginTextField == null) {
			loginTextField = new JTextField();
			loginTextField.setBounds(111, 107, 196, 25);
			loginTextField.setColumns(10);
		}
		return loginTextField;
	}
	public JPasswordField getSenhaPasswordField() {
		if (senhaPasswordField == null) {
			senhaPasswordField = new JPasswordField();
			senhaPasswordField.setBounds(111, 148, 196, 25);
		}
		return senhaPasswordField;
	}
	public JButton getLogarButton() {
		if (logarButton == null) {
			logarButton = new JButton("Logar");
			logarButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			logarButton.setBounds(280, 218, 93, 33);
		}
		return logarButton;
	}
}
