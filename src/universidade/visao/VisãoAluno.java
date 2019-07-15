package universidade.visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import universidade.modelo.boxModel.CursoBoxModel;
import universidade.modelo.validacao.ValidaçãoGeral;

import java.awt.Font;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class VisãoAluno extends JPanel {

	private ValidaçãoGeral nomeTextField;
	private ValidaçãoGeral matriculaTextField;
	private JLabel nomeLabel;
	private JLabel matriculaLabel;
	private JButton cadastrarJButton;
	private JButton cancelarJButton;
	private JLabel instrucaoLabel;
	private JFormattedTextField cpfTextField;
	private JLabel cpfLabel;
	private JFormattedTextField rgTextField;
	private JLabel rgLabel;
	private JLabel cursoLabel;
	private JButton historicoButton;
	private JComboBox<String> cursoComboBox;
	private JLabel anexeAImagemLabel;
	private MaskFormatter cpfMaskFormatter = new MaskFormatter("###.###.###-##");
	private MaskFormatter rgMaskFormatter = new MaskFormatter("##.###.###-##");
	private JButton nmeroDeAlunosButton;
	private CursoBoxModel cursoBoxModel;
	
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public VisãoAluno() throws ParseException {
		super(null);		
		inicializaComponentesAluno();
	}
	
	public void inicializaComponentesAluno(){
		this.add(getNomeTextField());
		this.add(getMatriculaTextField());
		this.add(getNomeLabel());
		this.add(getMatriculaLabel());
		this.add(getCadastrarAlunoJButton());
		this.add(getCancelarJButton());
		this.add(getInstrucaoLabel());
		this.add(getCpfTextField());
		this.add(getCpfLabel());
		this.add(getRgTextField());
		this.add(getRgLabel());
		this.add(getCursoLabel());
		this.add(getHistoricoButton());
		this.add(getCursoComboBox());
		this.add(getAnexeAImagemLabel());
		this.add(getNmeroDeAlunosButton());
	}
	
	public ValidaçãoGeral getNomeTextField() {
		if(nomeTextField == null){
			nomeTextField = new ValidaçãoGeral("1");
			nomeTextField.setBounds(90, 93, 335, 25);
		}
		return nomeTextField;
	}
	
	public ValidaçãoGeral getMatriculaTextField() {
		if(matriculaTextField == null) {
			matriculaTextField = new ValidaçãoGeral("2");
			matriculaTextField.setBounds(90, 148, 168, 25);
		}
		return matriculaTextField;
	}
	public JLabel getNomeLabel() {
		if(nomeLabel == null) {
			nomeLabel = new JLabel("Nome:");
			nomeLabel.setToolTipText("Nome do aluno");
			nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			nomeLabel.setBounds(52,94,39,20);
		}
		return nomeLabel;
	}
	
	public JLabel getMatriculaLabel() {
		if (matriculaLabel == null) {
			matriculaLabel = new JLabel("Matr\u00EDcula:");
			matriculaLabel.setToolTipText("N\u00FAmero de matr\u00EDcula");
			matriculaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			matriculaLabel.setBounds(36, 150, 55, 20);
		}
		return matriculaLabel;
	}
	
	public JButton getCadastrarAlunoJButton() {
		if (cadastrarJButton == null) {
			cadastrarJButton = new JButton("Cadastrar Aluno");
			cadastrarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cadastrarJButton.setBounds(583, 537, 128, 33);
		}
		return cadastrarJButton;
	}
	
	public JButton getCancelarJButton() {
		if(cancelarJButton == null) {
			cancelarJButton = new JButton("Cancelar");
			cancelarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cancelarJButton.setBounds(52, 537, 93, 33);
		}
		return cancelarJButton;
	}
	public JLabel getInstrucaoLabel() {
		if (instrucaoLabel == null) {
			instrucaoLabel = new JLabel("Insira os dados do aluno:");
			instrucaoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			instrucaoLabel.setBounds(20, 40, 180, 12);
		}
		return instrucaoLabel;
	}

	public JTextField getCpfTextField(){
		if (cpfTextField == null) {
			cpfTextField = new JFormattedTextField(cpfMaskFormatter);
			cpfTextField.setBounds(485, 93, 125, 25);
			cpfTextField.setColumns(10);
		}
		return cpfTextField;
	}
	
	private JLabel getCpfLabel() {
		if (cpfLabel == null) {
			cpfLabel = new JLabel("CPF:");
			cpfLabel.setToolTipText("N\u00FAmero do Cadastro de Pessoa F\u00EDsica");
			cpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cpfLabel.setBounds(454, 97, 32, 14);
		}
		return cpfLabel;
	}
	
	public JTextField getRgTextField() {
		if (rgTextField == null) {
			rgTextField = new JFormattedTextField(rgMaskFormatter);
			rgTextField.setBounds(316, 148, 109, 25);
			rgTextField.setColumns(10);
		}
		return rgTextField;
	}
	
	private JLabel getRgLabel() {
		if (rgLabel == null) {
			rgLabel = new JLabel("RG:");
			rgLabel.setToolTipText("N\u00FAmero do Registro Geral");
			rgLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			rgLabel.setBounds(295, 152, 20, 14);
		}
		return rgLabel;
	}
	
	private JLabel getCursoLabel() {
		if (cursoLabel == null) {
			cursoLabel = new JLabel("Curso:");
			cursoLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cursoLabel.setBounds(52, 210, 46, 14);
		}
		return cursoLabel;
	}
	
	public JButton getHistoricoButton() {
		if (historicoButton == null) {
			historicoButton = new JButton("...");
			historicoButton.setToolTipText("Clique aqui para escolher o aquivo...");
			historicoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			historicoButton.setForeground(Color.BLACK);
			historicoButton.setBounds(219, 269, 39, 25);
		}
		return historicoButton;
	}
	
	public JComboBox<String> getCursoComboBox() {
		if (cursoComboBox == null) {
			cursoComboBox = new JComboBox<String>();//getCursoBoxModel().getCursoBoxModel());
			cursoComboBox.setBounds(90, 206, 335, 25);
			cursoComboBox.addItem("Selecione");
		}
		return cursoComboBox;
	}
	
	private JLabel getAnexeAImagemLabel() {
		if (anexeAImagemLabel == null) {
			anexeAImagemLabel = new JLabel("Anexe a imagem do hist\u00F3rico: ");
			anexeAImagemLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			anexeAImagemLabel.setBounds(52, 274, 168, 20);
		}
		return anexeAImagemLabel;
	}
	public JButton getNmeroDeAlunosButton() {
		if (nmeroDeAlunosButton == null) {
			nmeroDeAlunosButton = new JButton("N\u00FAmero de Alunos");
			nmeroDeAlunosButton.setBounds(505, 329, 152, 25);
		}
		return nmeroDeAlunosButton;
	}	
	public CursoBoxModel getCursoBoxModel() {
		if(cursoBoxModel == null) {
			cursoBoxModel = new CursoBoxModel();
		}
		return cursoBoxModel;
	}
}
