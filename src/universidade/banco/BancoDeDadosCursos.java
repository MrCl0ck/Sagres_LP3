package bancoDeDados;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DadosDoCurso;

public class BancoDeDadosCursos {
	
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
	// ########################################### GERENCIANDO Disciplina ###########################################
		
	public int cadastrarCurso(DadosDoCurso curso) { // ___________________________ Cadastrando Curso ___________________________
		
		int id = (ultimoIdCurso() + 1);
		
		try {
			String query = "INSERT INTO bdsoftwareacademico2_0.curso(idCurso, nomeDoCurso, tipoDoCurso, cargaHorariaTotalDoCurso) values ("
					+ id + ", \"" + curso.getNomeCurso()+ "\", \"" + curso.getTipoBac_Lic() + "\", \"" + curso.getCargaHorariaTotal() + "\");";  
			
			this.statement.executeUpdate(query);
			
			String query2 = null;
			ArrayList<String> vetor = new ArrayList<String>();
			vetor = curso.getDisciplinas();
		
			int id1 = id;
			int id2 = 0;
			if (vetor.size() > 0) {

				String palavra = null;

				for (int i = 0; i < vetor.size(); i++) {

					palavra = vetor.get(i);

					id2 = idDisciplina(palavra);
					query2 = "INSERT INTO bdsoftwareacademico2_0.curso_disciplina(idCurso, idDisciplina) values (" + id1
							+ ", " + id2 + ");";

					// JOptionPane.showMessageDialog(null, String.valueOf(id1) + " " +String.valueOf(id2));
					this.statement.executeUpdate(query2);
				}
			}
			JOptionPane.showMessageDialog(null, "<html>Curso Cadastrado com sucesso! <br> <br> " + curso.getNomeCurso() + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int deletarCurso(String nomeDCurso) { // ________________________ Deletar Curso ________________________
		try {
			int id1 = idCurso(nomeDCurso);
			String query1 = "DELETE FROM bdsoftwareacademico2_0.curso_disciplina WHERE idCurso = " + id1; 
			
			this.statement.executeUpdate(query1);
			
			String query2 = "DELETE FROM bdsoftwareacademico2_0.curso where nomeDoCurso = \"" + nomeDCurso + "\";";
			
			this.statement.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "<html>Curso Excluido com sucesso! <br> <br>" + nomeDCurso + "</html>");
			//JOptionPane.showMessageDialog(null, "<html>Produto Exluido com sucesso! <br> " + codigoProduto + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int AlterarCurso(DadosDoCurso curso) {  // ___________________________ Alterar Curso ___________________________
		
		int id1 = idCurso(curso.getNomeCurso());
		//JOptionPane.showMessageDialog(null, String.valueOf(id1) +  "   ");
		
		try {
			String query = "UPDATE bdsoftwareacademico2_0.curso set " + "nomeDoCurso = \"" + curso.getNomeCurso() + 
					 "\", tipoDoCurso = \"" + curso.getTipoBac_Lic() + "\", cargaHorariaTotalDoCurso = \"" + 
					 curso.getCargaHorariaTotal() + "\" where idCurso =" + id1 +";";  
			
			this.statement.executeUpdate(query);
			
			String query2 = null;
			ArrayList<String> vetor = new ArrayList<String>();
			vetor = curso.getDisciplinas();
			
			query2 = "DELETE FROM bdsoftwareacademico2_0.curso_disciplina WHERE idCurso = " + id1; 
			
			//JOptionPane.showMessageDialog(null, String.valueOf(id1) +  "   " +String.valueOf(id2));
			this.statement.executeUpdate(query2);

			int id2 = 0;
			if (vetor.size() > 0) {

				String palavra = null;

				for (int i = 0; i < vetor.size(); i++) {

					palavra = vetor.get(i);

					id2 = idDisciplina(palavra);
					query2 = "INSERT INTO bdsoftwareacademico2_0.curso_disciplina(idCurso, idDisciplina) values (" + id1
							+ ", " + id2 + ");";

					this.statement.executeUpdate(query2);
					// JOptionPane.showMessageDialog(null, String.valueOf(id1) + " " +String.valueOf(id2));
				}
			}
			
			JOptionPane.showMessageDialog(null, "<html>Curso Alterado com sucesso! <br> " + curso.getNomeCurso() + "</html>");
			return 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	} //________________________________________________________________________________________________________________________
	
	public int ultimoIdCurso() {  // ___________________________ Ultimo id_Curso Salvo ___________________________
		
		int  ultimoIdDisciplina = 0;
		
		String query = "SELECT idCurso FROM bdsoftwareacademico2_0.curso WHERE idCurso = (SELECT MAX(idCurso) FROM " +
				 "bdsoftwareacademico2_0.curso);"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			ultimoIdDisciplina = this.resultSet.getInt("idCurso");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return ultimoIdDisciplina;
	} //________________________________________________________________________________________________________________________
	
	public int idCurso(String nomeDoCurso) {  // ___________________________ Ultimo id_Disciplina Salvo ___________________________
		
		int  IdCurso = 0;
		
		String query = "SELECT idCurso FROM bdsoftwareacademico2_0.curso WHERE nomeDoCurso = \"" + nomeDoCurso + "\";"; 
		//SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto);
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			IdCurso = this.resultSet.getInt("idCurso");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return IdCurso;
	} //________________________________________________________________________________________________________________________
	
	public int idDisciplina(String codigoDisc) {  // ___________________________ Ultimo id_Disciplina Salvo ___________________________
		
		int  IdDisciplina = 0;
		
		String query = "SELECT idDisciplina FROM bdsoftwareacademico2_0.disciplina WHERE codigoDisciplina = \"" + codigoDisc + "\";"; 
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
	
	public DadosDoCurso CursoSelecionadoNaPesquisa(String text) { //__________________ Disciplina Selecionado na Pesquisa __________________
		
		DadosDoCurso  Curso = new DadosDoCurso(text, "0", "0",  null);
		
		String query = "SELECT * FROM bdsoftwareacademico2_0.curso WHERE nomeDoCurso = \"" + text + "\";"; 
		//"SELECT codigoProduto FROM bdmarketinho.produto WHERE codigoProduto = (SELECT MAX(codigoProduto) FROM bdmarketinho.Produto)";
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			Curso.setNomeCurso(this.resultSet.getString("nomeDoCurso"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			Curso.setTipoBac_Lic(this.resultSet.getString("tipoDoCurso"));
			
			this.resultSet = this.statement.executeQuery(query);
			this.resultSet.next();
			Curso.setCargaHorariaTotal(this.resultSet.getString("cargaHorariaTotalDoCurso"));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return Curso;
	} //________________________________________________________________________________________________________________________

	public DefaultTableModel listaDeCursos(int index, String text) {  // ________________________ lista/ler Disciplinas  ________________________
		
		String query = null;
		DefaultTableModel listaDeCursos = new DefaultTableModel(); 
		Vector<String> nomesDosCursos = new Vector<String>();
		Vector<String> tipoDosCursos = new Vector<String>();
		Vector<String> cargaHorariaDosCursos = new Vector<String>();
		
		if(index == 1) {
			query = "SELECT * FROM bdsoftwareacademico2_0.curso where nomeDoCurso LIKE \"%" + text + "%\";" ;
			
			try {
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					nomesDosCursos.add(this.resultSet.getString("nomeDoCurso"));
				}
				listaDeCursos.addColumn("Nome", nomesDosCursos);
				
				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					if(this.resultSet.getString("tipoDoCurso").equals("1")) { // Licenciatura
						tipoDosCursos.add("Bacharelado");
					}
					else {
						tipoDosCursos.add("Licenciatura");
					}
					
				}
				listaDeCursos.addColumn("Tipo", tipoDosCursos);

				this.resultSet = this.statement.executeQuery(query);
				while(this.resultSet.next()) {
					cargaHorariaDosCursos.add(this.resultSet.getString("cargaHorariaTotalDoCurso"));
				}
				listaDeCursos.addColumn("Carga Horaria Total", cargaHorariaDosCursos);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
			}
		}
		return listaDeCursos;
	} //________________________________________________________________________________________________________________________
	public DefaultListModel listarDisciplinas() {  // ________________________ lista/ler Disciplinas  ________________________
		
		DefaultListModel<String> listaDisciplina = new DefaultListModel<String>();
	
		String query = "SELECT * FROM bdsoftwareacademico2_0.disciplina;";
		
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