package universidade.modelo.listModel;

import javax.swing.DefaultListModel;

public class AlunoList {
	private static DefaultListModel<String> listaAlunosDisponiveis;
	private static DefaultListModel<String> listaAlunosInseridos;
	
	public DefaultListModel<String> getListaAlunosDisponiveis(){
		if(listaAlunosDisponiveis == null) {
			listaAlunosDisponiveis = new DefaultListModel<>();
		}
		return listaAlunosDisponiveis;
	}
	
	public DefaultListModel<String> getListaAlunosInseridos(){
		if(listaAlunosInseridos == null) {
			listaAlunosInseridos = new DefaultListModel<>();
		}
		return listaAlunosInseridos;
	}
}
