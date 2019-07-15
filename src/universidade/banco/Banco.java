package universidade.banco;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Banco {
	private Connection conexao = null;
	private Statement consulta;
	public ResultSet resultado;
	public int result = 0;

	//Conex�es
	public Connection abrir(int op) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/universidade?useTimezone=true&serverTimezone=UTC";
			conexao = DriverManager.getConnection(url, "root", "");
			if (op == 1) {
				JOptionPane.showMessageDialog(null, "Conex�o realizada com sucesso!");
			}
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser realizada!\n" + e.getMessage());
			e.printStackTrace();
		}
		return conexao;
	}

	public Connection fechar(int op) {
		try {
			conexao.close();
			if (op == 1) {
				JOptionPane.showMessageDialog(null, "Conex�o encerrada com sucesso!");
			}
		} catch (HeadlessException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser encerrada!\n" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public boolean testar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sysedu";
			conexao = DriverManager.getConnection(url, "root", "");
			conexao.close();
				JOptionPane.showMessageDialog(null, "Conex�o realizada com Sucesso!\n");
			return true;
		} catch (HeadlessException | ClassNotFoundException | SQLException e) {
	
				JOptionPane.showMessageDialog(null, "Erro: Conex�o n�o pode ser realizada!\n" + e.getMessage());
				e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet executar(String sql) {
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (!resultado.isBeforeFirst()) {
				// JOptionPane.showMessageDialog(null, "Não a registros com o parametro
				// informado!");

				return null;
			}
			// conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
		return resultado;
	}

	public ResultSet executar(String sql, boolean showSqlCode) {
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();

			resultado = consulta.executeQuery(sql);
			if (!resultado.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "N�o a registros com o parametro informado!");

				return null;

			}
			// conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
		return resultado;
	}

	public void executarCustom(String sql) {
		conexao = this.abrir(0);
		try {
			consulta = conexao.createStatement();
			result = consulta.executeUpdate(sql);
			conexao = this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel executar a query SQL!\n" + e.getMessage());
		}
	}

	//Fun��es gerais
	public boolean inserir(String tabela, String campos, String valores) {//sugest�o mudar para booleans
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "INSERT INTO " + tabela + "(" + campos + ") VALUES(" + valores + ");";
			consulta.execute(sql);
			//JOptionPane.showMessageDialog(null, "Inserido com sucesso!"); eu exibo as mensagens de confirma��o de inclus�o no controlador, se n�o se importa j� faz l�, a� n�o precisa tu alterar aqui...
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// 
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel inserir!\n");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void inserir(String tabela, String campos, String valores, boolean showSqlCode) {
		String sql = "INSERT INTO " + tabela + "(" + campos + ") VALUES(" + valores + ");";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		}
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			consulta.execute(sql);
			JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel inserir!\n" + e.getMessage());
		}
	}

	public boolean excluir(String tabela, String chave, String valor) {//sugest�o mudar para boolean
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "DELETE FROM " + tabela + " WHERE(" + chave + " = '" + valor + "');";
			consulta.execute(sql);
			//JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// 
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel excluir!\n" + e.getMessage());
			return false;
		}
		return true;
	}

	public void excluir(String tabela, String chave, String valor, boolean showSqlCode) {
		String sql = "DELETE FROM " + tabela + " WHERE(" + chave + " = '" + valor + "');";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			consulta.execute(sql);
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: N�o foi poss�vel excluir!\n" + e.getMessage());
		}
	}

	public boolean atualizar(String tabela, String chave, String valor, String query) {//sugest�o mudar para boolean
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			String sql = "UPDATE " + tabela + " SET " + query + " WHERE " + chave + " = '" + valor + "';";
			System.out.println(sql);
			consulta.execute(sql);

			//JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Atualiza��o",
	     	//			JOptionPane.INFORMATION_MESSAGE);
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// 
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro: Não foi possivel atualizar!\n" + e.getMessage(),
					"Atualização", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public String consultar(String tabela, String chave, String valorChave, String campo) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " LIKE '%" + valorChave + "%'";
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}

	public String consultar(String sql, String campo) {
		String retorno = "";

		// sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " = '" +
		// valor + "'";
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}

	public String consultar(String tabela, String chave, String valorChave, String campo, boolean showSqlCode) {
		String sql, retorno = "";
		sql = "SELECT " + campo + " FROM " + tabela + " WHERE " + chave + " = '" + valorChave + "'";
		if (showSqlCode) {
			JOptionPane.showMessageDialog(null, sql);
		} /// exibe o codigo sql
		try {
			conexao = this.abrir(0);
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			if (resultado.next()) {
				retorno = (String) resultado.getString(campo);
			}
			consulta.close();
			this.fechar(0);
		} catch (SQLException e) {
			System.out.println("Erro: N�o foi poss�vel consultar!\n" + e.getMessage());
		}
		return retorno;
	}
}
