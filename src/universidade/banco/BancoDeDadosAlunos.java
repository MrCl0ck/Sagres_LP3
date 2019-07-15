package bancoDeDados;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DadosDoAluno;

public class BancoDeDadosAlunos {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar() { // ___________________________ Conectando ___________________________
		
		String servidor = "jdbc:mysql://localhost:3306/bdsoftwareacademico2_0?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "root";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void fechaConeccao() { // ___________________________ Fechando Conecção ___________________________
		try {
			if (statement != null)
				statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean estaConectado () { // ___________________________ Estado de Concção ___________________________
		if(this.connection != null) {
			return true;
		}
		else {
			return false;
		}
	}
	// ########################################### GERENCIANDO ALUNO ###########################################
		
	public int cadastrarAluno(DadosDoAluno aluno) { // ___________________________ Cadastrando Aluno ___________________________
		
		int id = (ultimoIdAluno() + 1);
		
		try {
			String query = "INSERT INTO bdsoftwareacademico2_0.aluno(idAluno, matriculaDoAluno, nomeDoAluno, cpfDoAluno, rgDoAluno," +    							"cursoDoAluno,horarioDisponivelDoAluno) values (" + id + "," + aluno.getMatriculaAluno() + ", \"" + 
							aluno.getNomeAluno() + "\", \"" + aluno.getCpfAluno() + "\", \"" + aluno.getRgAluno() + "\", \"" +
							aluno.getCursoAluno() + "\", \""  + "0000000000000000000000000000000000000" + 			 							"0000000000000000000000000000000000000000\");";  
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Aluno Cadastrado com sucesso! <br> " + aluno.getNomeAluno() + "<br>" + 
					"Matrícula do Aluno: " + String.valueOf(aluno.getMatriculaAluno()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int deletarAluno(long matriculaDoAluno, String nomeDoAluno) { // ________________________ Deletar Aluno ________________________
		try {
			String query = "DELETE FROM bdsoftwareacademico2_0.aluno where matriculaDoAluno = " + matriculaDoAluno + ";";
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Aluno Excluido com sucesso! <br> " + nomeDoAluno + "<br>" + 
					"Matrícula do Aluno: " + String.valueOf(matriculaDoAluno) + "</html>");
			//JOptionPane.showMessageDialog(null, "<html>Produto Exluido com sucesso! <br> " + codigoProduto + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int AlterarAluno(DadosDoAluno aluno) {  // ___________________________ Alterar Aluno ___________________________

		try {
			String query = "UPDATE bdsoftwareacademico2_0.aluno set " + "nomeDoAluno = \"" + aluno.getNomeAluno() + 
					 "\", cpfDoAluno = \"" +  aluno.getCpfAluno() +  "\", rgDoAluno = \"" + aluno.getRgAluno() + "\", cursoDoAluno = \"" + 					aluno.getCursoAluno() + "\" where matriculaDoAluno = " + aluno.getMatriculaAluno() + ";";  
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Aluno Alterado com sucesso! <br> " + aluno.getNomeAluno() + "<br>" + 
					"Matrícula do Aluno: " + String.valueOf(aluno.getMatriculaAluno()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int ultimoIdAluno() {  // ___________________________ Ultimo id_Aluno Salvo ___________________________
		
		int  ultimoIdAluno = 0;
		
		String query = "SELECT idAluno FROM bdsoftwareacademico2_0.aluno WHERE idAluno = (SELECT MAX(idAluno) FROM " +
				 "bdsoftwareacademico2_0.aluno);"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			ultimoIdAluno = this.resultSet.getInt("idAluno");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return ultimoIdAluno;
	} //________________________________________________________________________________________________________________________
	
	public DadosDoAluno AlunoSelecionadoNaPesquisa(String text) { //__________________ Aluno Selecionado na Pesquisa __________________
		
		DadosDoAluno  aluno = new DadosDoAluno(text, "0", "0", "0", "0");
		
		String query = "SELECT * FROM bdsoftwareacademico2_0.aluno WHERE matriculaDoAluno = " + text + ";"; 
		//"SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto)";
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			aluno.setNomeAluno(this.resultSet.getString("nomeDoAluno"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			aluno.setCpfAluno(this.resultSet.getString("cpfDoAluno"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			aluno.setRgAluno(this.resultSet.getString("rgDoAluno"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			aluno.setCursoAluno(this.resultSet.getString("cursoDoAluno"));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return aluno;
	} //________________________________________________________________________________________________________________________

	public DefaultTableModel listaDeAlunos(int index, String text) {  // ________________________ lista/ler Alunos ________________________
		
		String query = null;
		DefaultTableModel listaDeAlunos = new DefaultTableModel(); 
		Vector<String> nomesDosAlunos = new Vector<String>();
		Vector<Integer> matriculasDosAlunos = new Vector<Integer>();
		Vector<String> cpfDosAlunos = new Vector<String>();
		Vector<String> cursosDosAlunos = new Vector<String>();
		
		if(index == 1) {
			query = "SELECT * FROM bdsoftwareacademico2_0.aluno WHERE nomeDoAluno LIKE \"%" + text + "%\";";
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosAlunos.add(this.resultSet.getString("nomeDoAluno"));
				}
				listaDeAlunos.addColumn("Nome", nomesDosAlunos);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cpfDosAlunos.add(this.resultSet.getString("cpfDoAluno"));
				}
				listaDeAlunos.addColumn("cpf", cpfDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					matriculasDosAlunos.add(this.resultSet.getInt("matriculaDoAluno"));
				}
				listaDeAlunos.addColumn("Nº de Matrícula", matriculasDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cursosDosAlunos.add(this.resultSet.getString("cursoDoAluno"));
				}
				listaDeAlunos.addColumn("curso", cursosDosAlunos);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(index == 2) {
			query = "SELECT * FROM bdsoftwareacademico2_0.aluno where matriculaDoAluno = " + text + ";" ;
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosAlunos.add(this.resultSet.getString("nomeDoAluno"));
				}
				listaDeAlunos.addColumn("Nome", nomesDosAlunos);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cpfDosAlunos.add(this.resultSet.getString("cpfDoAluno"));
				}
				listaDeAlunos.addColumn("cpf", cpfDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					matriculasDosAlunos.add(this.resultSet.getInt("matriculaDoAluno"));
				}
				listaDeAlunos.addColumn("Nº de Matrícula", matriculasDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cursosDosAlunos.add(this.resultSet.getString("cursoDoAluno"));
				}
				listaDeAlunos.addColumn("curso", cursosDosAlunos);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(index == 3) {
			query = "SELECT * FROM bdsoftwareacademico2_0.aluno where cpfDoAluno LIKE \"%" + text + "%\";" ;
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosAlunos.add(this.resultSet.getString("nomeDoAluno"));
				}
				listaDeAlunos.addColumn("Nome", nomesDosAlunos);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cpfDosAlunos.add(this.resultSet.getString("cpfDoAluno"));
				}
				listaDeAlunos.addColumn("cpf", cpfDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					matriculasDosAlunos.add(this.resultSet.getInt("matriculaDoAluno"));
				}
				listaDeAlunos.addColumn("Nº de Matrícula", matriculasDosAlunos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cursosDosAlunos.add(this.resultSet.getString("cursoDoAluno"));
				}
				listaDeAlunos.addColumn("curso", cursosDosAlunos);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		return listaDeAlunos;
	} //________________________________________________________________________________________________________________________
}// ########################################### FIM GERENCIANDO ALUNO ###########################################