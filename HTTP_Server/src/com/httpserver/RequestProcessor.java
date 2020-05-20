package com.httpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestProcessor extends Thread{


    Socket csocket;

    public RequestProcessor(Socket csocket) {

        super("RequestProcessor");
        this.csocket = csocket;
    }
    public void run() {

        try {
            PrintStream pstream = new PrintStream(csocket.getOutputStream());
            for (int i = 100; i >= 0; i--) {
                pstream.println(i + " cantidad de ovejas para dormir");
            }
            pstream.close();
            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
