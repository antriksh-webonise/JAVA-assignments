package server;
import crud.Operations;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

class SendToClientThread implements Runnable {
    PrintWriter pwPrintWriter;
    Socket clientSock = null;
    private static final String userType = "server";

    public SendToClientThread(Socket clientSock) {
        this.clientSock = clientSock;
    }
    public void run() {
        try {
            Operations operation = new Operations();
            pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));
            while (true) {
                String msgToClientString = null;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Send to client..type over to finish the chat OR DELETE to delete message or EDIT to update the message");
                msgToClientString = input.readLine();
                pwPrintWriter.println(msgToClientString);

                if (msgToClientString.equals("over")) {
                    break;
                }
                if (msgToClientString.equals("DELETE")) {
                    operation.deleteMessages(userType);
                }
                if (msgToClientString.equals("EDIT")){
                    operation.editMessage(userType);
                } else {
                    operation.insertMessages(userType,msgToClientString);
                }
                pwPrintWriter.flush();
                System.out.println(" Send back to client..");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
