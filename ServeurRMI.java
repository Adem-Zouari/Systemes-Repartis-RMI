package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Interface définissant le service RMI
interface RemoteEcho extends Remote {
    String echo(String message) throws RemoteException;
}

// Implémentation du service RMI
public class ServeurRMI implements RemoteEcho {

    // Implémentation de la méthode distante
    @Override
    public String echo(String message) throws RemoteException {
        return "Echo: " + message;
    }

    public static void main(String[] args) {
        try {
            ServeurRMI server = new ServeurRMI();

            // Exportation de l'objet distant
            RemoteEcho souche = (RemoteEcho) UnicastRemoteObject.exportObject(server, 0);

            // Obtention du registre RMI
            Registry registry = LocateRegistry.createRegistry(1903);

            // Liaison du stub dans le registre
            registry.rebind("EchoService", souche);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur du serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}

