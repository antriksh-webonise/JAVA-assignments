package client;
import java.io.*;
import java.net.*;

class RecieveThread implements Runnable {
    Socket sock=null;
    BufferedReader recieve=null;

    public RecieveThread(Socket sock) {
        this.sock = sock;
    }
    public void run() {
        try {
            recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
            String msgRecieved = null;
            while((msgRecieved = recieve.readLine())!= null)
            {
                if(msgRecieved.equals("over")) {
                    break;
                }
                System.out.println("From Server: " + msgRecieved);
                System.out.println("Send to server..");
            }
            this.sock.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}