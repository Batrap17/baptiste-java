package projet;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
			
			while(true) {
				// On accepte une demande de connection du client
				Socket client = ecoute.accept();
				
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				
				ObjectInputStream objIn = new ObjectInputStream(in);
				ObjectOutputStream objOut = new ObjectOutputStream(out);
				
				String msgServeur = "Coucou moi c'est le serveur";
				objOut.writeObject(msgServeur);
				
				Object msgClient = (Object)objIn.readObject();
				System.out.println("Message du client : " + msgClient);
				
				client.close();
			}
		} catch(IOException | ClassNotFoundException e) {
			System.err.println(e.getMessage()); 
			System.exit(1);
		}
	}
	
}
