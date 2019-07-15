package universidade.modelo.persistencia;

import java.io.File;

public class DadosTurma {
	
	private static String pasta = System.getProperty("user.dir");
	private static String arquivo = "\\Dados\\turma\\turma.txt"; 
	private static File caminho = new File(pasta+arquivo);	

}
