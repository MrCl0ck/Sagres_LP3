package universidade.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ModeloDisciplina implements Serializable{
	private static final long serialVersionUID = 3L; 

	private String nomeDisciplina;
	private String areaDisciplina;
	private String codigoDisciplina;
	private String cursoDisciplina;
	private String cargaHorariaDisciplina;
	private String semestreDisciplina;
	private ArrayList<String> turmaDisciplina;	
	private ArrayList<String> preRequisitosDisciplinaCodigo;
	
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getAreaDisciplina() {
		return areaDisciplina;
	}
	public void setAreaDisciplina(String areaDisciplina) {
		this.areaDisciplina = areaDisciplina;
	}
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public String getCursoDisciplina() {
		return cursoDisciplina;
	}
	public void setCursoDisciplina(String cursoDisciplina) {
		this.cursoDisciplina = cursoDisciplina;
	}
	public String getCargaHorariaDisciplina() {
		return cargaHorariaDisciplina;
	}
	public void setCargaHorariaDisciplina(String cargaHorariaDisciplina) {
		this.cargaHorariaDisciplina = cargaHorariaDisciplina;
	}
	public String getSemestreDisciplina() {
		return semestreDisciplina;
	}
	public void setSemestreDisciplina(String semestreDisciplina) {
		this.semestreDisciplina = semestreDisciplina;
	}
	public ArrayList<String> getTurmaDisciplina() {
		return turmaDisciplina;
	}
	public void setTurmaDisciplina(ArrayList<String> turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}
	public ArrayList<String> getPreRequisitosDisciplina() {
		return preRequisitosDisciplinaCodigo;
	}
	public void setPreRequisitosDisciplina(ArrayList<String> preRequisitosDisciplina2) {
		this.preRequisitosDisciplinaCodigo = preRequisitosDisciplina2;
	}
	
	
	
	
}
