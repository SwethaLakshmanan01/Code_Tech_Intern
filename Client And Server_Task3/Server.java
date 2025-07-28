import java.io.*;
import java.net.*;
import java.util.*;

// Main server class
public class Server {

    // Set to store all connected clients
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        final int PORT = 1234;

        System.out.println("Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            // Run indefinitely to accept new clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandlers.add(clientHandler);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    // Broadcast a message to all connected clients except sender
    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Remove a disconnected client
    public static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        System.out.println("A client has disconnected.");
    }
}

// Class to handle individual clients
class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error setting up client I/O.");
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    @Override
    public void run() {
        try {
            output.println("Connected to Chat Server!");
            String message;

            while ((message = input.readLine()) != null) {
                System.out.println("📩 Received: " + message);
                Server.broadcastMessage(message, this);
            }

        } catch (IOException e) {
            System.out.println("Client connection lost.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Server.removeClient(this);
        }
    }
}

