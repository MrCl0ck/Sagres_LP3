package universidade.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import universidade.modelo.ModeloDisciplina;
import universidade.modelo.persistencia.DadosDisciplina;
import universidade.modelo.tableModel.DisciplinaTableModel;
import universidade.modelo.validacao.Valida��oCurso;
import universidade.modelo.validacao.Valida��oDisciplina;
import universidade.visao.Vis�oCurso;
import universidade.visao.Vis�oJDialog;
import universidade.visao.Vis�oTabbedPane;

public class ControladorCurso{
	private Vis�oCurso cursoJPanel;
	private Vis�oTabbedPane abas;
	private String nomeCurso;
	private ArrayList<String> disciplinasDisponiveisCurso;
	private String cargaHorariaTotalCurso;
	
	public ControladorCurso(Vis�oTabbedPane cursoTabbed, JFrame frame) throws ParseException{
		cursoJPanel = new Vis�oCurso();
		abas = cursoTabbed;
		cursoJPanel = cursoTabbed.getTelaCurso();
		eventosAdd();
	}
	
	public void eventosAdd() {
		cursoJPanel.getCadastrarCursoJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		cursoJPanel.getCancelarJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DadosDisciplina disciplina = new DadosDisciplina();
				
				System.out.println("N�mero de Disciplinas: " + disciplina.getNumeroDisciplinasArraylist());
				disciplina.imprimirDisciplinas();
				JOptionPane.showMessageDialog(null, "N�mero de Disciplinas: " + disciplina.getNumeroDisciplinasArraylist());
			}
		});
		cursoJPanel.getCadastrarNovaDisciplinaJButtton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				abas.setSelectedIndex(2);
			}
		});
	}
	
	private void capturarCamposAction() {	
		disciplinasDisponiveisCurso = new ArrayList<>();
		this.nomeCurso = cursoJPanel.getNomeCursoJTextField().getText();
		this.cargaHorariaTotalCurso = cursoJPanel.getCargaHorariaTotalJFormattedTextField().getText();
		int numDisciplinas = cursoJPanel.getDisciplinaJList().getListaDisciplinas().getSize();
		
		for (int i = 0; i < numDisciplinas; i++) {
			disciplinasDisponiveisCurso.add(cursoJPanel.getDisciplinaJList().getListaDisciplinas().get(i));
		}		
	}
	
	public void validacaoCursoCampos() {
		Valida��oCurso disciplina_val = new Valida��oCurso();
		
	}
	
}
