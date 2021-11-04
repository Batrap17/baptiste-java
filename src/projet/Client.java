package projet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		
		Socket s = null;
		String serverHost = "localhost";
		int PORT = 49153;
		
		try {
			System.out.println("Coucou moi c'est le client");
			
			s = new Socket(serverHost, PORT); // Création du socket
			// Récupération des entrées et sorties

			
			OutputStream out = s.getOutputStream();
			InputStream in = s.getInputStream();
			
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			Object msgServeur = (Object)objIn.readObject();
			System.out.println("Message du serveur : " + msgServeur);

			String msgClient = "Coucou moi c'est le client";
			objOut.writeObject(msgClient);
			
			s.close();
			} catch(IOException | ClassNotFoundException e) {
			System.err.println(e);
		}
		
	}

}
