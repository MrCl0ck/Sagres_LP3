package universidade.modelo;

import java.io.Serializable;

public class ModeloProfessor implements Serializable{
	private static final long serialVersionUID = 4L;
	private String nomeString;
	private String areaString;
	private String matriculaString;
	private String cargaHorariaString;
	
	public String getNomeString() {
		return nomeString;
	}
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}
	public String getAreaString() {
		return areaString;
	}
	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}
	public String getMatriculaString() {
		return matriculaString;
	}
	public void setMatriculaString(String matriculaString) {
		this.matriculaString = matriculaString;
	}
	public String getCargaHorariaString() {
		return cargaHorariaString;
	}
	public void setCargaHorariaString(String cargaHorariaString) {
		this.cargaHorariaString = cargaHorariaString;
	}
	
	
}
