import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ServerWorker implements Runnable {
    private Server server;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public ServerWorker(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.clientName = "Cliente" + socket.getPort(); // Nome padrão
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            server.addClient(clientName, this);
            sendMessage("Bem-vindo ao FerSapNandes, " + clientName + "! Digite /help para ver os comandos disponíveis.");

            String message;
            while ((message = in.readLine()) != null) {
                handleClientMessage(message);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro com o cliente: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void handleClientMessage(String message) throws IOException, InterruptedException {


        switch (message) {

            case "/changename" -> changeClientNameMethod();

            case "/msg" -> sendDirectMessageToClient();

            case "/list" -> listClients();

            case "/help" -> sendMessage(printCommands());

            case "/quit" -> quitClient();

            default -> sendMessage("Comando não reconhecido. Digite /help para ver os comandos disponíveis.");
        }
    }

    /*
    metodos complementares   |
                             v
     */


    private void quitClient() {
        sendMessage("Saindo do chat...");
        closeConnection();
    }


    private void sendDirectMessageToClient() throws IOException {
        sendMessage("\nDigite o nome do destinatário:");

        String recipientName = in.readLine();

        if (recipientName == null || recipientName.trim().isEmpty()) {
            sendMessage("Nome do destinatário inválido. Por favor, tente novamente.");
            return;
        }

        sendMessage("Digite a mensagem que deseja enviar:");

        String privateMessage = in.readLine();

        if (privateMessage == null || privateMessage.trim().isEmpty()) {
            sendMessage("Mensagem inválida. Por favor, tente novamente.");
            return;
        }

        sendPrivateMessage(privateMessage, recipientName.trim());
    }


    private void changeClientNameMethod() throws IOException {
        sendMessage("\nDigite o novo nome:");

        String newName = in.readLine();

        if (newName == null || newName.trim().isEmpty()) {
            sendMessage("Nome inválido. Por favor, tente novamente.");
            return;
        }

        server.removeClient(clientName);
        clientName = newName.trim();
        server.addClient(clientName, this);

        sendMessage("Nome alterado para: " + clientName);
    }


    private String printCommands() {
        return "\n-------------------------------------------------------------\n" +
               "Comandos disponíveis:\n\n" +
               RED + "/msg" + RESET + " -> Envia mensagem privada 💬\n" +
               RED + "/changename" + RESET + " -> Altera o nome ✏️\n" +
               RED + "/list" + RESET + " -> Lista todos os clientes conectados 📋\n" +
               RED + "/quit" + RESET + " -> Sai do chat ❌\n" +
               "-------------------------------------------------------------";

    }


    private void sendPrivateMessage(String message, String recipient) {
        ServerWorker recipientWorker = server.getClient(recipient);
        if (recipientWorker != null) {
            recipientWorker.sendMessage("[Privado] " + clientName + ": " + message);
        } else {
            sendMessage("Cliente " + recipient + " não encontrado.");
        }
    }


    private void listClients() {
        Set<String> clientNames = server.getClientNames();
        if (clientNames.isEmpty()) {
            sendMessage("Nenhum cliente conectado.");
        } else {
            sendMessage("Clientes conectados: " + String.join(", ", clientNames));
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    private void closeConnection() {
        try {
            if (socket != null) socket.close();
            server.removeClient(clientName);
            System.out.println(clientName + " desconectado.");
        } catch (IOException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
