package universidade.modelo.listModel;

import javax.swing.DefaultListModel;

public class DisciplinaList {
	private static DefaultListModel<String> listaDisciplinas;
	private static DefaultListModel<String> listaPreRequisitos;
	
	public DefaultListModel<String> getListaDisciplinas() {
		if(listaDisciplinas == null) {
			listaDisciplinas = new DefaultListModel<>();
		}
		return listaDisciplinas;
	}
	
	public DefaultListModel<String> getListaPreRequisitos() {
		if(listaPreRequisitos == null) {
			listaPreRequisitos = new DefaultListModel<>();
		}
		return listaPreRequisitos;
	}
}
