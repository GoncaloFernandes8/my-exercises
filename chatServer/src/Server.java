import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;

public class Server {

    private static final int PORT = 12345; // Porta do servidor
    private Map<String, ServerWorker> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        System.out.println("Servidor de mensagens a iniciar...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {

                Socket clientSocket = serverSocket.accept();
                ServerWorker worker = new ServerWorker(this, clientSocket);
                new Thread(worker).start();
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }

    public void broadcast(String message) {
        for (ServerWorker client : clients.values()) {
            client.sendMessage("[Servidor Broadcast]: " + message);
        }
    }

    public void addClient(String clientName, ServerWorker worker) {
        clients.put(clientName, worker);
    }

    public void removeClient(String clientName) {
        clients.remove(clientName);
    }

    public ServerWorker getClient(String clientName) {
        return clients.get(clientName);
    }

    public Set<String> getClientNames() {
        return clients.keySet();
    }
}
