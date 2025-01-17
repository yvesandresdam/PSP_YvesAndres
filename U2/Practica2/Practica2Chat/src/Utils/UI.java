package Utils;

public class UI {

    // UI MESSAGES
    private final static String WELCOME_MESSAGE = "Bienvenido al DAM CHAT";
    private final static String CONNECTION_ON = "Conexion con el servidor aceptada";
    private final static String INSTRUCTIONS = "Instrucciones de linea de comandos:";
    private final static String INSTRUCTIONS2 = "'@C1:' comunica con el cliente numero 1";
    private final static String INSTRUCTIONS3 = "'@ALL:' comunica con todos los clientes";
    private final static String INSTRUCTIONS4 = "'exit' cierra la conexion con el servidor";
    private final static String USER_DISCONNECTED = "El cliente se ha desconectado";
    private final static String SERVER_DISCONNECTED = "Cerrando el proceso del servidor";

    // UI CONSOLE
    private final static String LINE_BLANK = "";
    private final static String LINE_SEPARATOR = "-----************-----";

    // UI FUNCTIONS
    public static void connectionServer(){
        System.out.println(CONNECTION_ON);
    }
    public static void welcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }
    public static void instructionsMessage(){
        System.out.println(INSTRUCTIONS);
        System.out.println(INSTRUCTIONS2);
        System.out.println(INSTRUCTIONS3);
        System.out.println(INSTRUCTIONS4);
    }
    public static void connectedUser(int userID){
        System.out.printf("Cliente %d conectado%n",userID);
    }
    public static void userDisconnected(){
        System.out.println(USER_DISCONNECTED);
    }
    public static void serverDisconnected(){
        System.out.println(SERVER_DISCONNECTED);
    }
    public static void printSeparatorLine(){
        System.out.println(LINE_SEPARATOR);
    }
    public static void printEmptyLine(){
        System.out.println(LINE_BLANK);
    }
}
