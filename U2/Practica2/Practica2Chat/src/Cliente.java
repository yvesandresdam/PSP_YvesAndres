import Utils.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static String identificador;
    private static Boolean isConnection = true;

    public static void main(String[] args) {
        UI.welcomeMessage();
        UI.printSeparatorLine();
        try {
            // Conexion con el servidor mediante Socket
            Socket socket = new Socket("localhost", 7557);
            UI.connectionServer();
            // Main Loop que comunica al cliente con el servidor
            clientComunicationDirectional(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void clientComunicationDirectional(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // Mensajes de UI
            identificador = reader.readLine();
            UI.connectedUserID(identificador);
            UI.instructionsMessage();
            UI.printEmptyLine();

            // Herramientas de clase
            Scanner scanner = new Scanner(System.in);

            //

            // HILO 1: Recibe mensajes del servidor
            Thread incomingMessages = new Thread(() -> {
                try {
                    String mensajeRecibido = reader.readLine();
                    while (!socket.isClosed()) {
                        System.out.println(mensajeRecibido);
                        mensajeRecibido = reader.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // HILO 2: Envia mensajes a los clientes
            Thread outgoingMessages = new Thread(() -> {
                String mensajeEnviado = scanner.nextLine();
                while (isConnection) {
                    writer.println(mensajeEnviado);
                    mensajeEnviado = scanner.nextLine();
                    if (mensajeEnviado.equals("exit")) {
                        isConnection = false;
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

            incomingMessages.start();
            outgoingMessages.start();

            incomingMessages.join();
            outgoingMessages.join();

            // Cuando terminan los hilos, se cierra el socket y se desconecta el cliente
            UI.userDisconnected();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
