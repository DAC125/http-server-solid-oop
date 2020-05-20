package com.httpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {

    public static void main(String[] args) throws IOException {


        ThreadManager threadManager = new ThreadManager(8000);
        threadManager.initializeServerSocket(8000);

    }
}