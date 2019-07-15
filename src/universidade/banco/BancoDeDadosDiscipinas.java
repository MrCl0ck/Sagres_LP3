package universidade.banco;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import universidade.modelo.ModeloDisciplina;

public class BancoDeDadosDiscipinas {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar() { // ___________________________ Conectando ___________________________
		
		String servidor = "jdbc:mysql://localhost:3306/universidade?useTimezone=true&serverTimezone=UTC";
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
	// ########################################### GERENCIANDO Disciplina ###########################################
		
	public int cadastrarDisciplina(ModeloDisciplina disciplina) { // ___________________________ Cadastrando Disciplina ___________________________
		
		int id = (ultimoIdDisciplina() + 1);
		
		try {
			String query = "INSERT INTO universidade.disciplina(idDisciplina, codigoDisciplina, nomeDaDisciplina, areaDisciplina, "
					+ "cargaHorariaDaDisciplina, semestresDaDisciplina, tiposDeAulasDisciplina) values (" + id + ", \"" + 
					disciplina.getCodigoDisciplina()+ "\", \"" + disciplina.getNomeDisciplina() + "\", \"" + disciplina.getAreaDisciplina() + "\", \"" + 
					disciplina.getCargaHorariaDisciplina() + "\", " +	Integer.parseInt(disciplina.getSemestreDisciplina()) + ", \"" 
					+ disciplina.getTurmaDisciplina()  + "\");";  
			
			this.statement.executeUpdate(query);
			
			String query2 = null;
			ArrayList<String> vetor = new ArrayList<String>();
			vetor = disciplina.getPreRequisitosDisciplina();
		
				int id1 = idDisciplina(disciplina.getCodigoDisciplina());
				int id2 = 0;
				if(disciplina.getPreRequisitosDisciplina().size() > 0) {	
					
					String palavra = null;
					String text = null;
					
					for(int i = 0; i < vetor.size(); i++) {
						
						palavra = vetor.get(i);
						
						id2 = idDisciplina(palavra);
						query2 = "INSERT INTO universidade.disciplina_pre_requisito(idDisciplina, preRequsito_idDisciplina1) values (" +
								id1 + ", " + id2 + ");";
						
						//JOptionPane.showMessageDialog(null, String.valueOf(id1) +  "   " +String.valueOf(id2));
						this.statement.executeUpdate(query2);
					}
				}
			JOptionPane.showMessageDialog(null, "<html>Disciplina Cadastrado com sucesso! <br> " + disciplina.getNomeDisciplina() + "<br>" + 
					"Matrícula do Aluno: " + String.valueOf(disciplina.getCodigoDisciplina()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int deletarDisciplina(String codigoDaDisciplina, String nomeDaDisciplina) { // ________________________ Deletar Disciplina ________________________
		try {
			int id1 = idDisciplina(codigoDaDisciplina);
			String query1 = "DELETE FROM universidade.disciplina_pre_requisito WHERE idDisciplina = " + id1; 
			
			this.statement.executeUpdate(query1);
			
			String query2 = "DELETE FROM universidade.disciplina where codigoDisciplina = \"" + codigoDaDisciplina + "\";";
			
			this.statement.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "<html>Disciplina Excluido com sucesso! <br> " + nomeDaDisciplina + "<br>" + 
					"Código da Disciplina: " + String.valueOf(codigoDaDisciplina) + "</html>");
			//JOptionPane.showMessageDialog(null, "<html>Produto Exluido com sucesso! <br> " + codigoProduto + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int AlterarDisciplina(ModeloDisciplina disciplina) {  // ___________________________ Alterar Disciplina ___________________________

		try {
			String query = "UPDATE universidade.disciplina set " + "nomeDaDisciplina = \"" + disciplina.getNomeDisciplina() + 
					 "\", areaDisciplina = \"" + disciplina.getAreaDisciplina() + "\", cargaHorariaDaDisciplina = \"" + 
					 disciplina.getCargaHorariaDisciplina() + "\", semestresDaDisciplina = " + disciplina.getSemestreDisciplina() + 
					 ", tiposDeAulasDisciplina = \"" + disciplina.getTurmaDisciplina() + "\" where codigoDisciplina = \"" + 
					 disciplina.getCodigoDisciplina() + "\";";  
			
			this.statement.executeUpdate(query);
			
			String query2 = null;
			ArrayList<String> vetor = new ArrayList<String>();
			vetor = disciplina.getPreRequisitosDisciplina();
			
			int id1 = idDisciplina(disciplina.getCodigoDisciplina());
			query2 = "DELETE FROM universidade.disciplina_pre_requisito WHERE idDisciplina = " + id1; 
			
			//JOptionPane.showMessageDialog(null, String.valueOf(id1) +  "   " +String.valueOf(id2));
			this.statement.executeUpdate(query2);
			
				int id2 = 0;
				if(disciplina.getPreRequisitosDisciplina().size() > 0) {	
					
					String palavra = null;
					String text = null;
					
					for(int i = 0; i < vetor.size(); i++) {
						
						palavra = vetor.get(i);
						
						id2 = idDisciplina(palavra);
						query2 = "INSERT INTO universidade.disciplina_pre_requisito(idDisciplina, preRequsito_idDisciplina1) values (" +
								id1 + ", " + id2 + ");";
						
						this.statement.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, String.valueOf(id1) +  "   " +String.valueOf(id2));
					}
				}
			
			JOptionPane.showMessageDialog(null, "<html>Disciplina Alterada com sucesso! <br> " + disciplina.getNomeDisciplina() + "<br>" + 
					"Matrícula do Aluno: " + String.valueOf(disciplina.getCodigoDisciplina()) + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int ultimoIdDisciplina() {  // ___________________________ Ultimo id_Disciplina Salvo ___________________________
		
		int  ultimoIdDisciplina = 0;
		
		String query = "SELECT idDisciplina FROM universidade.disciplina WHERE idDisciplina = (SELECT MAX(idDisciplina) FROM " +
				 "universidade.disciplina);"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			ultimoIdDisciplina = this.resultSet.getInt("idDisciplina");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return ultimoIdDisciplina;
	} //________________________________________________________________________________________________________________________
	
	public int idDisciplina(String codigoDisc) {  // ___________________________ Ultimo id_Disciplina Salvo ___________________________
		
		int  IdDisciplina = 0;
		
		String query = "SELECT idDisciplina FROM universidade.disciplina WHERE codigoDisciplina = \"" + codigoDisc + "\";"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			IdDisciplina = this.resultSet.getInt("idDisciplina");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return IdDisciplina;
	} //________________________________________________________________________________________________________________________
	
	public ModeloDisciplina DisciplinaSelecionadoNaPesquisa(String text) { //__________________ Disciplina Selecionado na Pesquisa __________________
		
		ModeloDisciplina  disciplina = new ModeloDisciplina(text, "0", "0", "0", "0", null, "0");
		
		String query = "SELECT * FROM universidade.disciplina WHERE codigoDisciplina = \"" + text + "\";"; 
		//"SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto)";
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			disciplina.setNomeDisciplina(this.resultSet.getString("nomeDaDisciplina"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			disciplina.setAreaDisciplina(this.resultSet.getString("areaDisciplina"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			disciplina.setCargaHorariaDisciplina(this.resultSet.getString("cargaHorariaDaDisciplina"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			disciplina.setSemestreDisciplina(this.resultSet.getString("semestresDaDisciplina"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			disciplina.setTurmaDisciplina(this.resultSet.getString("tiposDeAulasDisciplina"));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return disciplina;
	} //________________________________________________________________________________________________________________________

	public DefaultTableModel listaDeDisciplinas(int index, String text) {  // ________________________ lista/ler Disciplinas  ________________________
		
		String query = null;
		DefaultTableModel listaDeDisciplinas = new DefaultTableModel(); 
		Vector<String> nomesDasDisciplinas = new Vector<String>();
		Vector<String> codigoDasDisciplinas = new Vector<String>();
		Vector<String> areaDasDisciplinas = new Vector<String>();
		Vector<String> cargaHorariaDasDisciplinas = new Vector<String>();
		Vector<String> semestresDasDisciplinas = new Vector<String>();
		
		if(index == 1) {
			query = "SELECT * FROM universidade.disciplina where codigoDisciplina LIKE \"%" + text + "%\";" ;
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					codigoDasDisciplinas.add(this.resultSet.getString("codigoDisciplina"));
				}
				listaDeDisciplinas.addColumn("Código", codigoDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDasDisciplinas.add(this.resultSet.getString("nomeDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Nome", nomesDasDisciplinas);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cargaHorariaDasDisciplinas.add(this.resultSet.getString("areaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Área", cargaHorariaDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					areaDasDisciplinas.add(this.resultSet.getString("cargaHorariaDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Carga Horária", areaDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					semestresDasDisciplinas.add(this.resultSet.getString("semestresDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Semestre", semestresDasDisciplinas);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(index == 2) {
			query = "SELECT * FROM universidade.disciplina WHERE nomeDaDisciplina LIKE \"%" + text + "%\";";
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					codigoDasDisciplinas.add(this.resultSet.getString("codigoDisciplina"));
				}
				listaDeDisciplinas.addColumn("Código", codigoDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDasDisciplinas.add(this.resultSet.getString("nomeDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Nome", nomesDasDisciplinas);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cargaHorariaDasDisciplinas.add(this.resultSet.getString("areaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Área", cargaHorariaDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					areaDasDisciplinas.add(this.resultSet.getString("cargaHorariaDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Carga Horária", areaDasDisciplinas);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					semestresDasDisciplinas.add(this.resultSet.getString("semestresDaDisciplina"));
				}
				listaDeDisciplinas.addColumn("Semestre", semestresDasDisciplinas);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		return listaDeDisciplinas;
	} //________________________________________________________________________________________________________________________
	public DefaultListModel listarDisciplinas() {  // ________________________ lista/ler Disciplinas  ________________________
		
		DefaultListModel<String> listaDisciplina = new DefaultListModel<String>();
	
		String query = "SELECT * FROM universidade.disciplina;";
		
		try {
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				listaDisciplina.addElement(this.resultSet.getString("codigoDisciplina") + " - " + this.resultSet.getString("nomeDaDisciplina"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
		}
		return listaDisciplina;
	}
}// ########################################### FIM GERENCIANDO Disciplina ###########################################