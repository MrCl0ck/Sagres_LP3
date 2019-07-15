package universidade.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class ModeloCurso implements Serializable{
	private static final long serialVersionUID = 2L;
	//fluxograma
	private String nomeCurso;
	private ArrayList<String> disciplinasDisponiveisCurso;
	private String cargaHorariaTotalCurso;
	
	public ModeloCurso(String nomeCurso, ArrayList<String> disciplinasDisponiveisCurso, String cargaHorariaTotalCurso) {
		this.nomeCurso = nomeCurso;
		this.disciplinasDisponiveisCurso = disciplinasDisponiveisCurso;
		this.cargaHorariaTotalCurso = cargaHorariaTotalCurso;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public ArrayList<String> getDisciplinasDisponiveisCurso() {
		return disciplinasDisponiveisCurso;
	}
	public void setDisciplinasDisponiveisCurso(ArrayList<String> disciplinasDisponiveisCurso) {
		this.disciplinasDisponiveisCurso = disciplinasDisponiveisCurso;
	}
	public String getCargaHorariaTotalCurso() {
		return cargaHorariaTotalCurso;
	}
	public void setCargaHorariaTotalCurso(String cargaHorariaTotalCurso) {
		this.cargaHorariaTotalCurso = cargaHorariaTotalCurso;
	}
	
	
}
