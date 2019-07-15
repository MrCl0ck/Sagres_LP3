package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import universidade.modelo.ModeloAluno;
import universidade.modelo.persistencia.DadosAluno;
import universidade.modelo.validacao.ValidaçãoAluno;
import universidade.visao.VisãoAluno;
import universidade.visao.VisãoTabbedPane;

public class ControladorAluno{
	private VisãoAluno alunoJPanel;
	private String nomeAluno;
	private String cpfAluno;
	private String matriculaAluno;
	private String rgAluno;
	private String cursoAluno;

	public ControladorAluno(VisãoTabbedPane alunoAba, JFrame frame) throws ParseException {
		alunoJPanel = new VisãoAluno();
		alunoJPanel = alunoAba.getTelaAluno();
		eventosAdd();
		DadosAluno.lerArraylistAlunoArquivo( new ArrayList<ModeloAluno>() );
		frame.repaint();
		frame.validate();
	}
	
	public void eventosAdd() throws ParseException {
		alunoJPanel.getCadastrarAlunoJButton().addActionListener(new ActionListener() {//cadastrar o aluno, caso esteja tudo validado certinho...
			
			@Override
			public void actionPerformed(ActionEvent e) {
				capturarCamposAction();	
				validacaoAlunoCampos();
			}
			
		});
		alunoJPanel.getCancelarJButton().addActionListener(new ActionListener() {//cancelar a ação, voltar pra tela de login
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
//				try {
//					new ControladorTelaInicio(alunoJFrame).getFrameI().setVisible(true);
//					alunoJFrame.dispose();
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
			
		});
		alunoJPanel.getNmeroDeAlunosButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DadosAluno aluno = new DadosAluno();
				
				System.out.println("Número de Alunos: " + aluno.getNumeroAlunos());
				aluno.imprimirAlunos();
				JOptionPane.showMessageDialog(null, "Número de Alunos: " + new DadosAluno().getNumeroAlunos());
			}
			
		});
	}
	
	private void capturarCamposAction() {
		this.nomeAluno = alunoJPanel.getNomeTextField().getText();
		this.cpfAluno = alunoJPanel.getCpfTextField().getText();
		this.matriculaAluno = alunoJPanel.getMatriculaTextField().getText();
		this.rgAluno = alunoJPanel.getRgTextField().getText();
		
		if(alunoJPanel.getCursoComboBox().getSelectedItem() == null) {
			this.cursoAluno = "";
		}else {
			this.cursoAluno = alunoJPanel.getCursoComboBox().getSelectedItem().toString();
		}		
		
//		System.out.println("Nome: " + nomeAluno);
//		System.out.println("CPF trimmed:" + cpfAluno.trim());
//		System.out.println("Matricula: " + matriculaAluno);
//		System.out.println("RG trimmed:" + rgAluno.trim());
//		System.out.println("Curso:" + cursoAluno);
	}
	
	public void validacaoAlunoCampos() {
		ValidaçãoAluno aluno_val = new ValidaçãoAluno(nomeAluno, cpfAluno, matriculaAluno, rgAluno, cursoAluno);
		
		if(aluno_val.isResultadoValidacaoTodosCamposGeral() == true && aluno_val.isResultadoValidacaoMatriculaCpfRg() == true){
			DadosAluno alunoSalvo = new DadosAluno();
			alunoSalvo.salvarDadosArray(nomeAluno, cpfAluno, matriculaAluno, rgAluno, cursoAluno);
		}
	}
}
