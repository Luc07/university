package so.copySystemCall;

import java.io.IOException;

public class CopySystemCall {

	public static void main(String[] args) {
		long mediaSystemCall = 0;
        long tempoAntes;
        long tempoDepois;
        long tempoTotal;
        
		String[] arqArray = new String[] {"C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo1.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo2.txt",
		"C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo3.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo4.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo5.txt",
		"C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo6.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo7.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo8.txt",
		"C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo9.txt", "C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo10.txt"}; // Array de Arquivos
        String localDestino = "C:\\Users\\lucas\\Desktop\\Pasta2"; // Local de destino
        
		tempoAntes = System.currentTimeMillis();
		for (int i = 0; i < arqArray.length; i++) {
			String comandoCopiar = "copy " + arqArray[i] + " " + localDestino; // Um for passando pelo array de arquivos
																				// e o destino
			try {
				// Executa o comando no cmd no ambiente /c e com o comando passado em
				// comandoCopiar
				Runtime.getRuntime().exec(new String[] { "cmd", "/c", comandoCopiar });
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		tempoDepois = System.currentTimeMillis();
		tempoTotal = tempoDepois - tempoAntes;
		mediaSystemCall += tempoTotal / arqArray.length;
		System.out.println("Tempo total da chamada de sistema: "+ tempoTotal + "msec");
		System.out.println("Média do tempo necessário para Chamada de Sistema: "+mediaSystemCall+"msec");

		ThreadCopy t1 = new ThreadCopy();
		t1.start();
	}
}
