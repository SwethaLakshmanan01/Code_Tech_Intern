import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        final String SERVER_IP = "localhost"; // or IP address of server
        final int SERVER_PORT = 1234;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {

            System.out.println("Connected to the server!");

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

            // Thread to read messages from server
            Thread receiveThread = new Thread(() -> {
                String response;
                try {
                    while ((response = serverInput.readLine()) != null) {
                        System.out.println(" " + response);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            receiveThread.start();

            // Main thread to send messages
            String message;
            while ((message = consoleInput.readLine()) != null) {
                serverOutput.println(message);
            }

        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
        }
    }
}

