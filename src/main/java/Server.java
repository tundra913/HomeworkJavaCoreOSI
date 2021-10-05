import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server startup");
        int port = 8089;
        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientS0cket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientS0cket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientS0cket.getInputStream()));

            System.out.printf("New connection accepted, Port: %d\n", clientS0cket.getPort());

            final String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, clientS0cket.getPort()));
            serverSocket.close();
        }
    }
}