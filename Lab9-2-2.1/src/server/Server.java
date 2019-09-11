package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(7071);
            System.out.println("Wait connections...");
            while (true) {
                Socket socket = server.accept();
                System.out.println(((Socket) socket).getInetAddress() + " connected");
                ClientObject thread = new ClientObject(socket);
                thread.run();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
