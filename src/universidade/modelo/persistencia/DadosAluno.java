package universidade.modelo.persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import universidade.modelo.ModeloAluno;
import universidade.modelo.listModel.AlunoList;

public class DadosAluno {
	static private ArrayList<ModeloAluno> AlunosGeral = new ArrayList<>();
	private static String pasta = System.getProperty("user.dir");
	private static String arquivo = "\\Dados\\aluno\\aluno.txt"; 
	private static File caminho = new File(pasta+arquivo);	
	private AlunoList alunoLista;
	private ModeloAluno Aluno; 
	
	public AlunoList getAlunoLista() {
		if(alunoLista == null) {
			alunoLista = new AlunoList();
		}
		return alunoLista;
	}
	
	public DadosAluno() {
		getAlunos();	
		getAlunoLista();
	}
	
	public static boolean gravarArraylistAlunoArquivo(ArrayList<ModeloAluno> alunosGeraisArquivo){
		try{
			ObjectOutputStream saidaArquivo = new ObjectOutputStream(new FileOutputStream(caminho));//ele cria u		
			saidaArquivo.writeObject(alunosGeraisArquivo);
			saidaArquivo.flush();
			saidaArquivo.close();
			return true;
		}catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean lerArraylistAlunoArquivo(ArrayList<ModeloAluno> alunosSalvosLeitura) {
		try {			
			ObjectInputStream entradaArquivo = new ObjectInputStream(new FileInputStream(caminho));
			alunosSalvosLeitura = (ArrayList<ModeloAluno>)entradaArquivo.readObject();
			setAlunos(alunosSalvosLeitura);
			entradaArquivo.close();				
			return true;				
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void salvarDadosArray(String nome, String cpf, String matricula, String rg, String curso) {
		Aluno = new ModeloAluno();
		Aluno.setNomeString(nome);
		Aluno.setCpfString(cpf);
		Aluno.setMatriculaString(matricula);
		Aluno.setRgString(rg);
		Aluno.setCursoString(curso);
		AlunosGeral.add(Aluno);//adiciona o novo aluno no arraylist
		adicionarAlunoDisponivelJList(nome + "   -   " + curso + "   -   " + matricula);
		if(gravarArraylistAlunoArquivo(getAlunos())) {//grava o arraylist atual no arquivo, vai sobrescrevendo
			System.out.println("Gravado com sucesso no arquivo!");
		}
		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public void adicionarAlunoDisponivelJList(String aluno) {
		alunoLista.getListaAlunosDisponiveis().addElement(aluno);
	}
	
	public void adicionarAlunoInseridoJList(String alnuo) {
		alunoLista.getListaAlunosInseridos().addElement(alnuo);
	}
	
	public void eliminarDadosArray(int indice) {
		AlunosGeral.remove(indice);
	}
	
	public ArrayList<ModeloAluno> getAlunos(){
		return AlunosGeral;
	}	
	
	public static void setAlunos(ArrayList<ModeloAluno> AlunosAtualizados){
		DadosAluno.AlunosGeral = AlunosAtualizados;
	}
	
	public int getNumeroAlunos() {
		return AlunosGeral.size();
	}
	
	public void imprimirAlunos() {
		for (ModeloAluno u:AlunosGeral) {
			System.out.println("Nome: " + u.getNomeString());
			System.out.println("CPF: " + u.getCpfString());
			System.out.println("Matrícula: " + u.getMatriculaString());
			System.out.println("RG: " + u.getRgString());
			System.out.println("Curso: " + u.getCursoString());
		}
	}	
	
}
