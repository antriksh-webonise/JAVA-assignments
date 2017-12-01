package server;
import java.io.*;
import java.net.*;
import java.lang.*;
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("SERVER");
            System.out.println("Waiting for connection on port ");
            ServerSocket socket = new ServerSocket(5000);
            Socket clientSocket = socket.accept();
            System.out.println("Connected with " + clientSocket.getInetAddress() + " on port " + "5000");
            RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket);
            Thread thread = new Thread(recieve);
            thread.start();
            SendToClientThread send = new SendToClientThread(clientSocket);
            Thread thread1 = new Thread(send);
            thread1.start();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}