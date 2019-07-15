package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import universidade.modelo.ModeloProfessor;
import universidade.modelo.persistencia.DadosProfessor;
import universidade.modelo.validacao.ValidaçãoProfessor;
import universidade.visao.VisãoProfessor;
import universidade.visao.VisãoTabbedPane;

public class ControladorProfessor{
	private VisãoProfessor professorJPanel;
	private String nomeProfessor;
	private String areaProfessor;
	private String matriculaProfessor;
	private String cargaHorariaProfessor;

	public ControladorProfessor(VisãoTabbedPane professorAba, JFrame frame) throws ParseException{
		professorJPanel = new VisãoProfessor();
		professorJPanel = professorAba.getTelaProfessor();
		eventosAdd();
		DadosProfessor.lerArraylistProfessorArquivo(new ArrayList<ModeloProfessor>());
		frame.repaint();
		frame.validate();
	}
	
	public void eventosAdd() {		
		professorJPanel.getCadastrarProfessorButton().addActionListener(new ActionListener() {//cadastrar o aluno, caso esteja tudo validado certinho...
			
			@Override
			public void actionPerformed(ActionEvent e) {
				capturarCamposAction();	
				validacaoProfessorCampos();
			}
			
		});
		professorJPanel.getCancelarJButton().addActionListener(new ActionListener() {//cancelar a ação, voltar pra tela de login
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});		
		professorJPanel.getNmeroDeProfessoresButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DadosProfessor professor = new DadosProfessor();
				
				System.out.println("Número de Professores: " + professor.getNumeroProfessores());
				professor.imprimirProfessores();
				JOptionPane.showMessageDialog(null, "Número de Professores: " + new DadosProfessor().getNumeroProfessores());
			}
			
		});
	}
	
	private void capturarCamposAction() {
		this.nomeProfessor = professorJPanel.getNomeTextField().getText();
		this.areaProfessor = professorJPanel.getAreaDisciplinaJComboBox().getSelectedItem().toString();
		this.matriculaProfessor = professorJPanel.getMatriculaTextField().getText();
		this.cargaHorariaProfessor = professorJPanel.getCargaHorariaComboBox().getSelectedItem().toString();
	}
	
	public void validacaoProfessorCampos() {
		ValidaçãoProfessor professor_val = new ValidaçãoProfessor(nomeProfessor, areaProfessor, matriculaProfessor, cargaHorariaProfessor);
		
		if(professor_val.isResultadoValidacaoTodosCamposGeral() == true && professor_val.isResultadoValidacaoMatricula() == true){
			DadosProfessor professorSalvo = new DadosProfessor();
			professorSalvo.salvarDadosArray(nomeProfessor, areaProfessor, matriculaProfessor, cargaHorariaProfessor);
		}
	}
}
