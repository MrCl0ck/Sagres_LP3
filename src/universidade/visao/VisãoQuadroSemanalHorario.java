package universidade.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import universidade.modelo.tableModel.AlunoTableModel;
import universidade.modelo.tableModel.ProfessorTableModel;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JCheckBox;

public class VisãoQuadroSemanalHorario extends JPanel{
	
	private JLabel instrucaoLabel;
	private JButton cancelarJButton;
	private JButton cadastrarTurmaJButton;
	private JComboBox<String> periodoLetivoAnoJComboBox;
	private JComboBox<String> periodoLetivoSemestreJComboBox;
	private JLabel periodoLetivoJLabel;
	private JTable alunosInseridosJTable;
	private JLabel alunosInseridosJLabel;
	private JButton inserirOAlunoJButton;
	private JButton inserirTodosAlunosJButton;
	private JButton retomarOAlunoJButton;
	private JButton retomarTodosAlunosJButton;
	private JButton inserirOProfessorJButton;
	private JButton inserirTodosProfessoresJButton;
	private JButton retomarOProfessorJButton;
	private JButton retomarTodosProfessoresJButton;
	private JTable professoresInseridosJTable;
	private JLabel professoresInseridosJLabel;
	private JScrollPane alunosInseridosScrollpane;
	private AlunoTableModel alunosDisponiveisTable;
	private AlunoTableModel alunosInseridosTable;
	private ProfessorTableModel professoresDisponiveisTable;
	private ProfessorTableModel professoresInseridosTable;
	private JScrollPane professoresInseridosScrollpane;
	private JButton cadastrarHorrioJButton;
	private JCheckBox newCheckBoxchckbx;
	private JCheckBox newCheckBoxchckbx_1;
	private JCheckBox newCheckBoxchckbx_2;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private JCheckBox checkBox_6;
	private JCheckBox checkBox_7;
	private JCheckBox checkBox_8;
	private JCheckBox checkBox_9;
	private JCheckBox checkBox_10;
	private JCheckBox checkBox_11;
	private JCheckBox checkBox_12;
	private JCheckBox checkBox_13;
	
	public VisãoQuadroSemanalHorario() {
		super(null);
		inicializaComponentesClasse();
	}
	
	public void inicializaComponentesClasse() {
		this.add(getInstrucaoLabel());
		this.add(getCadastrarTurmaJButton());
		this.add(getCancelarJButton());
		this.add(getPeriodoLetivoAnoJComboBox());
		this.add(getPeriodoLetivoSemestreJComboBox());
		this.add(getPeriodoLetivoJLabel());
		this.add(getAlunosInseridosJTable());
		this.add(getAlunosInseridosJLabel());
		this.add(getInserirOAlunoJButton());
		this.add(getInserirTodosAlunosJButton());
		this.add(getRetomarOAlunoJButton());
		this.add(getRetomarTodosAlunosJButton());
		this.add(getInserirOProfessorJButton());
		this.add(getInserirTodosProfessoresJButton());
		this.add(getRetomarOProfessorJButton());
		this.add(getRetomarTodosProfessoresJButton());
		this.add(getProfessoresInseridosJTable());
		this.add(getProfessoresInseridosJLabel());
		this.add(getAlunosInseridosScrollpane());
		this.add(getProfessoresInseridosScrollpane());
		this.add(getCadastrarHorrioJButton());
		add(getNewCheckBoxchckbx());
		add(getNewCheckBoxchckbx_1());
		add(getNewCheckBoxchckbx_2());
		add(getCheckBox());
		add(getCheckBox_1());
		add(getCheckBox_2());
		add(getCheckBox_3());
		add(getCheckBox_4());
		add(getCheckBox_5());
		add(getCheckBox_6());
		add(getCheckBox_7());
		add(getCheckBox_8());
		add(getCheckBox_9());
		add(getCheckBox_10());
		add(getCheckBox_11());
		add(getCheckBox_12());
		add(getCheckBox_13());
	}
	
	private JLabel getInstrucaoLabel() {
		if (instrucaoLabel == null) {
			instrucaoLabel = new JLabel("Informa\u00E7\u00F5es da turma:");
			instrucaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			instrucaoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			instrucaoLabel.setBounds(33, 37, 165, 25);
		}
		return instrucaoLabel;
	}
	
