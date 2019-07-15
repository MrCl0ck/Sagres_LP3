package universidade.visao;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import universidade.modelo.listModel.AlunoList;
import universidade.modelo.listModel.ProfessorList;
import universidade.modelo.tableModel.AlunoTableModel;
import universidade.modelo.tableModel.ProfessorTableModel;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class VisãoTurma extends JPanel{
	
	private JLabel instrucaoLabel;
	private JButton cancelarJButton;
	private JButton cadastrarTurmaJButton;
	private JComboBox<String> disciplinaJComboBox;
	private JLabel disciplinaJLabel;
	private JLabel alunoJLabel;
	private JComboBox<String> periodoLetivoAnoJComboBox;
	private JComboBox<String> periodoLetivoSemestreJComboBox;
	private JLabel periodoLetivoJLabel;
	private JList alunosDisponiveisJList;
	private JList alunosInseridosJList;
	private JLabel alunosInseridosJLabel;
	private JButton inserirOAlunoJButton;
	private JButton inserirTodosAlunosJButton;
	private JButton retomarOAlunoJButton;
	private JButton retomarTodosAlunosJButton;
	private JList professoresDisponiveisJList;
	private JLabel professoresDisponiveisJLabel;
	private JButton inserirOProfessorJButton;
	private JButton inserirTodosProfessoresJButton;
	private JButton retomarOProfessorJButton;
	private JButton retomarTodosProfessoresJButton;
	private JList professoresInseridosJList;
	private JLabel professoresInseridosJLabel;
	private JScrollPane alunosDisponiveisScrollpane;
	private JScrollPane alunosInseridosScrollpane;
	private AlunoList alunosDisponiveisList;
	private AlunoList alunosInseridosList;
	private ProfessorList professoresDisponiveisList;
	private ProfessorList professoresInseridosList;
	private JScrollPane professoresDisponiveisScrollpane;
	private JScrollPane professoresInseridosScrollpane;
	
	public VisãoTurma() {
		super(null);
		inicializaComponentesClasse();
	}
	
	public void inicializaComponentesClasse() {
		this.setSize(getMaximumSize());
		this.add(getInstrucaoLabel());
		this.add(getCadastrarTurmaJButton());
		this.add(getCancelarJButton());
		this.add(getDisciplinaJComboBox());
		this.add(getDisciplinaJLabel());
		this.add(getAlunoJLabel());
		this.add(getPeriodoLetivoAnoJComboBox());
		this.add(getPeriodoLetivoSemestreJComboBox());
		this.add(getPeriodoLetivoJLabel());
		//this.add(getAlunosDisponiveisJTable());
		//this.add(getAlunosInseridosJTable());
		this.add(getAlunosInseridosJLabel());
		this.add(getInserirOAlunoJButton());
		this.add(getInserirTodosAlunosJButton());
		this.add(getRetomarOAlunoJButton());
		this.add(getRetomarTodosAlunosJButton());
		//this.add(getProfessoresDisponiveisJTable());
		this.add(getProfessoresDisponiveisJLabel());
		this.add(getInserirOProfessorJButton());
		this.add(getInserirTodosProfessoresJButton());
		this.add(getRetomarOProfessorJButton());
		this.add(getRetomarTodosProfessoresJButton());
		//this.add(getProfessoresInseridosJTable());
		this.add(getProfessoresInseridosJLabel());
		this.add(getAlunosDisponiveisScrollpane());
		this.add(getAlunosInseridosScrollpane());
		this.add(getProfessoresDisponiveisScrollpane());
		this.add(getProfessoresInseridosScrollpane());
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
	
	private JComboBox<String> getDisciplinaJComboBox() {
		if (disciplinaJComboBox == null) {
			disciplinaJComboBox = new JComboBox<String>();
			disciplinaJComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione"}));
			disciplinaJComboBox.setBounds(99, 99, 344, 25);
		}
		return disciplinaJComboBox;
	}
	
	private JLabel getDisciplinaJLabel() {
		if (disciplinaJLabel == null) {
			disciplinaJLabel = new JLabel("Disciplina:");
			disciplinaJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			disciplinaJLabel.setBounds(34, 102, 60, 19);
		}
		return disciplinaJLabel;
	}
	private JLabel getAlunoJLabel() {
		if (alunoJLabel == null) {
			alunoJLabel = new JLabel("Alunos Dispon\u00EDveis:");
			alunoJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			alunoJLabel.setBounds(76, 361, 122, 14);
		}
		return alunoJLabel;
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
	private JList getAlunosDisponiveisJList() {
		if (alunosDisponiveisJList == null) {
			alunosDisponiveisJList = new JList(getAlunosDisponiveisList().getListaAlunosDisponiveis());
			alunosDisponiveisJList.setBounds(745, 171, 560, 147);
		}
		return alunosDisponiveisJList;
	}
	private JList getAlunosInseridosJList() {
		if (alunosInseridosJList == null) {
			alunosInseridosJList = new JList(getAlunosInseridosList().getListaAlunosInseridos());
			alunosInseridosJList.setBounds(74, 386, 560, 147);
		}
		return alunosInseridosJList;
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
	private JList getProfessoresDisponiveisJList() {
		if (professoresDisponiveisJList == null) {
			professoresDisponiveisJList = new JList(getProfessoresDisponiveisList().getListaProfessoresDisponiveis());
			professoresDisponiveisJList.setBounds(74, 171, 560, 147);
		}
		return professoresDisponiveisJList;
	}
	private JLabel getProfessoresDisponiveisJLabel() {
		if (professoresDisponiveisJLabel == null) {
			professoresDisponiveisJLabel = new JLabel("Professores Dispon\u00EDveis:");
			professoresDisponiveisJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			professoresDisponiveisJLabel.setBounds(74, 151, 148, 14);
		}
		return professoresDisponiveisJLabel;
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
	private JList getProfessoresInseridosJList() {
		if (professoresInseridosJList == null) {
			professoresInseridosJList = new JList(getProfessoresInseridosList().getListaProfessoresInseridos());
			professoresInseridosJList.setBounds(745, 171, 560, 147);
		}
		return professoresInseridosJList;
	}
	private JLabel getProfessoresInseridosJLabel() {
		if (professoresInseridosJLabel == null) {
			professoresInseridosJLabel = new JLabel("Professores Inseridos:");
			professoresInseridosJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			professoresInseridosJLabel.setBounds(745, 151, 132, 14);
		}
		return professoresInseridosJLabel;
	}
	
	public JScrollPane getAlunosDisponiveisScrollpane() {
		if(alunosDisponiveisScrollpane == null) {
			alunosDisponiveisScrollpane = new JScrollPane(getAlunosDisponiveisJList());
			alunosDisponiveisScrollpane.setBounds(74, 386, 560, 147);
		}
		return alunosDisponiveisScrollpane;		
	}
	
	public JScrollPane getAlunosInseridosScrollpane() {
		if(alunosInseridosScrollpane == null) {
			alunosInseridosScrollpane = new JScrollPane(getAlunosInseridosJList());
			alunosInseridosScrollpane.setBounds(745, 386, 560, 147);
		}
		return alunosInseridosScrollpane;		
	}
	
	public AlunoList getAlunosDisponiveisList(){
		if(alunosDisponiveisList == null) {
			alunosDisponiveisList = new AlunoList();
		}
		return alunosDisponiveisList;
	}
	
	public AlunoList getAlunosInseridosList() {
		if(alunosInseridosList == null) {
			alunosInseridosList = new AlunoList();
		}
		return alunosInseridosList;
	}
	
	public ProfessorList getProfessoresDisponiveisList() {
		if(professoresDisponiveisList == null) {
			professoresDisponiveisList = new ProfessorList();
		}
		return professoresDisponiveisList;
	}
	
	public ProfessorList getProfessoresInseridosList() {
		if(professoresInseridosList == null) {
			professoresInseridosList = new ProfessorList();
		}
		return professoresInseridosList;
	}
	
	public JScrollPane getProfessoresDisponiveisScrollpane() {
		if(professoresDisponiveisScrollpane == null) {
			professoresDisponiveisScrollpane = new JScrollPane(getProfessoresDisponiveisJList());
			professoresDisponiveisScrollpane.setBounds(74, 171, 560, 147);
		}
		return professoresDisponiveisScrollpane;		
	}
	
	public JScrollPane getProfessoresInseridosScrollpane() {
		if(professoresInseridosScrollpane == null) {
			professoresInseridosScrollpane = new JScrollPane(getProfessoresInseridosJList());
			professoresInseridosScrollpane.setBounds(745, 171, 560, 147);
		}
		return professoresInseridosScrollpane;		
	}
}
