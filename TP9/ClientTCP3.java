import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTCP3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ClientTCP3 <message>");
            return;
        }

        try {
            Socket socket = new Socket("localhost", 2016);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(args[0]);

            // Lecture de la chaîne inversée depuis le serveur
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String reversedMessage = dIn.readUTF();
            System.out.println("Message inversé reçu du serveur: " + reversedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

