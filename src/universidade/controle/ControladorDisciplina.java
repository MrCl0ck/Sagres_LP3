package universidade.controle;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import universidade.modelo.ModeloDisciplina;
import universidade.modelo.persistencia.DadosAluno;
import universidade.modelo.persistencia.DadosDisciplina;
import universidade.modelo.validacao.ValidaçãoDisciplina;
import universidade.visao.VisãoDisciplina;
import universidade.visao.VisãoTabbedPane;

public class ControladorDisciplina{
	private VisãoDisciplina disciplinaJPanel;
	private String nomeDisciplina;
	private String areaDisciplina;
	private String codigoDisciplina;
	private String cursoDisciplina;
	private String cargaHorariaDisciplina;
	private ArrayList<String> turmaDisciplina;
	private String semestreDisciplina;
	private ArrayList<String> preRequisitosDisciplina;
	
	
	public ControladorDisciplina(VisãoTabbedPane disciplinaAba, JFrame frame) throws ParseException{
		disciplinaJPanel = new VisãoDisciplina();
		disciplinaJPanel = disciplinaAba.getTelaDisciplina();
		eventosAdd();
	}
	
	public void eventosAdd() {
		cadastrarJButtonAction();
		cancelarJButtonAction();
		numeroDeDisciplinasJButtonAction();
		praticaSelecionadaAction();
		estagioSelecionadaAction();
		passarADisciplinaJButtonAction();
		retomarADisciplinaJButtonAction();
		passsarDisciplinaDuploClique();
		DadosDisciplina.lerArraylistDisciplinaArquivo(new ArrayList<ModeloDisciplina>());
	}

	private void capturarCamposAction() {	
		turmaDisciplina = new ArrayList<>();
		preRequisitosDisciplina = new ArrayList<>();
		this.nomeDisciplina = disciplinaJPanel.getNomeDisciplinaTextField().getText();
		this.areaDisciplina = disciplinaJPanel.getAreaDisciplinaJComboBox().getSelectedItem().toString();
		this.codigoDisciplina = disciplinaJPanel.getCodigoDisciplinaJTextField().getText();
		this.cursoDisciplina = disciplinaJPanel.getCursoDisciplinaJTextField().getText();
		this.cargaHorariaDisciplina = disciplinaJPanel.getCargaHorariaDisciplinaComboBox().getSelectedItem().toString();
		this.semestreDisciplina = disciplinaJPanel.getSemestreJComboBox().getSelectedItem().toString();
		
		
		if(disciplinaJPanel.getTeoricaDisciplinaCheckBox().isSelected() == true){
			this.turmaDisciplina.add("Teórica");
		}
		else {
			this.turmaDisciplina.add("");
		}
		if(disciplinaJPanel.getPraticaDisciplinaCheckBox().isSelected() == true) {
			this.turmaDisciplina.add("Prática");
		}
		else {
			this.turmaDisciplina.add("");
		}
		if(disciplinaJPanel.getEstagioDisciplinaCheckBox().isSelected() == true) {
			this.turmaDisciplina.add("Estágio");
		}
		else {
			this.turmaDisciplina.add("");
		}
		
		//colocar pra pegar os cógidos dos pré-requisitos inseridos ao lado.
	}
	
	public void validacaoDisciplinaCampos() {
		ValidaçãoDisciplina disciplina_val = new ValidaçãoDisciplina(nomeDisciplina, areaDisciplina, codigoDisciplina, cursoDisciplina,
																	cargaHorariaDisciplina, semestreDisciplina, turmaDisciplina);
		
		if(disciplina_val.isResultadoValidacaoTodosCamposGeral() == true && disciplina_val.isResultadoCodigo() == true){
			DadosDisciplina disciplinaSalva = new DadosDisciplina();
					
			disciplinaSalva.salvarDadosArray(nomeDisciplina, areaDisciplina, codigoDisciplina, cursoDisciplina, 
											 cargaHorariaDisciplina, semestreDisciplina, turmaDisciplina, preRequisitosDisciplina);
		}
	}
	
