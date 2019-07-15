package universidade.modelo.validacao;

import java.awt.Event;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class ValidaÁ„oGeral extends JTextField{

	public ValidaÁ„oGeral(String campo) {
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evento) {
				switch (campo) {
					case "1":{//VALIDA«√O PARA CAMPOS QUE CONT…M CARACTERES ALFAB…TICOS COM ACENTO, TAMB…M CONT…M ESPA«O
						validaCampoTyping(evento);
						break;						
					}					
					case "2": {//VALIDA«√O PARA O CAMPODE MATRÕCULA, SOMENTE N⁄MEROS SEM ESPA«AMENTO
						validaMatriculaTyping(evento);
						break;
					}
					case "3": {//VALIDA«√O PARA O CAMPO DE C”DIGO DE DISCIPLINA, CONT…M CARACTERES MAI⁄SCULOS E N⁄MEROS, SEM ESPA«AMENTO
						validaCodigoTyping(evento);
						break;
					}
					case "4":{//VALIDA«√O PARA O CAMPO DE NOME DA DISCIPLINA COM N⁄MEROS, POIS PODE TER DISCIPLINA 1,2 3
						validaNomeDisciplinaTyping(evento);
						break;
					}
					default:
						break;
				}
			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent evento) {
				if(evento.getModifiers() == Event.CTRL_MASK){
					if(evento.getKeyCode() == KeyEvent.VK_V){
						evento.consume();
					}
				}
			}
		});
	}
	
	private void validaCampoTyping(KeyEvent evento) {
		String permitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz·‡‚„ÈËÍÌÓÔÛÙıˆ˙˘˚ÁÒ¡¿¬√… »ÕŒœ”‘’÷⁄Ÿ€‹«— "; 
		
		if(!permitidos.contains(evento.getKeyChar()+"")) {
			evento.consume(); 			
		}		
	}
	
	private void validaCodigoTyping(KeyEvent evento) {
		String permitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
	
		if(!permitidos.contains(evento.getKeyChar()+"")) {
			evento.consume(); 			
		}
	}
	
	private void validaMatriculaTyping(KeyEvent evento) {
		String permitidos = "0123456789"; 
		
		if(!permitidos.contains(evento.getKeyChar()+"")) {
			evento.consume(); 			
		}
	}
	
	private void validaNomeDisciplinaTyping(KeyEvent evento) {
		String permitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ¡¿¬√… »ÕŒœ”‘’÷⁄Ÿ€‹«— ()/0123456789"; 
		
		if(!permitidos.contains(evento.getKeyChar()+"")) {
			evento.consume(); 			
		}
	}

}
