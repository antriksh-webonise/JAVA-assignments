package server;
import java.io.*;
import java.net.*;

class RecieveFromClientThread implements Runnable {
    Socket clientSocket=null;
    BufferedReader bufferedReader = null;

    public RecieveFromClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            String messageString;
            while (true) {
                while((messageString = bufferedReader.readLine())!= null){
                    if(messageString.equals("over")) {
                        break;
                    }
                    System.out.println("From Client: " + messageString);
                    System.out.println("Send back to client..");
                }
                this.clientSocket.close();
                System.exit(0);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}