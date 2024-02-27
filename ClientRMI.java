package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            // Obtention du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1903);

            // Recherche du service distant par son nom dans le registre
            RemoteEcho stub = (RemoteEcho) registry.lookup("EchoService");

            // Appel de la méthode distante
            String response = stub.echo("Hello, RMI!");
            System.out.println("Réponse du serveur : " + response);
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.toString());
            e.printStackTrace();
        }
    }
}
