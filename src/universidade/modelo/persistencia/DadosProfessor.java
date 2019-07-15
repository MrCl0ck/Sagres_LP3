package universidade.modelo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import universidade.modelo.ModeloProfessor;
import universidade.modelo.listModel.ProfessorList;

public class DadosProfessor {
	static private ArrayList<ModeloProfessor> professoresGeral = new ArrayList<>();
	private ProfessorList professorLista; 
	private static String pasta = System.getProperty("user.dir");
	private static String arquivo = "\\Dados\\professor\\professor.txt"; 
	private static File caminho = new File(pasta+arquivo);
	private ModeloProfessor professor;

	public ProfessorList getProfessorLista() {
		if(professorLista == null) {
			professorLista = new ProfessorList();
		}
		return professorLista;
	}
	
	public DadosProfessor() {
		getProfessores();
		getProfessorLista();	
	}	
	
	public static boolean gravarArraylistProfessorArquivo(ArrayList<ModeloProfessor> professoresGeraisArquivo){
		try{
			ObjectOutputStream saidaArquivo = new ObjectOutputStream(new FileOutputStream(caminho));//ele cria um arquivo de saída de objetos, dentro do construtor ele cria um arquivo de saída de stream com o caminho do arquivo.
			saidaArquivo.writeObject(professoresGeraisArquivo);//escreve no caminho informado o obejto passado por parâmetro
			saidaArquivo.flush();//obriga ao buffer escrever no arquivo
			saidaArquivo.close();//fecha a stream de gravação
			return true;
		}catch (IOException e) {
			System.out.println(e.getMessage());//pega a exceção e exibe
			return false;
		}		
	}
	
	public static boolean lerArraylistProfessorArquivo(ArrayList<ModeloProfessor> professoresSalvosLeitura) {
		try {			
			ObjectInputStream entradaArquivo = new ObjectInputStream(new FileInputStream(caminho));//ele cria um arquivo de saída de objetos, dentro do construtor ele cria um arquivo de saída de stream com o caminho do arquivo.
			professoresSalvosLeitura = (ArrayList<ModeloProfessor>)entradaArquivo.readObject();//força a conversão do arquivo lido no caminho para o tipo desejado, lê o objeto e converte.
			setProfessores(professoresSalvosLeitura);//atuliza a lista geral de professores que já foram cadastrados no programa
			entradaArquivo.close();	//fecha a stream de leitura			
			return true;				
			
		}catch (Exception e) {
			System.out.println(e.getMessage());//pega a exceção e exibe
			return false;
		}
	}
	
	public void adicionarProfessorDisponivelJList(String professor) {
		professorLista.getListaProfessoresDisponiveis().addElement(professor);
	}
	
	public void adicionarProfessorInseridoJList(String professor) {
		professorLista.getListaProfessoresInseridos().addElement(professor);
	}
	
	public static void setProfessores(ArrayList<ModeloProfessor> ProfessoresAtualizados){
		DadosProfessor.professoresGeral = ProfessoresAtualizados;
	}
	
	public ArrayList<ModeloProfessor> getProfessores() {
		return professoresGeral;
	}
			
	public int getNumeroProfessores() {
		return professoresGeral.size();
	}	
	
	public void salvarDadosArray(String nome, String area, String matricula, String cargaHoraria) {
		professor = new ModeloProfessor();
		professor.setNomeString(nome);
		professor.setAreaString(area);
		professor.setMatriculaString(matricula);
		professor.setCargaHorariaString(cargaHoraria);
		professoresGeral.add(professor);//adiciona o novo professor no arraylist
		adicionarProfessorDisponivelJList(nome + "   -   " + area + "   -   " + matricula + "   -   " + cargaHoraria);
		if(gravarArraylistProfessorArquivo(getProfessores())) {//grava o arraylist atual no arquivo, vai sobrescrevendo
			System.out.println("Gravado com sucesso no arquivo!");
		}
		JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void eliminarDadosArray(int indice) {
		professoresGeral.remove(indice);
	}
	
	public void imprimirProfessores() {
		for (ModeloProfessor u:professoresGeral) {
			System.out.println("Nome:" + u.getNomeString());
			System.out.println("Area:" + u.getAreaString());
			System.out.println("Matrícula:" + u.getMatriculaString());
			System.out.println("Carga Horária:" + u.getCargaHorariaString());
		}
	}	
	
}
