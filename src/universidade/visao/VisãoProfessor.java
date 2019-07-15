package universidade.visao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

import universidade.modelo.validacao.ValidaçãoGeral;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VisãoProfessor extends JPanel {
	
	private JLabel nomeLabel;
	private JLabel matriculaLabel;
	private JLabel areaLabel;
	private JLabel cargaHorariaLabel;
	private JLabel instrucaoLabel;
	private ValidaçãoGeral nomeTextField;
	private ValidaçãoGeral matriculaTextField;
	private JComboBox<String> cargaHorariaComboBox;
	private JButton cadastrarProfessorButton;
	private JButton cancelarJButton;
	private JButton nmeroDeProfessoresButton;
	private JComboBox<String> areaProfessorJComboBox;
	/**
	 * Create the panel.
	 */
	public VisãoProfessor() {
		super(null);
		inicializaComponentesProfessor();
	}
	
	public void inicializaComponentesProfessor() {
		add(getNomeLabel());
		add(getMatriculaLabel());
		add(getAreaLabel());
		add(getCargaHorariaLabel());
		add(getInstrucaoLabel());
		add(getNomeTextField());
		add(getMatriculaTextField());
		add(getCargaHorariaComboBox());
		add(getCadastrarProfessorButton());
		add(getCancelarJButton());
		add(getNmeroDeProfessoresButton());
		add(getAreaDisciplinaJComboBox());
	}
	
	public JLabel getNomeLabel() {
		if(nomeLabel == null) {
			nomeLabel = new JLabel("Nome:");
			nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			nomeLabel.setBounds(69, 74, 40, 20);
		}
		return nomeLabel;
	}
	
	public JLabel getMatriculaLabel() {
		if(matriculaLabel == null) {
			matriculaLabel = new JLabel("Matrícula:");
			matriculaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			matriculaLabel.setBounds(52, 185, 57, 20);
		}	
		return matriculaLabel;
	}
	
	public JLabel getAreaLabel() {
		if(areaLabel == null) {
			areaLabel = new JLabel("Área:");
			areaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			areaLabel.setBounds(69, 128, 40, 20);
		}
		return areaLabel;
	}
	private JLabel getCargaHorariaLabel() {
		if (cargaHorariaLabel == null) {
			cargaHorariaLabel = new JLabel("Carga Hor\u00E1ria:");
			cargaHorariaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cargaHorariaLabel.setBounds(28, 240, 81, 20);
		}
		return cargaHorariaLabel;
	}
	private JLabel getInstrucaoLabel() {
		if (instrucaoLabel == null) {
			instrucaoLabel = new JLabel("Insira os dados:");
			instrucaoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			instrucaoLabel.setBounds(32, 24, 121, 20);
		}
		return instrucaoLabel;
	}
	
	public ValidaçãoGeral getNomeTextField() {
		if (nomeTextField == null) {
			nomeTextField = new ValidaçãoGeral("1");
			nomeTextField.setBounds(114, 73, 427, 25);
			nomeTextField.setColumns(10);
		}
		return nomeTextField;
	}
	
	public ValidaçãoGeral getMatriculaTextField() {
		if (matriculaTextField == null) {
			matriculaTextField = new ValidaçãoGeral("2");
			matriculaTextField.setBounds(114, 183, 187, 25);
			matriculaTextField.setColumns(10);
		}
		return matriculaTextField;
	}
	
	public JComboBox<String> getCargaHorariaComboBox() {
		if (cargaHorariaComboBox == null) {
			cargaHorariaComboBox = new JComboBox<String>();
			//cargaHorariaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "16 (D.E)", "16 (40 hrs)", "8 (20 hrs)"}));
			cargaHorariaComboBox.setBounds(114, 238, 178, 25);
			cargaHorariaComboBox.addItem("Selecione");
			cargaHorariaComboBox.addItem("16 (D.E)");
			cargaHorariaComboBox.addItem("16 (40 hrs)");
			cargaHorariaComboBox.addItem("8 (20 hrs)");
		}
		return cargaHorariaComboBox;
	}
	
	public JButton getCadastrarProfessorButton() {
		if (cadastrarProfessorButton == null) {
			cadastrarProfessorButton = new JButton("Cadastrar Professor");
			cadastrarProfessorButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cadastrarProfessorButton.setBounds(618, 519, 156, 33);
		}
		return cadastrarProfessorButton;
	}
	
	public JButton getCancelarJButton() {
		if (cancelarJButton == null) {
			cancelarJButton = new JButton("Cancelar");
			cancelarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cancelarJButton.setBounds(49, 519, 93, 33);
		}
		return cancelarJButton;
	}
	
	public JButton getNmeroDeProfessoresButton() {
		if (nmeroDeProfessoresButton == null) {
			nmeroDeProfessoresButton = new JButton("N\u00FAmero de Professores");
			nmeroDeProfessoresButton.setBounds(513, 321, 171, 23);
		}
		return nmeroDeProfessoresButton;
	}
	public JComboBox<String> getAreaDisciplinaJComboBox() {
		if (areaProfessorJComboBox == null) {
			areaProfessorJComboBox = new JComboBox<String>();
			areaProfessorJComboBox.setBounds(114, 126, 434, 25);
			areaProfessorJComboBox.addItem("Selecione");
			areaProfessorJComboBox.addItem("Departamento de Ciências Biológicas");
			areaProfessorJComboBox.addItem("Departamento de Ciências Humanas e Letras");
			areaProfessorJComboBox.addItem("Departamento de Ciências Tecnológicas");
			areaProfessorJComboBox.addItem("Departamento de Saúde I");
			areaProfessorJComboBox.addItem("Departamento de Saúde II");			
		}
		return areaProfessorJComboBox;
	}	
}
