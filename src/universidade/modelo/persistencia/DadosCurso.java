package universidade.modelo.persistencia;

import java.io.File;

public class DadosCurso {
	private static String pasta = System.getProperty("user.dir");
	private static String arquivo = "\\Dados\\curso\\curso.txt"; 
	private static File caminho = new File(pasta+arquivo);	

}
