package universidade.modelo;

import java.io.Serializable;

public class ModeloAluno implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nomeString;
	private String cpfString;
	private String rgString;
	private String matriculaString;
	private String cursoString;
	
	public String getNomeString() {
		return nomeString;
	}
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}
	public String getCpfString() {
		return cpfString;
	}
	public void setCpfString(String cpfString) {
		this.cpfString = cpfString;
	}
	public String getRgString() {
		return rgString;
	}
	public void setRgString(String rgString) {
		this.rgString = rgString;
	}
	public String getMatriculaString() {
		return matriculaString;
	}
	public void setMatriculaString(String matriculaString) {
		this.matriculaString = matriculaString;
	}
	public String getCursoString() {
		return cursoString;
	}
	public void setCursoString(String cursoJComboBox) {
		this.cursoString = cursoJComboBox;
	}
	
	
}
