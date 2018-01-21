package server;
import java.io.*;
import java.net.*;

class SendToClientThread implements Runnable {
    PrintWriter pwPrintWriter;
    Socket clientSock = null;

    public SendToClientThread(Socket clientSock) {
        this.clientSock = clientSock;
    }
    public void run() {
        try {
            pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));

            while(true)
            {
                String msgToClientString = null;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                msgToClientString = input.readLine();

                pwPrintWriter.println(msgToClientString);
                pwPrintWriter.flush();
                System.out.println(" Send back to client..");
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

