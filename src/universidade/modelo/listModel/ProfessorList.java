package universidade.modelo.listModel;

import javax.swing.DefaultListModel;

public class ProfessorList {
	private static DefaultListModel<String> listaProfessoresDisponiveis;
	private static DefaultListModel<String> listaProfessoresInseridos;
	
	public DefaultListModel<String> getListaProfessoresDisponiveis(){
		if(listaProfessoresDisponiveis == null) {
			listaProfessoresDisponiveis = new DefaultListModel<>();
		}
		return listaProfessoresDisponiveis;
	}
	
	public DefaultListModel<String> getListaProfessoresInseridos(){
		if(listaProfessoresInseridos == null) {
			listaProfessoresInseridos = new DefaultListModel<>();
		}
		return listaProfessoresInseridos;
	}
}