	private JButton getCadastrarTurmaJButton() {
		if (cadastrarTurmaJButton == null) {
			cadastrarTurmaJButton = new JButton("Cadastrar Turma");
			cadastrarTurmaJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cadastrarTurmaJButton.setBounds(1173, 578, 132, 33);
		}
		return cadastrarTurmaJButton;
	}
	
	private JButton getCancelarJButton() {
		if (cancelarJButton == null) {
			cancelarJButton = new JButton("Cancelar");
			cancelarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cancelarJButton.setBounds(74, 578, 93, 33);
		}
		return cancelarJButton;
	}
	private JComboBox<String> getPeriodoLetivoAnoJComboBox() {
		if (periodoLetivoAnoJComboBox == null) {
			periodoLetivoAnoJComboBox = new JComboBox<String>();
			periodoLetivoAnoJComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
			periodoLetivoAnoJComboBox.setBounds(575, 99, 66, 25);
		}
		return periodoLetivoAnoJComboBox;
	}
	private JComboBox<String> getPeriodoLetivoSemestreJComboBox() {
		if (periodoLetivoSemestreJComboBox == null) {
			periodoLetivoSemestreJComboBox = new JComboBox<String>();
			periodoLetivoSemestreJComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2"}));
			periodoLetivoSemestreJComboBox.setBounds(651, 99, 40, 25);
		}
		return periodoLetivoSemestreJComboBox;
	}
	private JLabel getPeriodoLetivoJLabel() {
		if (periodoLetivoJLabel == null) {
			periodoLetivoJLabel = new JLabel("Per\u00EDodo Letivo:");
			periodoLetivoJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			periodoLetivoJLabel.setBounds(482, 99, 86, 23);
		}
		return periodoLetivoJLabel;
	}
	private JTable getAlunosInseridosJTable() {
		if (alunosInseridosJTable == null) {
			alunosInseridosJTable = new JTable(getAlunosInseridosTable());
			alunosInseridosJTable.setBounds(74, 386, 560, 147);
		}
		return alunosInseridosJTable;
	}
	private JLabel getAlunosInseridosJLabel() {
		if (alunosInseridosJLabel == null) {
			alunosInseridosJLabel = new JLabel("Alunos Inseridos:");
			alunosInseridosJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			alunosInseridosJLabel.setBounds(746, 361, 105, 14);
		}
		return alunosInseridosJLabel;
	}
	private JButton getInserirOAlunoJButton() {
		if (inserirOAlunoJButton == null) {
			inserirOAlunoJButton = new JButton(">");
			inserirOAlunoJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			inserirOAlunoJButton.setToolTipText("Inserir o aluno selecionado");
			inserirOAlunoJButton.setBounds(664, 171, 52, 25);
		}
		return inserirOAlunoJButton;
	}
	private JButton getInserirTodosAlunosJButton() {
		if (inserirTodosAlunosJButton == null) {
			inserirTodosAlunosJButton = new JButton(">>");
			inserirTodosAlunosJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			inserirTodosAlunosJButton.setToolTipText("Inserir todos os alunos");
			inserirTodosAlunosJButton.setBounds(664, 207, 52, 25);
		}
		return inserirTodosAlunosJButton;
	}
	private JButton getRetomarOAlunoJButton() {
		if (retomarOAlunoJButton == null) {
			retomarOAlunoJButton = new JButton("<");
			retomarOAlunoJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			retomarOAlunoJButton.setToolTipText("Retomar o aluno selecionado");
			retomarOAlunoJButton.setBounds(664, 243, 52, 25);
		}
		return retomarOAlunoJButton;
	}
	private JButton getRetomarTodosAlunosJButton() {
		if (retomarTodosAlunosJButton == null) {
			retomarTodosAlunosJButton = new JButton("<<");
			retomarTodosAlunosJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			retomarTodosAlunosJButton.setToolTipText("Retomar todos os alunos inseridos");
			retomarTodosAlunosJButton.setBounds(664, 279, 52, 25);
		}
		return retomarTodosAlunosJButton;
	}
	private JButton getInserirOProfessorJButton() {
		if (inserirOProfessorJButton == null) {
			inserirOProfessorJButton = new JButton(">");
			inserirOProfessorJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			inserirOProfessorJButton.setToolTipText("Inserir o professor selecionado");
			inserirOProfessorJButton.setBounds(664, 386, 52, 25);
		}
		return inserirOProfessorJButton;
	}
	private JButton getInserirTodosProfessoresJButton() {
		if (inserirTodosProfessoresJButton == null) {
			inserirTodosProfessoresJButton = new JButton(">>");
			inserirTodosProfessoresJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			inserirTodosProfessoresJButton.setToolTipText("Inserir todos os professores");
			inserirTodosProfessoresJButton.setBounds(664, 422, 52, 25);
		}
		return inserirTodosProfessoresJButton;
	}
	private JButton getRetomarOProfessorJButton() {
		if (retomarOProfessorJButton == null) {
			retomarOProfessorJButton = new JButton("<");
			retomarOProfessorJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			retomarOProfessorJButton.setToolTipText("Retomar o professor selecionado");
			retomarOProfessorJButton.setBounds(664, 458, 52, 25);
		}
		return retomarOProfessorJButton;
	}
	private JButton getRetomarTodosProfessoresJButton() {
		if (retomarTodosProfessoresJButton == null) {
			retomarTodosProfessoresJButton = new JButton("<<");
			retomarTodosProfessoresJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			retomarTodosProfessoresJButton.setToolTipText("Retomar todos os professores inseridos");
			retomarTodosProfessoresJButton.setBounds(664, 494, 52, 25);
		}
		return retomarTodosProfessoresJButton;
	}
	private JTable getProfessoresInseridosJTable() {
		if (professoresInseridosJTable == null) {
			professoresInseridosJTable = new JTable(getProfessoresInseridosTable());
			professoresInseridosJTable.setBounds(745, 171, 560, 147);
		}
		return professoresInseridosJTable;
	}
	private JLabel getProfessoresInseridosJLabel() {
		if (professoresInseridosJLabel == null) {
			professoresInseridosJLabel = new JLabel("Professores Inseridos:");
			professoresInseridosJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			professoresInseridosJLabel.setBounds(745, 151, 132, 14);
		}
		return professoresInseridosJLabel;
	}
	
