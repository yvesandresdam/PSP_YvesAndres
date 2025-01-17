import Utils.UI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Servidor {

    // VARIABLES DE CLASE
    private final static int MAX_CLIENTS_CONNECTION = 4;
    private static int currentUser = 0;
    private static PrintWriter writer;
    private static final List<PrintWriter> writersList = new ArrayList<>();

    public static void main(String[] args) {
        UI.welcomeMessage();
        UI.printSeparatorLine();
        try {
            ServerSocket server = new ServerSocket(7557);

            // Creamos un pool de Hilos
            ExecutorService threads = Executors.newFixedThreadPool(MAX_CLIENTS_CONNECTION);

            // Cada conexion aceptada crea un nuevo socket. Cada socket tiene un ID
            {
                threads.execute(() -> {
                    createNewSocketConnection(server, 1);
                });

                threads.execute(() -> {
                    createNewSocketConnection(server, 2);
                });

                threads.execute(() -> {
                    createNewSocketConnection(server, 3);
                });

                threads.execute(() -> {
                    createNewSocketConnection(server, 4);
                });
            }
            // Cierre de tareas para terminar la conexion con el servidor
            threads.shutdown();
            threads.awaitTermination(2000, TimeUnit.SECONDS);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createNewSocketConnection(ServerSocket server, int id) {
        try {
            // Creacion de un socket para un cliente
            Socket socket = server.accept();
            UI.connectedUser(id);
            UI.instructionsMessage();
            UI.printEmptyLine();

            // Objetos 'writer' que escribiran en cada sesion de cliente
            writer = new PrintWriter(socket.getOutputStream(), true);
            writersList.add(writer);

            // Bucle principal del programa de mensajeria
            serverClientComunicable(socket, writer);

            // Fin de creacion de Socket
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Fin de la conexion con el servidor
        System.out.println("Desconexion del servidor");
    }

    private static void serverClientComunicable(Socket socket, PrintWriter writer) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Herramientas de clase
            Scanner scanner = new Scanner(System.in);

            // HILO 1: Recibe mensajes de los clientes y entonces,
            // HILO 1: Direcciona cada uno de estos mensajes a sus destinatarios.
            // HILO 1: Utilizando el objeto 'writer' correspondiente
            // HILO 1: o todos los objetos de la lista para enviar a todos los clientes.
            Thread incomingMessages = new Thread(() -> {
                try {
                    String mensajeRecibido = reader.readLine();
                    while (!mensajeRecibido.equals("exit")) {

                        // Funciones de envio desde el servidor
                        // @C1: envia el mensaje recibido al CLIENTE 1
                        String codeStringWrite = mensajeRecibido;
                        if (mensajeRecibido.length() > 3)
                            codeStringWrite = mensajeRecibido.substring(0, 4);

                        if (codeStringWrite.equals("@ALL")) {
                            for (PrintWriter writerAll : writersList)
                                writerAll.printf("@ALL: %s%n", mensajeRecibido);
                        } else if (codeStringWrite.equals("@C1:")) {
                            writersList.get(0).printf("@C1: %s%n", mensajeRecibido);
                        } else if (codeStringWrite.equals("@C2:")) {
                            writersList.get(1).printf("@C2: %s%n", mensajeRecibido);
                        } else if (codeStringWrite.equals("@C3:")) {
                            writersList.get(2).printf("@C3: %s%n", mensajeRecibido);
                        } else if (codeStringWrite.equals("@C4:")) {
                            writersList.get(3).printf("@C4: %s%n", mensajeRecibido);
                        }
                        System.out.println(mensajeRecibido);
                        mensajeRecibido = reader.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // HILO 2: Envia mensajes escritos UNICAMENTE desde la consola del servidor
            Thread outgoingMessages = new Thread(() -> {

                String mensajeEnviado = scanner.nextLine();

                while (!mensajeEnviado.equals("exit")) {
                    // El mensaje enviado por el servidor puede incluir los siguientes codigos:
                    // '@C1:' Se envia al cliente 1
                    // '@C2:' Se envia al cliente 2
                    // '@C3:' Se envia al cliente 3
                    // '@C4:' Se envia al cliente 4
                    String codeSendingMessage = mensajeEnviado;
                    if (mensajeEnviado.length() > 3)
                        codeSendingMessage = mensajeEnviado.substring(0, 4);

                    if (codeSendingMessage.equals("@C1:")) {
                        writersList.get(0).println(mensajeEnviado);
                    } else if (codeSendingMessage.equals("@C2:")) {
                        writersList.get(1).println(mensajeEnviado);
                    } else if (codeSendingMessage.equals("@C3:")) {
                        writersList.get(2).println(mensajeEnviado);
                    } else if (codeSendingMessage.equals("@C4:")) {
                        writersList.get(3).println(mensajeEnviado);
                    } else {
                        for (PrintWriter writerAll : writersList)
                            writerAll.println(mensajeEnviado);
                    }
                    mensajeEnviado = scanner.nextLine();
                }
            });

            incomingMessages.start();
            outgoingMessages.start();

            incomingMessages.join();
            outgoingMessages.join();

            UI.serverDisconnected();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Funcion estatica que lleva el conteo del numero de clientes conectados
    public static int getUserNumber(){
        currentUser++;
        return currentUser;
    }
}
