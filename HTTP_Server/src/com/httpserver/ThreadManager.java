package com.httpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadManager {

    int port;

    String fileRoot;

    public ThreadManager (int port) {

        this.port = port;
    }

    public void initializeServerSocket(int port) throws IOException {

        ServerSocket ssock = new ServerSocket(port);
        System.out.println("Listening");

        while (true) {
            Socket sock = ssock.accept();
            System.out.println("Connected");
            new Thread(new RequestProcessor(sock)).start();
        }

    }

}
