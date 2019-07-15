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
import universidade.modelo.validacao.ValidaçãoCurso;
import universidade.modelo.validacao.ValidaçãoDisciplina;
import universidade.visao.VisãoCurso;
import universidade.visao.VisãoJDialog;
import universidade.visao.VisãoTabbedPane;

public class ControladorCurso{
	private VisãoCurso cursoJPanel;
	private VisãoTabbedPane abas;
	private String nomeCurso;
	private ArrayList<String> disciplinasDisponiveisCurso;
	private String cargaHorariaTotalCurso;
	
	public ControladorCurso(VisãoTabbedPane cursoTabbed, JFrame frame) throws ParseException{
		cursoJPanel = new VisãoCurso();
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
				
				System.out.println("Número de Disciplinas: " + disciplina.getNumeroDisciplinasArraylist());
				disciplina.imprimirDisciplinas();
				JOptionPane.showMessageDialog(null, "Número de Disciplinas: " + disciplina.getNumeroDisciplinasArraylist());
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
		ValidaçãoCurso disciplina_val = new ValidaçãoCurso();
		
	}
	
}
