package projet;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Serveur {

	public static void main(String[] args) {
		try {
			// On écoute le Port <PORT>
			int PORT = 49153;
			ServerSocket ecoute = new ServerSocket(PORT);
			System.out.println("Serveur actif");
			int i = 0;
			
			while(true) {
				// On accepte une demande de connection du client
				Socket client = ecoute.accept();
				i++;
				
				ClientThread ct = new ClientThread(client, i);
				ct.start();
				
				
			}
		} catch(IOException e) {
			System.err.println(e.getMessage()); 
			System.exit(1);
		}
	}
	
}
