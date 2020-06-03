package edu.byohttp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerThreadManager implements ThreadManager{

    private static ServerThreadManager serverThreadManagerObject;
    int portNumber;
    String fileRoot;
    String mimeExtensionsFilePathString;
    Log log = new ConsoleLog();

    private ServerThreadManager(int portNumber, String fileRoot, String mimeExtensionsFilePathString) {
        this.fileRoot = fileRoot;
        this.portNumber = portNumber;
        this.mimeExtensionsFilePathString = mimeExtensionsFilePathString;
    }

    public static ServerThreadManager getInstance(int portNumber, String fileRoot, String mimeExtensionsFilePathString) {

        if (serverThreadManagerObject == null)
            serverThreadManagerObject = new ServerThreadManager(portNumber, fileRoot, mimeExtensionsFilePathString);

        return serverThreadManagerObject;
    }

    @Override
    public void initializeServerSocket() throws InternalServerErrorException {

        try { // try para intentar la coneccion

            // Se inicia la coneccion del Server Socket mediante el puerto
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(portNumber);
                log.logInformation("Server Started.","Listening for connections on port: " + portNumber + " ...\n");

                while (true) {

                    RequestProcessor requestProcessor = new  RequestProcessor(serverSocket.accept(), fileRoot, mimeExtensionsFilePathString);

                    log.logInformation("Connection opened. (" + new Date() + ")");

                    requestProcessor.run();

                }
            } catch (IOException e) {
                log.logError(e);
                throw new InternalServerErrorException();
            }

        } catch (InternalServerErrorException e) { // Excepcion cuando hay un error en la coneccion
            System.err.println(e.getErrorMessage());
        }
    }
}
