package socket;

import formatter.Deserializer;
import model.Orders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = in.readLine();
            Orders orders = new Deserializer().json(request);
            System.out.println(orders.getOrders().get(0).getDestinator().getName());
            out.println(orders.getOrders().get(0).getDestinator().getName());
            in.close();
            out.close();
            clientSocket.close();

            if (orders == null) break;
        }
        serverSocket.close();
    }
}
