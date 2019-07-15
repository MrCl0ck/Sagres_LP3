package universidade.visao;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import universidade.modelo.ModeloDisciplina;
import universidade.modelo.listModel.DisciplinaList;
import universidade.modelo.persistencia.DadosDisciplina;
import universidade.modelo.validacao.ValidaçãoGeral;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class VisãoDisciplina extends JPanel{
	
	private JLabel areaLabel;
	private JLabel nomeDisciplinaLabel;
	private JLabel cargaHorariaLabel;
	private JLabel turmaLabel;
	private JLabel instrucaoLabel;
	private ValidaçãoGeral nomeDisciplinaTextField;
	private JButton cadastrarJButton;
	private JCheckBox teoricaDisciplinaCheckBox;
	private JCheckBox praticaDisciplinaCheckBox;
	private JCheckBox estagioDisciplinaCheckBox;
	private JButton cancelarJButton;
	private JComboBox<String> cargaHorariaDisciplinaComboBox;
	private JLabel cursoJLabel;
	private ValidaçãoGeral cursoDisciplinaJTextField;
	private JButton passarADisciplinaJButton;
	private JButton passarTodasDisciplinasJButton;
	private JButton RetomarADisciplinaJButton;
	private JButton RetomarTodasAsDisciplinaJButton;
	private JLabel codigoJLabel;
	private JLabel preRequisitosJLabel;
	private ValidaçãoGeral codigoDisciplinaJTextField;
	private JLabel semestreLabel;
	private JComboBox<String> semestreJComboBox;
	private JButton nmeroDeDisciplinasButton;
	private JLabel disciplinasDisponveisLabel;
	private JScrollPane disciplinaDisponiveisScrollpane;
	private JScrollPane preRequisitosInseridosScrollpane;
	private JComboBox<String> areaDisciplinaJComboBox;
	private JList disciplinasDisponiveisJList;
	private JList preRequisitosInseridosJList;
	private DisciplinaList disciplinasList;
	private DisciplinaList preRequisitosList;
	
	/**
	 * Create the panel.
	 */
	public VisãoDisciplina() {
		super(null);
		inicializaComponentesDisciplina();		
	}
	
	public void inicializaComponentesDisciplina() {
		this.setSize(getMaximumSize());
		this.add(getAreaLabel());
		this.add(getNomeDisciplinaLabel());
		this.add(getCargaHorariaLabel());
		this.add(getLblTurma());
		this.add(getInstrucaoLabel());
		this.add(getNomeDisciplinaTextField());
		this.add(getCadastrarJButton());
		this.add(getTeoricaDisciplinaCheckBox());
		this.add(getPraticaDisciplinaCheckBox());
		this.add(getEstagioDisciplinaCheckBox());
		this.add(getCancelarJButton());
		this.add(getCargaHorariaDisciplinaComboBox());
		this.add(getCursoJLabel());
		this.add(getCursoDisciplinaJTextField());
		this.add(getPassarADisciplinaJButton());
		this.add(getPassarTodasDisciplinasJButton());
		this.add(getRetomarADisciplinaJButton());
		this.add(getRetomarTodasAsDisciplinaJButton());
		this.add(getCodigoJLabel());
		this.add(getPreRequisitosJLabel());
		this.add(getCodigoDisciplinaJTextField());
		this.add(getSemestreLabel());
		this.add(getSemestreJComboBox());
		this.add(getNmeroDeDisciplinasButton());
		this.add(getDisciplinasDisponveisLabel());
		this.add(getDisciplinaScrollpane());
		this.add(getPreRequisitosInseridosScrollpane());
		this.add(getAreaDisciplinaJComboBox());
	}
	
	public JLabel getAreaLabel() {
		if(areaLabel == null) {
			areaLabel = new JLabel("Área:");
			areaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			areaLabel.setBounds(62, 118, 43, 25);
		}
		return areaLabel;
	}
	
	public JLabel getNomeDisciplinaLabel() {
		if(nomeDisciplinaLabel == null) {
			nomeDisciplinaLabel = new JLabel("Nome:");
			nomeDisciplinaLabel.setToolTipText("Nome da disciplina");
			nomeDisciplinaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			nomeDisciplinaLabel.setBounds(52, 73, 43, 25);
		}
		return nomeDisciplinaLabel;
	}
	
	public JLabel getCargaHorariaLabel() {
		if(cargaHorariaLabel == null) {
			cargaHorariaLabel = new JLabel("Carga Hor\u00E1ria:");
			cargaHorariaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cargaHorariaLabel.setBounds(509, 86, 85, 25);
		}
		return cargaHorariaLabel;
	}
	private JLabel getLblTurma() {
		if (turmaLabel == null) {
			turmaLabel = new JLabel("Turma:");
			turmaLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			turmaLabel.setBounds(888, 73, 43, 14);
		}
		return turmaLabel;
	}
	private JLabel getInstrucaoLabel() {
		if (instrucaoLabel == null) {
			instrucaoLabel = new JLabel("Informa\u00E7\u00F5es da Disciplina:");
			instrucaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			instrucaoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			instrucaoLabel.setBounds(33, 37, 214, 25);
		}
		return instrucaoLabel;
	}
	public ValidaçãoGeral getNomeDisciplinaTextField() {
		if (nomeDisciplinaTextField == null) {
			nomeDisciplinaTextField = new ValidaçãoGeral("4");
			nomeDisciplinaTextField.setBounds(95, 75, 358, 23);
			nomeDisciplinaTextField.setColumns(10);
		}
		return nomeDisciplinaTextField;
	}
	public JButton getCadastrarJButton() {
		if (cadastrarJButton == null) {
			cadastrarJButton = new JButton("Cadastrar Disciplina");
			cadastrarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cadastrarJButton.setBounds(1170, 561, 143, 33);
		}
		return cadastrarJButton;
	}
	public JCheckBox getTeoricaDisciplinaCheckBox() {
		if (teoricaDisciplinaCheckBox == null) {
			teoricaDisciplinaCheckBox = new JCheckBox("Te\u00F3rica (Quantidade m\u00E1xima de alunos)");
			teoricaDisciplinaCheckBox.setBounds(888, 94, 230, 23);
		}
		return teoricaDisciplinaCheckBox;
	}
	public JCheckBox getPraticaDisciplinaCheckBox() {
		if (praticaDisciplinaCheckBox == null) {
			praticaDisciplinaCheckBox = new JCheckBox("Pr\u00E1tica (15 alunos)");
			praticaDisciplinaCheckBox.setBounds(888, 120, 155, 23);
		}
		return praticaDisciplinaCheckBox;
	}
	public JCheckBox getEstagioDisciplinaCheckBox() {
		if (estagioDisciplinaCheckBox == null) {
			estagioDisciplinaCheckBox = new JCheckBox("Est\u00E1gio (10 alunos)");
			estagioDisciplinaCheckBox.setBounds(888, 146, 135, 23);
		}
		return estagioDisciplinaCheckBox;
	}
	public JButton getCancelarJButton() {
		if (cancelarJButton == null) {
			cancelarJButton = new JButton("Cancelar");
			cancelarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cancelarJButton.setBounds(33, 561, 93, 33);
		}
		return cancelarJButton;
	}
	public JComboBox<String> getCargaHorariaDisciplinaComboBox() {
		if (cargaHorariaDisciplinaComboBox == null) {
			cargaHorariaDisciplinaComboBox = new JComboBox<String>();
			cargaHorariaDisciplinaComboBox.setToolTipText("Selecione");
			cargaHorariaDisciplinaComboBox.setBounds(598, 86, 197, 25);
			cargaHorariaDisciplinaComboBox.addItem("Selecione");
			cargaHorariaDisciplinaComboBox.addItem("30h (2 aulas/semana)");
			cargaHorariaDisciplinaComboBox.addItem("45h (3 aulas/semana)");
			cargaHorariaDisciplinaComboBox.addItem("60h (4 aulas/semana)");
			cargaHorariaDisciplinaComboBox.addItem("75h (5 aulas/semana)");
			cargaHorariaDisciplinaComboBox.addItem("90h (6 aulas/semana)");
		}
		return cargaHorariaDisciplinaComboBox;
	}
	private JLabel getCursoJLabel() {
		if (cursoJLabel == null) {
			cursoJLabel = new JLabel("Curso:");
			cursoJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cursoJLabel.setBounds(52, 168, 43, 14);
		}
		return cursoJLabel;
	}
	public ValidaçãoGeral getCursoDisciplinaJTextField() {
		if (cursoDisciplinaJTextField == null) {
			cursoDisciplinaJTextField = new ValidaçãoGeral("1");
			cursoDisciplinaJTextField.setBounds(95, 164, 358, 25);
			cursoDisciplinaJTextField.setColumns(10);
		}
		return cursoDisciplinaJTextField;
	}
	public JButton getPassarADisciplinaJButton() {
		if (passarADisciplinaJButton == null) {
			passarADisciplinaJButton = new JButton(">");
			passarADisciplinaJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			passarADisciplinaJButton.setToolTipText("Inserir a disciplina selecionada como pré-requisito");
			passarADisciplinaJButton.setBounds(614, 331, 52, 25);
		}
		return passarADisciplinaJButton;
	}
	public JButton getPassarTodasDisciplinasJButton() {
		if (passarTodasDisciplinasJButton == null) {
			passarTodasDisciplinasJButton = new JButton(">>");
			passarTodasDisciplinasJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			passarTodasDisciplinasJButton.setToolTipText("Inserir todas as disciplinas como pré-requisitos");
			passarTodasDisciplinasJButton.setBounds(614, 367, 52, 25);
		}
		return passarTodasDisciplinasJButton;
	}
	public JButton getRetomarADisciplinaJButton() {
		if (RetomarADisciplinaJButton == null) {
			RetomarADisciplinaJButton = new JButton("<");
			RetomarADisciplinaJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			RetomarADisciplinaJButton.setToolTipText("Retomar a disciplina selecionada");
			RetomarADisciplinaJButton.setBounds(614, 403, 52, 25);
		}
		return RetomarADisciplinaJButton;
	}
	public JButton getRetomarTodasAsDisciplinaJButton() {
		if (RetomarTodasAsDisciplinaJButton == null) {
			RetomarTodasAsDisciplinaJButton = new JButton("<<");
			RetomarTodasAsDisciplinaJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			RetomarTodasAsDisciplinaJButton.setToolTipText("Retomar todas as disciplinas inseridas");
			RetomarTodasAsDisciplinaJButton.setBounds(614, 439, 52, 25);
		}
		return RetomarTodasAsDisciplinaJButton;
	}
	private JLabel getCodigoJLabel() {
		if (codigoJLabel == null) {
			codigoJLabel = new JLabel("C\u00F3digo:");
			codigoJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			codigoJLabel.setBounds(53, 212, 46, 14);
		}
		return codigoJLabel;
	}
	private JLabel getPreRequisitosJLabel() {
		if (preRequisitosJLabel == null) {
			preRequisitosJLabel = new JLabel("Pr\u00E9-Requisitos:");
			preRequisitosJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			preRequisitosJLabel.setBounds(720, 274, 85, 14);
		}
		return preRequisitosJLabel;
	}
	public ValidaçãoGeral getCodigoDisciplinaJTextField() {
		if (codigoDisciplinaJTextField == null) {
			codigoDisciplinaJTextField = new ValidaçãoGeral("3");
			codigoDisciplinaJTextField.setBounds(96, 208, 101, 23);
			codigoDisciplinaJTextField.setColumns(10);
		}
		return codigoDisciplinaJTextField;
	}
	public JLabel getSemestreLabel() {
		if (semestreLabel == null) {
			semestreLabel = new JLabel("Semestre:");
			semestreLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			semestreLabel.setBounds(534, 136, 58, 14);
		}
		return semestreLabel;
	}
	public JComboBox<String> getSemestreJComboBox() {
		if (semestreJComboBox == null) {
			semestreJComboBox = new JComboBox<String>();
			semestreJComboBox.setBounds(598, 131, 121, 25);
			semestreJComboBox.addItem("Selecione");
			semestreJComboBox.addItem("1º");
			semestreJComboBox.addItem("2º");
			semestreJComboBox.addItem("3º");
			semestreJComboBox.addItem("4º");
			semestreJComboBox.addItem("5º");
			semestreJComboBox.addItem("6º");
			semestreJComboBox.addItem("7º");
			semestreJComboBox.addItem("8º");
			semestreJComboBox.addItem("9º");
			semestreJComboBox.addItem("10º");
		}
		return semestreJComboBox;
	}
	public JButton getNmeroDeDisciplinasButton() {
		if (nmeroDeDisciplinasButton == null) {
			nmeroDeDisciplinasButton = new JButton("N\u00FAmero de Disciplinas");
			nmeroDeDisciplinasButton.setBounds(1034, 230, 204, 25);
		}
		return nmeroDeDisciplinasButton;
	}
	public JLabel getDisciplinasDisponveisLabel() {
		if (disciplinasDisponveisLabel == null) {
			disciplinasDisponveisLabel = new JLabel("Disciplinas Dispon\u00EDveis:");
			disciplinasDisponveisLabel.setBounds(33, 274, 135, 14);
		}
		return disciplinasDisponveisLabel;
	}
	
	public JScrollPane getDisciplinaScrollpane() {
		if(disciplinaDisponiveisScrollpane == null) {
			disciplinaDisponiveisScrollpane = new JScrollPane(getDisciplinasDisponiveisJList());
			disciplinaDisponiveisScrollpane.setBounds(33, 299, 544, 213);
		}
		return disciplinaDisponiveisScrollpane;		
	}
	
	public JScrollPane getPreRequisitosInseridosScrollpane() {
		if(preRequisitosInseridosScrollpane == null) {
			preRequisitosInseridosScrollpane = new JScrollPane(getPreRequisitosInseridosJList());
			preRequisitosInseridosScrollpane.setBounds(720, 300, 542, 210);
		}
		return preRequisitosInseridosScrollpane;		
	}
	public JComboBox<String> getAreaDisciplinaJComboBox() {
		if (areaDisciplinaJComboBox == null) {
			areaDisciplinaJComboBox = new JComboBox<String>();
			areaDisciplinaJComboBox.setBounds(94, 118, 369, 25);
			areaDisciplinaJComboBox.addItem("Selecione");
			areaDisciplinaJComboBox.addItem("Departamento de Ciências Biológicas");
			areaDisciplinaJComboBox.addItem("Departamento de Ciências Humanas e Letras");
			areaDisciplinaJComboBox.addItem("Departamento de Ciências Tecnológicas");
			areaDisciplinaJComboBox.addItem("Departamento de Saúde I");
			areaDisciplinaJComboBox.addItem("Departamento de Saúde II");			
		}
		return areaDisciplinaJComboBox;
	}
	public JList getDisciplinasDisponiveisJList() {
		if (disciplinasDisponiveisJList == null) {
			disciplinasDisponiveisJList = new JList(getDisciplinasList().getListaDisciplinas());
			disciplinasDisponiveisJList.setBounds(33, 299, 544, 213);
		}
		return disciplinasDisponiveisJList;
	}
	public JList getPreRequisitosInseridosJList() {
		if (preRequisitosInseridosJList == null) {
			preRequisitosInseridosJList = new JList(getPreRequisitosList().getListaPreRequisitos());
			preRequisitosInseridosJList.setBounds(720, 300, 542, 210);
		}
		return preRequisitosInseridosJList;
	}
	
	public DisciplinaList getDisciplinasList() {
		if(disciplinasList == null) {
			disciplinasList = new DisciplinaList();
		}
		return disciplinasList;
	}
	
	public DisciplinaList getPreRequisitosList() {
		if(preRequisitosList == null) {
			preRequisitosList = new DisciplinaList();
		}
		return preRequisitosList;
	}
}
