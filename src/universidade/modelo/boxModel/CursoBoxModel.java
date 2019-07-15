package universidade.modelo.boxModel;

import javax.swing.DefaultComboBoxModel;

public class CursoBoxModel {
	private static DefaultComboBoxModel<String> cursoBoxModel = new DefaultComboBoxModel<>();
	private static DefaultComboBoxModel<String> cursoFixoBoxModel = new DefaultComboBoxModel<>();
	
	public DefaultComboBoxModel<String> getCursoBoxModelEmDisciplina(){
		return cursoBoxModel;
	}
	
	public DefaultComboBoxModel<String> getCursoFixoBoxModelEmDis(){
		return cursoBoxModel;
	}
}
