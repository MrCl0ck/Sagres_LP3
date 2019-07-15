package universidade.modelo.validacao;

import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import universidade.modelo.ModeloAluno;
import universidade.modelo.persistencia.DadosAluno;

public class Valida��oAluno{
	private String nomeAluno;
	private String cpfAluno;
	private String matriculaAluno;
	private String rgAluno;
	private String cursoAluno;	
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoMatriculaCpfRg;
	
	
	
	public void abc() throws ParseException {
		MaskFormatter mascara = new MaskFormatter("***********************************");
		mascara.setValidCharacters("ASDASD");//COLOCAR AQUI DENTRO OS CARACTERES QUE S�O VALIDOS
	}
	
	
	
	public boolean isResultadoValidacaoMatriculaCpfRg() {
		return resultadoValidacaoMatriculaCpfRg;
	}

	public void setResultadoValidacaoMatriculaCpfRg(boolean resultadoValidacaoMatriculaCpfRg) {
		this.resultadoValidacaoMatriculaCpfRg = resultadoValidacaoMatriculaCpfRg;
	}

	public boolean isResultadoValidacaoTodosCamposGeral() {
		return resultadoValidacaoTodosCamposGeral;
	}

	public void setResultadoValidacaoTodosCamposGeral(boolean resultadoValidacaoTodosCamposGeral) {
		this.resultadoValidacaoTodosCamposGeral = resultadoValidacaoTodosCamposGeral;
	}

	public Valida��oAluno(String nomeAluno, String cpfAluno, String matriculaAluno, String rgAluno, String cursoAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.matriculaAluno = matriculaAluno;
		this.rgAluno = rgAluno;
		this.cursoAluno = cursoAluno;		
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());
		setResultadoValidacaoMatriculaCpfRg(validacaoMatriculaCpfRg());
	}

	public boolean validacaoTodosCamposGeral() {
		if(nomeAluno.trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Preencha o campo 'Nome'!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(cpfAluno.trim().equals(".   .   -")) {
			
			JOptionPane.showMessageDialog(null,"O campo 'CPF' deve conter 11 d�gitos!", "Erro", JOptionPane.ERROR_MESSAGE);
//			
//			if(cpfAluno.trim().equals(".   .   -")) {
//				JOptionPane.showMessageDialog(null, "Preencha o campo 'CPF'!", "Erro", JOptionPane.ERROR_MESSAGE);//VER VER VER
//			}
//			else{
//				JOptionPane.showMessageDialog(null,"O campo 'CPF' deve conter 11 d�gitos!", "Erro", JOptionPane.ERROR_MESSAGE);//VER VER VER
//			}
			
			
			return false;
		}
		if(matriculaAluno.length() < 9) {
			JOptionPane.showMessageDialog(null, "O campo 'Matr�cula' deve conter no m�nimo 9 d�gitos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(rgAluno.length() < 13 || rgAluno.trim().equals(".   .   -")) {
			
			JOptionPane.showMessageDialog(null,"O campo 'RG' deve conter 10 d�gitos!", "Erro", JOptionPane.ERROR_MESSAGE);
//			
//			if(rgAluno.length() < 13) {
//				JOptionPane.showMessageDialog(null,"O campo 'RG' deve conter 10 d�gitos!", "Erro", JOptionPane.ERROR_MESSAGE);
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "Preencha o campo 'RG'!", "Erro", JOptionPane.ERROR_MESSAGE);
//			}
			return false;
		}
		if(cursoAluno.equals("Selecione") || cursoAluno.equals("")) {
			JOptionPane.showMessageDialog(null, "Escolha um curso da lista!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public boolean validacaoMatriculaCpfRg() {
		DadosAluno alunoMatriculaCpfRg = new DadosAluno();
			
		for (ModeloAluno u: alunoMatriculaCpfRg.getAlunos()) {
			if(matriculaAluno.equals(u.getMatriculaString().toString())){
				JOptionPane.showMessageDialog(null, "Este n�mero de matr�cula j� foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(cpfAluno.equals(u.getCpfString().toString())){
				JOptionPane.showMessageDialog(null, "Este CPF j� foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(rgAluno.equals(u.getRgString().toString())){
				JOptionPane.showMessageDialog(null, "Este RG j� foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}		
		
		return true;
	}
}
