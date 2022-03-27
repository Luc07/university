package so.copySystemCall;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ThreadCopy extends Thread{
	
	public void run() {
		long tempoAntes = System.currentTimeMillis();
		Path[] arrayArq = new Path[10];
		arrayArq[0] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo1.txt").toPath();
		arrayArq[1] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo2.txt").toPath();
		arrayArq[2] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo3.txt").toPath();
		arrayArq[3] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo4.txt").toPath();
		arrayArq[4] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo5.txt").toPath();
		arrayArq[5] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo6.txt").toPath();
		arrayArq[6] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo7.txt").toPath();
		arrayArq[7] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo8.txt").toPath();
		arrayArq[8] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo9.txt").toPath();
		arrayArq[9] = new File("C:\\Users\\lucas\\Desktop\\Pasta1\\Arquivo10.txt").toPath();
		
		Path[] arrayDest = new Path[10];
		arrayDest[0] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo1.txt").toPath();
		arrayDest[1] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo2.txt").toPath();
		arrayDest[2] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo3.txt").toPath();
		arrayDest[3] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo4.txt").toPath();
		arrayDest[4] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo5.txt").toPath();
		arrayDest[5] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo6.txt").toPath();
		arrayDest[6] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo7.txt").toPath();
		arrayDest[7] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo8.txt").toPath();
		arrayDest[8] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo9.txt").toPath();
		arrayDest[9] = new File("C:\\Users\\lucas\\Desktop\\Pasta2\\Arquivo10.txt").toPath();
    	
		for (int i = 0; i < arrayDest.length; i++) {
			try {
				Files.copy(arrayArq[i], arrayDest[i], java.nio.file.StandardCopyOption.REPLACE_EXISTING,java.nio.file.StandardCopyOption.COPY_ATTRIBUTES);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		long tempoDepois = System.currentTimeMillis();
		long tempoTotal = tempoDepois - tempoAntes;
		long tempoMedioThread = tempoTotal / arrayDest.length;
		System.out.println("Tempo total para Thread: " + tempoTotal + "msec");
		System.out.println("Média do tempo necessário para Thread: "+ tempoMedioThread + "msec");
	}
}
