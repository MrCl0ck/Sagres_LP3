package universidade.modelo.validacao;

import javax.swing.JOptionPane;

import universidade.modelo.ModeloProfessor;
import universidade.modelo.persistencia.DadosProfessor;

public class ValidaçãoProfessor{
	
	private String nomeProfessor;
	private String areaProfessor;
	private String matriculaProfessor;
	private String cargahorariaProfessor;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoMatricula;
	
	public boolean isResultadoValidacaoMatricula() {
		return resultadoValidacaoMatricula;
	}

	public void setResultadoValidacaoMatriculaCpfRg(boolean resultadoValidacaoMatriculaCpfRg) {
		this.resultadoValidacaoMatricula = resultadoValidacaoMatriculaCpfRg;
	}

	public boolean isResultadoValidacaoTodosCamposGeral() {
		return resultadoValidacaoTodosCamposGeral;
	}

	public void setResultadoValidacaoTodosCamposGeral(boolean resultadoValidacaoTodosCamposGeral) {
		this.resultadoValidacaoTodosCamposGeral = resultadoValidacaoTodosCamposGeral;
	}

	public ValidaçãoProfessor(String nomeProfessor, String areaProfessor, String matriculaProfessor, String cargaHorariaProfessor) {
		this.nomeProfessor = nomeProfessor;
		this.areaProfessor = areaProfessor;
		this.matriculaProfessor = matriculaProfessor;
		this.cargahorariaProfessor = cargaHorariaProfessor;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());
		setResultadoValidacaoMatriculaCpfRg(validacaoMatricula());
	}

	public boolean validacaoTodosCamposGeral() {
		if(nomeProfessor.trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Preencha o campo 'Nome'!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(areaProfessor.equals("Selecione")) {			
			JOptionPane.showMessageDialog(null,"Escolha uma área da lista!", "Erro", JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		if(matriculaProfessor.length() < 9) {
			JOptionPane.showMessageDialog(null, "O campo 'Matrícula' deve conter no mínimo 9 dígitos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(cargahorariaProfessor.equals("Selecione") || cargahorariaProfessor.equals("")) {
			JOptionPane.showMessageDialog(null, "Escolha uma carga horária da lista!", "Erro", JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		return true;
	}
	
	public boolean validacaoMatricula() {
		DadosProfessor professorMatricula = new DadosProfessor();
			
		for (ModeloProfessor u: professorMatricula.getProfessores()) {
			if(matriculaProfessor.equals(u.getMatriculaString().toString())){
				JOptionPane.showMessageDialog(null, "Este número de matrícula já foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}		
		
		return true;
	}
	
	
}
