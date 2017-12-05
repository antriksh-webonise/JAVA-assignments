package client;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("CLIENT");
            Socket sock = new Socket("localhost",5000);
            SendThread sendThread = new SendThread(sock);
            Thread thread = new Thread(sendThread);
            thread.start();
            RecieveThread recieveThread = new RecieveThread(sock);
            Thread thread1 =new Thread(recieveThread);
            thread1.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}