	public void praticaSelecionadaAction() {
		disciplinaJPanel.getPraticaDisciplinaCheckBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				disciplinaJPanel.getEstagioDisciplinaCheckBox().setSelected(false);
			}
		});
	}
	
	public void estagioSelecionadaAction() {
		disciplinaJPanel.getEstagioDisciplinaCheckBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				disciplinaJPanel.getPraticaDisciplinaCheckBox().setSelected(false);
			}
		});
	}
	
	public void cancelarJButtonAction() {
		disciplinaJPanel.getCancelarJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public void cadastrarJButtonAction() {
		disciplinaJPanel.getCadastrarJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				capturarCamposAction();	
				validacaoDisciplinaCampos();
			}
		});		
	}
	
	public void numeroDeDisciplinasJButtonAction() {
		disciplinaJPanel.getNmeroDeDisciplinasButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DadosDisciplina disciplina = new DadosDisciplina();
		
				System.out.println("Número de Disciplinas: " + disciplina.getNumeroDisciplinasArraylist());
				disciplina.imprimirDisciplinas();
			}
		});
		
		
	}
	
	public void passsarDisciplinaDuploClique() {
		disciplinaJPanel.getDisciplinasDisponiveisJList().addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int linhaSelecionada = -1;
					
					
					linhaSelecionada = disciplinaJPanel.getDisciplinasDisponiveisJList().getSelectedIndex();
					
					if(linhaSelecionada != -1) {
						String preRequisito = disciplinaJPanel.getDisciplinasList().getListaDisciplinas().get(linhaSelecionada);
						disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().addElement(preRequisito);				
						disciplinaJPanel.getDisciplinasList().getListaDisciplinas().remove(linhaSelecionada);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		disciplinaJPanel.getPreRequisitosInseridosJList().addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int linhaSelecionada = -1;
					
					
					linhaSelecionada = disciplinaJPanel.getPreRequisitosInseridosJList().getSelectedIndex();
					
					if(linhaSelecionada != -1) {
						String disciplina = disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().get(linhaSelecionada);
						disciplinaJPanel.getDisciplinasList().getListaDisciplinas().addElement(disciplina);				
						disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().remove(linhaSelecionada);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}
	
	public void passarADisciplinaJButtonAction() {
		disciplinaJPanel.getPassarADisciplinaJButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String preRequisito;
				int linhaSelecionada = -1;
				
				linhaSelecionada = disciplinaJPanel.getDisciplinasDisponiveisJList().getSelectedIndex();
				
				if(linhaSelecionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina disponível!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else {					
					preRequisito = new String();
					preRequisito = disciplinaJPanel.getDisciplinasList().getListaDisciplinas().get(linhaSelecionada);
				
					disciplinaJPanel.getDisciplinasList().getListaDisciplinas().remove(linhaSelecionada);//remove da tabela disciplina a disciplina que foi passada pro outro lado
					disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().addElement(preRequisito);//adiciona aquelas informações a tabela de pré-requisito
				}
				
			}
		});
	}
		
		public void retomarADisciplinaJButtonAction() {
			disciplinaJPanel.getRetomarADisciplinaJButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String disciplina;
					int linhaSelecionada = -1;
					
					linhaSelecionada = disciplinaJPanel.getPreRequisitosInseridosJList().getSelectedIndex();
					
					if(linhaSelecionada == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um pré-requisito!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else {					
						disciplina = new String();
						disciplina = disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().get(linhaSelecionada);						
						
						disciplinaJPanel.getPreRequisitosList().getListaPreRequisitos().remove(linhaSelecionada);//remove da tabela pré-requisitos
						disciplinaJPanel.getDisciplinasList().getListaDisciplinas().addElement(disciplina);//adiciona aquelas informações a tabela de disiplina
					}
					
				}
			});
		}
		
//		public void passarTodasDisciplinasJButtonAction() {
//			disciplinaJPanel.getPassarTodasDisciplinasJButton().addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					ModeloDisciplina preRequisito;			
//					int contLinhas = -1;
//					
//					System.out.println("Número de linhas antes:" + contLinhas);
//					
//					contLinhas = disciplinaJPanel.getDisciplinasDisponiveisJTable().getRowCount();
//					
//					System.out.println("Número de linhas depois:" + contLinhas);
//					
//					if(contLinhas == 0) {
//						JOptionPane.showMessageDialog(null, "Tabela vazia!", "ERRO", JOptionPane.ERROR_MESSAGE);
//					}
//					else {					
//						preRequisito = new ModeloDisciplina();
//												
//						for (int i = 1; i <= contLinhas; i++) {
//							preRequisito = disciplinaJPanel.getDisciplinaTable().getDisciplina(i);	
//							disciplinaJPanel.getDisciplinaTable().removerDisciplina(i);//remove da tabela disciplina a disciplina que foi passada pro outro lado
//						    disciplinaJPanel.getPreRequisitoTable().addDisciplina(preRequisito);//adiciona aquelas informações a tabela de pré-requisito
//						}
//						
//					}
//					
//				}
//			});
//		}
//		
//		public void retomarTodasAsDisciplinaJButtonAction() {
//			disciplinaJPanel.getRetomarTodasAsDisciplinaJButton().addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					ModeloDisciplina preRequisito;
//					int contLinhas = -1;
//					
//					System.out.println("Número de linhas antes:" + contLinhas);
//					
//					contLinhas = disciplinaJPanel.getPreRequisitoTable().getRowCount();
//					
//					System.out.println("Número de linhas depois:" + contLinhas);
//					
//					if(contLinhas == 0) {
//						JOptionPane.showMessageDialog(null, "Tabela vazia!", "ERRO", JOptionPane.ERROR_MESSAGE);
//					}
//					else {					
//						preRequisito = new ModeloDisciplina();
//						
//						for (int i = 0; i < contLinhas; i++) {
//							preRequisito = disciplinaJPanel.getPreRequisitoTable().getDisciplina(i);	
//							disciplinaJPanel.getPreRequisitoTable().removerDisciplina(i);//remove da tabela pré-requisitos
//						    disciplinaJPanel.getDisciplinaTable().addDisciplina(preRequisito);//adiciona aquelas informações a tabela de disciplinas
//						}
//					}
//					
//				}
//			});
//		}
}
