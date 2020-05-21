package main.com.httpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer implements GlobalVariables {

    public static void main(String[] args) throws IOException {


        ThreadManager threadManager = new ThreadManager();
        threadManager.initializeServerSocket(port);

    }
}