package edu.byohttp;

import java.awt.datatransfer.MimeTypeParseException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;

public class HTTPServer{

    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.err.println("Error reading <portNumber> <fileRoot> <MIMETypesFilePath>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        String fileRoot = args[1];
        String mimeExtensionsFilePathString = args[2];
        Log log = new ConsoleLog();

        log.logInformation("puerto: " + Integer.toString(portNumber) , "fileRoot: " + fileRoot , "MimeTypes: " + mimeExtensionsFilePathString);

        HTTPServerConfig httpServerConfig = new HTTPServerConfig(); // Instancia de la configuracion del Servidor por DIP

        ServerThreadManager serverThreadManager = httpServerConfig.threadManagerCreator(portNumber, fileRoot, mimeExtensionsFilePathString);

        serverThreadManager.initializeServerSocket();

    }
}