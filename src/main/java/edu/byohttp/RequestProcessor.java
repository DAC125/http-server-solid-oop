package edu.byohttp;

import java.io.*;
import java.net.*;
import java.util.Date;

public class RequestProcessor extends Thread {

    private Socket socket;
    private String fileRoot;
    private String mimeExtensionsFilePathString;
    Log log = new ConsoleLog();

    public RequestProcessor(Socket socket, String fileRoot, String mimeExtensionsFilePathString) {

        this.socket = socket;
        this.fileRoot = fileRoot;
        this.mimeExtensionsFilePathString = mimeExtensionsFilePathString;
    }

    private Response process(Request request) throws IOException {

        MethodFactoryCreator methodFactoryCreator = new MethodFactoryCreator();

        Method method = methodFactoryCreator.getMethodFromHashMap(request);
        if(method == null){ throw new NotImplementedErrorException(request); }
        Response response = method.process(request, fileRoot, mimeExtensionsFilePathString);
        writeOutputStream(response);

        log.logResponse(response);

        return response;
    }

    public void run() throws RuntimeException{
        try {
             // Se crea un nuevo Request Parser
            HTTPServerConfig httpServerConfig = new HTTPServerConfig();

            RequestParserImpl requestParserImpl = new RequestParserImpl();

            try {
                Request request = requestParserImpl.parseRequest(socket.getInputStream());     // Se envia el inputStream al Parser

                Response response = process(request);
                log.logRequest(request);


                writeOutputStream(response);

            } catch (IOException e) {
                log.logError(e);
                throw new InternalServerErrorException();
            }
            try{
                socket.close();
            } catch (IOException e) {
                log.logError(e);
                throw new InternalServerErrorException();
            }

        } catch (InternalServerErrorException e) {

            System.err.println(e.getErrorMessage());

            try {
                writeOutputStream(e.getErrorResponse());
            } catch (IOException ex) {
                log.logError(ex);
                ex.printStackTrace();
            }

        } catch (BadRequestErrorException e){
            System.err.println(e.getErrorMessage());

            try {
                writeOutputStream(e.getErrorResponse());
            } catch (IOException ex) {
                log.logError(ex);
                ex.printStackTrace();

            }

        } catch (NotFoundErrorException e){
            System.err.println(e.getErrorMessage());

            try {
                writeOutputStream(e.getErrorResponse());
            } catch (IOException ex) {
                log.logError(ex);
                ex.printStackTrace();

            }

        } catch (NotImplementedErrorException e){
            System.err.println(e.getErrorMessage());
            try {
                writeOutputStream(e.getErrorResponse());
            } catch (IOException ex) {
                log.logError(ex);
                ex.printStackTrace();

            }
        }


    }

    private void writeOutputStream(Response response) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        printWriter.println(response.getVersion() + " " + response.getStatusCode() + " "+response.getStatusMessage());
        printWriter.println("Server: Java HTTP Server de los SOLIDos : 1.0");
        printWriter.println("Date: " + new Date());
        printWriter.println("Content-type: " + response.getContentType());
        printWriter.println("Content-length: " + response.getContentLength());
        printWriter.println(); // linea en blanco entre los header y el contenido
        printWriter.flush(); // Se le hace flush al buffer de outputStream de caracter

        FileReaderImpl fileReaderImpl = new FileReaderImpl();

        byte[] fileData = fileReaderImpl.readFileData(response.getBody(), response.getContentLength());

        bufferedOutputStream.write(fileData, 0, response.getContentLength());
        bufferedOutputStream.flush();

    }
}