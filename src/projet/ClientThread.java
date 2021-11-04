package projet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread {
	
	Socket clt = null;
	int num;

	public ClientThread(Socket client, int num) {
		// TODO Auto-generated constructor stub
		this.clt = client;
		this.num = num;
	}

	public void run() {
		System.out.println("Un thread client vient d'être lancé");
		System.out.println("Thread du client : " + clt);
		
		try {
			InputStream in = clt.getInputStream();
			OutputStream out = clt.getOutputStream();
			
			ObjectInputStream objIn = new ObjectInputStream(in);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			String msgServeur = "Coucou moi c'est le serveur";
			objOut.writeObject(msgServeur);
			
			Object msgClient = (Object)objIn.readObject();
			System.out.println("Message du client : " + msgClient);
			
			while(true) {
				System.out.println("Le Thread " + num + " tourne toujours");
				Thread.sleep(5000);
			}
			
			// clt.close();
		} catch(ClassNotFoundException | IOException | InterruptedException e) {
			System.err.println(e);
		}
		
	}

}
