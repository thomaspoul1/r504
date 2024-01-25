import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Clienthttp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ClientHttp <hostname>");
            return;
        }

        try {
            // Ouvrir le socket sur le port 80 avec le nom d'hôte passé en argument
            Socket socket = new Socket(args[0], 80);

            // Initialiser les flux de sortie et d'entrée
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isw = new InputStreamReader(socket.getInputStream());

            BufferedWriter bufOut = new BufferedWriter(osw);
            BufferedReader bufIn = new BufferedReader(isw);

            // Envoyer la requête HTTP GET
            String request = "GET / HTTP/1.0\r\n\r\n";
            bufOut.write(request, 0, request.length());
            bufOut.flush();

            // Lire et afficher la réponse ligne par ligne
            String line = bufIn.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            // Fermer les flux et le socket
            bufIn.close();
            bufOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

