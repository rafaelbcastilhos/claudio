package socket;

import formatter.Serializer;
import generator.GenerateOrder;
import model.Orders;
import utils.DatasetSize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        clientSocket = new Socket("127.0.0.1", 8081);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Orders orders = new GenerateOrder().createOrders(DatasetSize.BIG);
        out.println(new Serializer().json(orders));
        String resp = in.readLine();
        System.out.println(resp);

        in.close();
        out.close();
        clientSocket.close();
    }
}
