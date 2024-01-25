import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try {
            ServerSocket socketserver = new ServerSocket(2016);
            System.out.println("Serveur en attente");

            while (true) {
                Socket socket = socketserver.accept();
                System.out.println("Connection d'un client");

                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                String receivedMessage = dIn.readUTF();
                System.out.println("Message reçu: " + receivedMessage);

                // Inversion de la chaîne
                String reversedMessage = new StringBuilder(receivedMessage).reverse().toString();

                // Envoi de la chaîne inversée au client
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                dOut.writeUTF(reversedMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

