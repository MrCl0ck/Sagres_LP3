package universidade.visao;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

import universidade.modelo.listModel.DisciplinaList;
import universidade.modelo.persistencia.DadosDisciplina;
import universidade.modelo.tableModel.DisciplinaTableModel;
import universidade.modelo.validacao.ValidaçãoGeral;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class VisãoCurso extends JPanel {
	/**
	 * Create the panel.
	 */
	private ValidaçãoGeral nomeCursoJTextField;
	private JLabel nomeCursoJLabel;
	private JLabel instrucaoJLabel;
	private JLabel cargaHorariaTotalJLabel;
	private JLabel disciplinasDisponiveisJLabel;
	private JButton GerarFluxogramaJButtton;
	private JButton CadastrarNovaDisciplinaJButtton;
	private JButton cadastrarCursoJButton;
	private JButton cancelarJButton;
	private JFormattedTextField cargaHorariaTotalJFormattedTextField;
	private MaskFormatter cargaHorariaMaskFormatter = new MaskFormatter("#.###");
	private JLabel horasLabel;
	private DadosDisciplina cursoDisciplinaJList;
	private JList disciplinasDisponiveisJList;
	private JScrollPane jsp;
	private JLabel areaJLabel;
	private JComboBox<String> comboBox;
	
	public VisãoCurso() throws ParseException{
		super(null);
		inicializaComponentes();
	}
	
	public void inicializaComponentes() {
		this.setSize(getMaximumSize());
		this.add(getNomeCursoJTextField());
		this.add(getNomeCursoJLabel());
		this.add(getInstrucaoJLabel());
		this.add(getCargaHorariaTotalJLabel());
		this.add(getDisciplinasDisponiveisJLabel());
		add(getGerarFluxogramaJButtton());
		add(getCadastrarNovaDisciplinaJButtton());
		add(getCadastrarCursoJButton());
		add(getCancelarJButton());
		add(getCargaHorariaTotalJFormattedTextField());
		add(getHorasLabel());
		add(getJsp());
		add(getAreaJLabel());
		add(getComboBox());
	}
	
	public ValidaçãoGeral getNomeCursoJTextField() {
		if(nomeCursoJTextField == null) {
			nomeCursoJTextField = new ValidaçãoGeral("1");
			nomeCursoJTextField.setBounds(143, 132, 499, 25);
			nomeCursoJTextField.setColumns(10);
		}
		return nomeCursoJTextField;
	}
	
	public JLabel getNomeCursoJLabel() {
		if(nomeCursoJLabel == null) {
			nomeCursoJLabel = new JLabel("Nome do curso:");
			nomeCursoJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			nomeCursoJLabel.setBounds(48, 134, 95, 20);
		}		
		return nomeCursoJLabel;
	}
	
	public JLabel getInstrucaoJLabel() {
		if(instrucaoJLabel == null) {
			instrucaoJLabel = new JLabel("Informa\u00E7\u00F5es do Curso:");
			instrucaoJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			instrucaoJLabel.setBounds(23, 25, 170, 25);
		}
		return instrucaoJLabel;
	}
	private JLabel getCargaHorariaTotalJLabel() {
		if (cargaHorariaTotalJLabel == null) {
			cargaHorariaTotalJLabel = new JLabel("C.H Total:");
			cargaHorariaTotalJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cargaHorariaTotalJLabel.setToolTipText("Carga Hor\u00E1ria Total");
			cargaHorariaTotalJLabel.setBounds(701, 137, 57, 14);
		}
		return cargaHorariaTotalJLabel;
	}
	private JLabel getDisciplinasDisponiveisJLabel() {
		if (disciplinasDisponiveisJLabel == null) {
			disciplinasDisponiveisJLabel = new JLabel("Disciplinas Dispon\u00EDveis:");
			disciplinasDisponiveisJLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
			disciplinasDisponiveisJLabel.setBounds(48, 192, 128, 14);
		}
		return disciplinasDisponiveisJLabel;
	}
	public JButton getGerarFluxogramaJButtton() {
		if (GerarFluxogramaJButtton == null) {
			GerarFluxogramaJButtton = new JButton("Gerar Fluxograma");
			GerarFluxogramaJButtton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GerarFluxogramaJButtton.setBounds(735, 275, 185, 25);
		}
		return GerarFluxogramaJButtton;
	}
	public JButton getCadastrarNovaDisciplinaJButtton() {
		if (CadastrarNovaDisciplinaJButtton == null) {
			CadastrarNovaDisciplinaJButtton = new JButton("Cadastrar Nova Disciplina");
			CadastrarNovaDisciplinaJButtton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			CadastrarNovaDisciplinaJButtton.setBounds(735, 239, 185, 25);
		}
		return CadastrarNovaDisciplinaJButtton;
	}
	public JButton getCadastrarCursoJButton() {
		if (cadastrarCursoJButton == null) {
			cadastrarCursoJButton = new JButton("Cadastrar Curso");
			cadastrarCursoJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cadastrarCursoJButton.setBounds(858, 602, 116, 30);
		}
		return cadastrarCursoJButton;
	}
	public JButton getCancelarJButton() {
		if (cancelarJButton == null) {
			cancelarJButton = new JButton("Cancelar");
			cancelarJButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cancelarJButton.setBounds(48, 602, 90, 30);
		}
		return cancelarJButton;
	}
	public JFormattedTextField getCargaHorariaTotalJFormattedTextField() {
		if (cargaHorariaTotalJFormattedTextField == null) {
			cargaHorariaTotalJFormattedTextField = new JFormattedTextField(cargaHorariaMaskFormatter);
			cargaHorariaTotalJFormattedTextField.setBounds(756, 132, 47, 25);
		}
		return cargaHorariaTotalJFormattedTextField;
	}
	public JLabel getHorasLabel() {
		if (horasLabel == null) {
			horasLabel = new JLabel("horas");
			horasLabel.setBounds(804, 137, 46, 14);
		}
		return horasLabel;
	}
	public JList getDisciplinasDisponiveisJList() {
		if (disciplinasDisponiveisJList == null) {
			disciplinasDisponiveisJList = new JList(getDisciplinaJList().getListaDisciplinas());
			disciplinasDisponiveisJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			disciplinasDisponiveisJList.setBounds(47,152,643,341);
		}
		return disciplinasDisponiveisJList;
	}
	public DisciplinaList getDisciplinaJList(){
		if(cursoDisciplinaJList == null) {
			cursoDisciplinaJList = new DadosDisciplina();
		}
		return cursoDisciplinaJList.getDisciplinaLista();
	}
	
	public JScrollPane getJsp() {
		if(jsp == null) {
			jsp = new JScrollPane(getDisciplinasDisponiveisJList());
			jsp.setBounds(48,212,643,341);
		}
		return jsp;
	}
	private JLabel getAreaJLabel() {
		if (areaJLabel == null) {
			areaJLabel = new JLabel("\u00C1rea:");
			areaJLabel.setBounds(92, 98, 46, 14);
		}
		return areaJLabel;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(143, 93, 409, 25);
			comboBox.addItem("Selecione");
			comboBox.addItem("Departamento de Ciências Biológicas");
			comboBox.addItem("Departamento de Ciências Humanas e Letras");
			comboBox.addItem("Departamento de Ciências Tecnológicas");
			comboBox.addItem("Departamento de Saúde I");
			comboBox.addItem("Departamento de Saúde II");
		}
		return comboBox;
	}
}
