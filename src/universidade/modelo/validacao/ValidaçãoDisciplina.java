package universidade.modelo.validacao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import universidade.banco.BancoDeDadosDiscipinas;
import universidade.modelo.ModeloDisciplina;
import universidade.modelo.persistencia.DadosDisciplina;

public class Valida��oDisciplina{
	private String nomeDisciplina;
	private String areaDisciplina;
	private String codigoDisciplina;
	private String cursoDisciplina;
	private String cargaHorariaDisciplina;	
	private ArrayList<String> turmaDisciplina = new ArrayList<>();
	private String semestreDisciplina;
	//private String[] preRequisitosDisciplina; 
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoCodigo;
	
	public boolean isResultadoValidacaoTodosCamposGeral() {
		return resultadoValidacaoTodosCamposGeral;
	}

	public void setResultadoValidacaoTodosCamposGeral(boolean resultadoValidacaoTodosCamposGeral) {
		this.resultadoValidacaoTodosCamposGeral = resultadoValidacaoTodosCamposGeral;
	}

	public boolean isResultadoCodigo() {
		return resultadoCodigo;
	}

	public void setResultadoCodigo(boolean resultadoCodigo) {
		this.resultadoCodigo = resultadoCodigo;
	}

	public Valida��oDisciplina(String nomeDisciplina, String areaDisciplina, String codigoDisciplina,
			String cursoDisciplina, String cargaHorariaDisciplina, String semestreDisciplina, ArrayList<String> turmaDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.areaDisciplina = areaDisciplina;
		this.codigoDisciplina = codigoDisciplina;
		this.cursoDisciplina = cursoDisciplina;
		this.cargaHorariaDisciplina = cargaHorariaDisciplina;
		this.semestreDisciplina = semestreDisciplina;
		this.turmaDisciplina = turmaDisciplina;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());
		setResultadoCodigo(validacaoCodigo());
	}
	
	public boolean validacaoTodosCamposGeral() {
		int cont = 0;
		if(nomeDisciplina.trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Preencha o campo 'Nome'!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(areaDisciplina.equals("Selecione")) {
			JOptionPane.showMessageDialog(null,"Escolha uma �rea da lista!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(codigoDisciplina.trim().equals("") || codigoDisciplina.length() < 4) {
			JOptionPane.showMessageDialog(null,"O c�digo da disciplina deve conter as siglas da '�rea' mais a posi��o de cadastro", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(cursoDisciplina.trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Preencha o campo 'Curso'!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(cargaHorariaDisciplina.equals("Selecione")) {
			JOptionPane.showMessageDialog(null,"Escolha uma carga hor�ria da lista!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}
		for (String u: turmaDisciplina) {
			if(u.equals("")) {
				cont++;	
			}
		}		
		if(cont == 3) {
			JOptionPane.showMessageDialog(null,"Escolha uma das turmas!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(semestreDisciplina.equals("Selecione")) {
			JOptionPane.showMessageDialog(null,"Escolha um semestre da lista!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;	
		}
		return true;
	}
	
	public boolean validacaoCodigo() {
		BancoDeDadosDiscipinas disciplinaCodigo = new BancoDeDadosDiscipinas(); 
			
		for (ModeloDisciplina u: disciplinaCodigo.listarDisciplinas()) {
			if(nomeDisciplina.equals(u.getNomeDisciplina().toString()) && codigoDisciplina.equals(u.getCodigoDisciplina().toString())){
				JOptionPane.showMessageDialog(null, "Esta disciplina j� foi cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(codigoDisciplina.equals(u.getCodigoDisciplina().toString())){
				JOptionPane.showMessageDialog(null, "Este c�digo j� foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(nomeDisciplina.equals(u.getNomeDisciplina().toString()) && cursoDisciplina.equals(u.getCursoDisciplina().toString())){
				JOptionPane.showMessageDialog(null, "J� existe uma disciplina de mesmo nome nesse curso!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
				
			}
		}		
		
		return true;
	}
	
	
}
