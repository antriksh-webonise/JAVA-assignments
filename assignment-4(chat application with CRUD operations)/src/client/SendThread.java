package client;
import crud.Operations;

import javax.sql.rowset.serial.SerialArray;
import java.io.*;
import java.net.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SendThread implements Runnable {
    Socket sock=null;
    PrintWriter print=null;
    BufferedReader brinput=null;
    private static final String userType = "clients";

    public SendThread(Socket sock) {
        this.sock = sock;
    }
    public void run() {
        try {
            Operations operation = new Operations();
            if (sock.isConnected()) {
                System.out.println("Client connected to "+sock.getInetAddress() + " on port "+sock.getPort());
                this.print = new PrintWriter(sock.getOutputStream(), true);
                while(true) {
                    System.out.println("Send to server..type over to finish the chat OR DELETE to delete message or EDIT to update the message");
                    brinput = new BufferedReader(new InputStreamReader(System.in));
                    String msgtoServerString=null;
                    msgtoServerString = brinput.readLine();
                    this.print.println(msgtoServerString);

                    if (msgtoServerString.equals("over")) {
                        break;
                    }
                    if (msgtoServerString.equals("DELETE")) {
                        operation.deleteMessages(userType);
                    }
                    if (msgtoServerString.equals("EDIT")) {
                        operation.editMessage(userType);
                    } else {
                        operation.insertMessages(userType,msgtoServerString);
                    }
                    this.print.flush();
                }
                sock.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}