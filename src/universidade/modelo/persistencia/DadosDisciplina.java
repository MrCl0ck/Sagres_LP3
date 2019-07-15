package universidade.modelo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

import universidade.modelo.ModeloDisciplina;
import universidade.modelo.ModeloProfessor;
import universidade.modelo.listModel.DisciplinaList;
import universidade.modelo.tableModel.DisciplinaTableModel;

public class DadosDisciplina {
	static private ArrayList<ModeloDisciplina> disciplinasGeral = new ArrayList<>();
	private DisciplinaList disciplinaLista;
	private static String pasta = System.getProperty("user.dir");
	private static String arquivo = "\\Dados\\disciplina\\disciplina.txt"; 
	private static File caminho = new File(pasta+arquivo);
	private ModeloDisciplina disciplina; 
	
	public DisciplinaList getDisciplinaLista() {
		if(disciplinaLista == null) {
			disciplinaLista = new DisciplinaList();
		}
		return disciplinaLista;
	}
	
	public DadosDisciplina() {
		getDisciplinasArraylist();
		getDisciplinaLista();
	}
	
	public static boolean gravarArraylistDisciplinaArquivo(ArrayList<ModeloDisciplina> disciplinasGeraisArquivo){
		try{
			ObjectOutputStream saidaArquivo = new ObjectOutputStream(new FileOutputStream(caminho));//ele cria um arquivo de saída de objetos, dentro do construtor ele cria um arquivo de saída de stream com o caminho do arquivo.
			saidaArquivo.writeObject(disciplinasGeraisArquivo);//escreve no caminho informado o obejto passado por parâmetro
			saidaArquivo.flush();//obriga ao buffer escrever no arquivo
			saidaArquivo.close();//fecha a stream de gravação
			return true;
		}catch (IOException e) {
			System.out.println(e.getMessage());//pega a exceção e exibe
			return false;
		}		
	}
	
	public static boolean lerArraylistDisciplinaArquivo(ArrayList<ModeloDisciplina> disciplinasSalvasLeitura) {
		try {			
			ObjectInputStream entradaArquivo = new ObjectInputStream(new FileInputStream(caminho));//ele cria um arquivo de saída de objetos, dentro do construtor ele cria um arquivo de saída de stream com o caminho do arquivo.
			disciplinasSalvasLeitura = (ArrayList<ModeloDisciplina>)entradaArquivo.readObject();//força a conversão do arquivo lido no caminho para o tipo desejado, lê o objeto e converte.
			setDisciplinas(disciplinasSalvasLeitura);//atuliza a lista geral de professores que já foram cadastrados no programa
			entradaArquivo.close();	//fecha a stream de leitura			
			return true;				
			
		}catch (Exception e) {
			System.out.println(e.getMessage());//pega a exceção e exibe
			return false;
		}
	}
	
	public static void setDisciplinas(ArrayList<ModeloDisciplina> ProfessoresAtualizados){
		DadosDisciplina.disciplinasGeral = ProfessoresAtualizados;
		if(disciplinasGeral.size() > 0) {
			DadosDisciplina adicionarTabela = new DadosDisciplina();
			for (int i = 0; i < disciplinasGeral.size(); i++) {
				adicionarTabela.adicionarDisciplinaJList(disciplinasGeral.get(i).getNomeDisciplina() + "   -   " + disciplinasGeral.get(i).getCursoDisciplina() +
						"   -   " + disciplinasGeral.get(i).getCodigoDisciplina());
			}
		}	
	}
	
	public void salvarDadosArray(String nomeDisciplina, String areaDisciplina, String codigoDisciplina, String cursoDisciplina,
						         String cargaHorariaDisciplina, String semestreDisciplina, ArrayList<String>  turmaDisciplina, ArrayList<String> preRequisitosDisciplina) {
		disciplina = new ModeloDisciplina();
		disciplina.setNomeDisciplina(nomeDisciplina);
		disciplina.setAreaDisciplina(areaDisciplina);
		disciplina.setCodigoDisciplina(codigoDisciplina);
		disciplina.setCursoDisciplina(cursoDisciplina);
		disciplina.setCargaHorariaDisciplina(cargaHorariaDisciplina);
		disciplina.setSemestreDisciplina(semestreDisciplina);
		disciplina.setTurmaDisciplina(turmaDisciplina);
		disciplina.setPreRequisitosDisciplina(preRequisitosDisciplina);
		disciplinasGeral.add(disciplina);//ADICIONA NO ARRAYLIST
		getDisciplinaLista().getListaDisciplinas().addElement(nomeDisciplina + " - " +  cursoDisciplina + " - " + codigoDisciplina);//ADICIONA A DISCIPLINA NA TABELA
		if(gravarArraylistDisciplinaArquivo(getDisciplinasArraylist())){//grava o arraylist atual no arquivo, vai sobrescrevendo
			System.out.println("Gravado com sucesso no arquivo!");
		}
		JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//**********************************************DISCIPLINAS****************************************************************
	
	public void eliminarDadosArrayDisciplina(int indice) {
		disciplinasGeral.remove(indice);
	}
	
	public void adicionarDisciplinaJList(String disciplina) {
		disciplinaLista.getListaDisciplinas().addElement(disciplina);
	}
	
	public ArrayList<ModeloDisciplina> getDisciplinasArraylist(){
		return disciplinasGeral;
	}	
	
	public int getNumeroDisciplinasArraylist() {
		return disciplinasGeral.size();
	}
	
	public void imprimirDisciplinas() {
		int i = 1;
		for (ModeloDisciplina u:disciplinasGeral) {
			System.out.println("*****************************************************************");
			System.out.println("Disciplina cadastrada na posição: " + i);
			System.out.println("Nome: " + u.getNomeDisciplina());
			System.out.println("Área: " + u.getAreaDisciplina());
			System.out.println("Código: " + u.getCodigoDisciplina());
			System.out.println("Curso: " + u.getCursoDisciplina());
			System.out.println("Carga Horária: " + u.getCargaHorariaDisciplina());
			System.out.println("Semestre: " + u.getSemestreDisciplina());
			System.out.println("Turma: " + u.getTurmaDisciplina());
			System.out.println("Pré-Requisitos: " + u.getPreRequisitosDisciplina());
			System.out.println("*****************************************************************");
			i++;
		}
	}

	//****************************************************************************************************************************************

	//**********************************************PRE-REQUISITOS****************************************************************
			
	
	
	//****************************************************************************************************************************************
}
