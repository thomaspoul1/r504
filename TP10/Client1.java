import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

public class Client1 {
    public static void main(String[] args) {
        // Q1.2 - Vérifier le nombre d'arguments
        if (args.length == 0) {
            System.err.println("Erreur : Veuillez spécifier au moins 1 argument.");
            System.exit(1);
        }

        // Q1.3 - Création du client et de la requête HTTP "GET"
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            String url = "http://" + args[0];
            HttpGet request = new HttpGet(url);

            // Example: Execute the request and handle the response if needed
            CloseableHttpResponse response = client.execute(request);
            try {
                HttpEntity entity = response.getEntity();
                // Your code to process the entity (response content) goes here
            } finally {
                response.close();
            }

            // Close the client at the end of the program
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example: Print a message to indicate the end of the program
        System.out.println("Program execution completed successfully.");
    }
}
