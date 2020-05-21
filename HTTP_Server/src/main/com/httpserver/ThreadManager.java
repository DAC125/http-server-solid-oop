package main.com.httpserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ThreadManager implements GlobalVariables{

    private boolean status = false;

    public boolean getStatus(){
        return status;
    }

    public ThreadManager () { }

    public void initializeServerSocket(int port) throws IOException {

        try { // try para intentar la coneccion

            // Se inicia la coneccion del Server Socket mediante el puerto
            ServerSocket serverConnect = new ServerSocket(port);
            System.out.println("Server Started.\nListening for connections on port: " + port + "...\n");
            status = true;

            while (true) {

                RequestProcessor myServer = new  RequestProcessor(serverConnect.accept());

                if (verbose) {
                    System.out.println("Connection opened. (" + new Date() + ")");
                }
                Thread thread = new Thread(myServer);
                thread.start();
            }
        } catch (IOException e) { // Excepcion cuando hay un error en la coneccion
            System.err.println("Server Connection error :" + e.getMessage());
        }
    }
}
