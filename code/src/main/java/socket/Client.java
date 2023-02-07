package socket;

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

        clientSocket = new Socket("ip", 0);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("body");
        String resp = in.readLine();

        in.close();
        out.close();
        clientSocket.close();
    }
}
