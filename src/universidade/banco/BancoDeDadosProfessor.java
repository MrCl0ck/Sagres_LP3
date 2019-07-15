package bancoDeDados;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DadosDoProfessor;

public class BancoDeDadosProfessor {
	
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
	// ########################################### GERENCIANDO PROFESSOR ###########################################
		
	public int cadastrarProfessor(DadosDoProfessor professor) { // ___________________________ Cadastrando Professor ___________________________
		
		int id = (ultimoIdProfessor() + 1);
		
		try {
			String query = "INSERT INTO bdsoftwareacademico2_0.professor (idProfessor, matriculaDoProfessor, nomeDoProfessor, "
					+ "areaDeAtuacaoProfessor, cargaHorariaDoProfessor, horarioDisponivelDoProfessor) values (" + id + "," +
					professor.getMatriculaProfessor() + ", \"" + professor.getNomeProfessor() + "\", \"" + professor.getAreaProfessor() 
					+ "\", \"" + professor.getCargaHorariaProfessor() + "\", \""  + "0000000000000000000000000000000000000" 
					+ "0000000000000000000000000000000000000000\");";  
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Professor Cadastrado com sucesso! <br> " + professor.getNomeProfessor() + "<br>" + 
					"Matrícula do Professor: " + String.valueOf(professor.getMatriculaProfessor()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int deletarProfessor(long matriculaDoProfessor, String nomeDoProfessor) { // ________________________ Deletar Professor ________________________
		try {
			String query = "DELETE FROM bdsoftwareacademico2_0.professor where matriculaDoProfessor = " + matriculaDoProfessor + ";";
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Professor Excluido com sucesso! <br> " + nomeDoProfessor + "<br>" + 
					"Matrícula do Professor: " + String.valueOf(matriculaDoProfessor) + "</html>");
			//JOptionPane.showMessageDialog(null, "<html>Produto Exluido com sucesso! <br> " + codigoProduto + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int AlterarProfessor(DadosDoProfessor professor) {  // ___________________________ Alterar Professor ___________________________

		try {
			String query = "UPDATE bdsoftwareacademico2_0.professor set " + "nomeDoProfessor = \"" + professor.getNomeProfessor() + 
					 "\", areaDeAtuacaoProfessor = \"" +  professor.getAreaProfessor() +  "\", cargaHorariaDoProfessor = \"" + 
					professor.getCargaHorariaProfessor() + "\" where matriculaDoProfessor = " + professor.getMatriculaProfessor() + ";";  
			
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "<html>Professor Alterado com sucesso! <br> " + professor.getNomeProfessor() + "<br>" + 
					"Matrícula do Professor: " + String.valueOf(professor.getMatriculaProfessor()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int ultimoIdProfessor() {  // ___________________________ Ultimo id_Professor Salvo ___________________________
		
		int  ultimoIdAluno = 0;
		
		String query = "SELECT idProfessor FROM bdsoftwareacademico2_0.professor WHERE idProfessor = (SELECT MAX(idProfessor) FROM " +
				 "bdsoftwareacademico2_0.professor);"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			ultimoIdAluno = this.resultSet.getInt("idProfessor");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return ultimoIdAluno;
	} //________________________________________________________________________________________________________________________
	
	public DadosDoProfessor ProfessorSelecionadoNaPesquisa(String text) { //__________________ Professor Selecionado na Pesquisa __________________
		
		DadosDoProfessor  professor = new DadosDoProfessor(text, "0", "0", "0");
		
		String query = "SELECT * FROM bdsoftwareacademico2_0.professor WHERE matriculaDoProfessor = " + text + ";"; 
		//"SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto)";
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			professor.setNomeProfessor(this.resultSet.getString("nomeDoProfessor"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			professor.setAreaProfessor(this.resultSet.getString("areaDeAtuacaoProfessor"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			professor.setCargaHorariaProfessor(this.resultSet.getString("cargaHorariaDoProfessor"));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return professor;
	} //________________________________________________________________________________________________________________________

	public DefaultTableModel listaDeProfessores(int index, String text) {  // ________________________ lista/ler Professores ________________________
		
		String query = null;
		DefaultTableModel listaDeProfessor = new DefaultTableModel(); 
		Vector<String> nomesDosProfessor = new Vector<String>();
		Vector<Integer> matriculasDosProfessor = new Vector<Integer>();
		Vector<String> areaDeAtuacaoDosProfessores = new Vector<String>();
		
		if(index == 1) {
			query = "SELECT * FROM bdsoftwareacademico2_0.professor where matriculaDoProfessor = " + text + ";" ;
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosProfessor.add(this.resultSet.getString("nomeDoProfessor"));
				}
				listaDeProfessor.addColumn("Nome", nomesDosProfessor);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					matriculasDosProfessor.add(this.resultSet.getInt("matriculaDoProfessor"));
				}
				listaDeProfessor.addColumn("Nº de Matrícula", matriculasDosProfessor);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					areaDeAtuacaoDosProfessores.add(this.resultSet.getString("areaDeAtuacaoProfessor"));
				}
				listaDeProfessor.addColumn("Área De Atuação", areaDeAtuacaoDosProfessores);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(index == 2) { 
			query = "SELECT * FROM bdsoftwareacademico2_0.professor WHERE nomeDoProfessor LIKE \"%" + text + "%\";";
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosProfessor.add(this.resultSet.getString("nomeDoProfessor"));
				}
				listaDeProfessor.addColumn("Nome", nomesDosProfessor);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					matriculasDosProfessor.add(this.resultSet.getInt("matriculaDoProfessor"));
				}
				listaDeProfessor.addColumn("Nº de Matrícula", matriculasDosProfessor);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					areaDeAtuacaoDosProfessores.add(this.resultSet.getString("areaDeAtuacaoProfessor"));
				}
				listaDeProfessor.addColumn("Área De Atuação", areaDeAtuacaoDosProfessores);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		return listaDeProfessor;
	} //________________________________________________________________________________________________________________________
}// ########################################### FIM GERENCIANDO PROFESSORES ###########################################