	public JScrollPane getAlunosInseridosScrollpane() {
		if(alunosInseridosScrollpane == null) {
			alunosInseridosScrollpane = new JScrollPane(getAlunosInseridosJTable());
			alunosInseridosScrollpane.setBounds(745, 386, 560, 147);
		}
		return alunosInseridosScrollpane;		
	}
	
	public AlunoTableModel getAlunosDisponiveisTable(){
		if(alunosDisponiveisTable == null) {
			alunosDisponiveisTable = new AlunoTableModel();
		}
		return alunosDisponiveisTable;
	}
	
	public AlunoTableModel getAlunosInseridosTable() {
		if(alunosInseridosTable == null) {
			alunosInseridosTable = new AlunoTableModel();
		}
		return alunosInseridosTable;
	}
	
	public ProfessorTableModel getProfessoresDisponiveisTable() {
		if(professoresDisponiveisTable == null) {
			professoresDisponiveisTable = new ProfessorTableModel();
		}
		return professoresDisponiveisTable;
	}
	
	public ProfessorTableModel getProfessoresInseridosTable() {
		if(professoresInseridosTable == null) {
			professoresInseridosTable = new ProfessorTableModel();
		}
		return professoresInseridosTable;
	}
	
	public JScrollPane getProfessoresInseridosScrollpane() {
		if(professoresInseridosScrollpane == null) {
			professoresInseridosScrollpane = new JScrollPane(getProfessoresInseridosJTable());
			professoresInseridosScrollpane.setBounds(745, 171, 560, 147);
		}
		return professoresInseridosScrollpane;		
	}
	public JButton getCadastrarHorrioJButton() {
		if (cadastrarHorrioJButton == null) {
			cadastrarHorrioJButton = new JButton("Cadastrar Hor\u00E1rio");
			cadastrarHorrioJButton.setBounds(751, 99, 148, 24);
		}
		return cadastrarHorrioJButton;
	}
	public JCheckBox getNewCheckBoxchckbx() {
		if (newCheckBoxchckbx == null) {
			newCheckBoxchckbx = new JCheckBox("New check box");
			newCheckBoxchckbx.setBounds(74, 134, 97, 23);
		}
		return newCheckBoxchckbx;
	}
	public JCheckBox getNewCheckBoxchckbx_1() {
		if (newCheckBoxchckbx_1 == null) {
			newCheckBoxchckbx_1 = new JCheckBox("New check box");
			newCheckBoxchckbx_1.setBounds(74, 166, 97, 23);
		}
		return newCheckBoxchckbx_1;
	}
	public JCheckBox getNewCheckBoxchckbx_2() {
		if (newCheckBoxchckbx_2 == null) {
			newCheckBoxchckbx_2 = new JCheckBox("New check box");
			newCheckBoxchckbx_2.setBounds(74, 196, 97, 23);
		}
		return newCheckBoxchckbx_2;
	}
	public JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("New check box");
			checkBox.setBounds(70, 222, 97, 23);
		}
		return checkBox;
	}
	public JCheckBox getCheckBox_1() {
		if (checkBox_1 == null) {
			checkBox_1 = new JCheckBox("New check box");
			checkBox_1.setBounds(74, 244, 97, 23);
		}
		return checkBox_1;
	}
	public JCheckBox getCheckBox_2() {
		if (checkBox_2 == null) {
			checkBox_2 = new JCheckBox("New check box");
			checkBox_2.setBounds(74, 280, 97, 23);
		}
		return checkBox_2;
	}
	public JCheckBox getCheckBox_3() {
		if (checkBox_3 == null) {
			checkBox_3 = new JCheckBox("New check box");
			checkBox_3.setBounds(74, 309, 97, 23);
		}
		return checkBox_3;
	}
	public JCheckBox getCheckBox_4() {
		if (checkBox_4 == null) {
			checkBox_4 = new JCheckBox("New check box");
			checkBox_4.setBounds(70, 357, 97, 23);
		}
		return checkBox_4;
	}
	public JCheckBox getCheckBox_5() {
		if (checkBox_5 == null) {
			checkBox_5 = new JCheckBox("New check box");
			checkBox_5.setBounds(58, 387, 97, 23);
		}
		return checkBox_5;
	}
	public JCheckBox getCheckBox_6() {
		if (checkBox_6 == null) {
			checkBox_6 = new JCheckBox("New check box");
			checkBox_6.setBounds(70, 423, 97, 23);
		}
		return checkBox_6;
	}
	public JCheckBox getCheckBox_7() {
		if (checkBox_7 == null) {
			checkBox_7 = new JCheckBox("New check box");
			checkBox_7.setBounds(58, 459, 97, 23);
		}
		return checkBox_7;
	}
	public JCheckBox getCheckBox_8() {
		if (checkBox_8 == null) {
			checkBox_8 = new JCheckBox("New check box");
			checkBox_8.setBounds(58, 495, 97, 23);
		}
		return checkBox_8;
	}
	public JCheckBox getCheckBox_9() {
		if (checkBox_9 == null) {
			checkBox_9 = new JCheckBox("New check box");
			checkBox_9.setBounds(58, 527, 97, 23);
		}
		return checkBox_9;
	}
	public JCheckBox getCheckBox_10() {
		if (checkBox_10 == null) {
			checkBox_10 = new JCheckBox("New check box");
			checkBox_10.setBounds(194, 478, 97, 23);
		}
		return checkBox_10;
	}
	public JCheckBox getCheckBox_11() {
		if (checkBox_11 == null) {
			checkBox_11 = new JCheckBox("New check box");
			checkBox_11.setBounds(194, 445, 97, 23);
		}
		return checkBox_11;
	}
	public JCheckBox getCheckBox_12() {
		if (checkBox_12 == null) {
			checkBox_12 = new JCheckBox("New check box");
			checkBox_12.setBounds(194, 403, 97, 23);
		}
		return checkBox_12;
	}
	public JCheckBox getCheckBox_13() {
		if (checkBox_13 == null) {
			checkBox_13 = new JCheckBox("New check box");
			checkBox_13.setBounds(194, 357, 97, 23);
		}
		return checkBox_13;
	}
}
