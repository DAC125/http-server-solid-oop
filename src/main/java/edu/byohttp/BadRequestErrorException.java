package edu.byohttp;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class BadRequestErrorException extends RuntimeException{
    private String message;
    private Response response;

    public BadRequestErrorException(){
        File errorfile = new File("src/main/resources/400.html");
        int fileLength = (int) errorfile.length();
        this.message = "Error 400: The server could not understand the request due to invalid syntax.\n";
        this.response = new ResponseImp("HTTP/1.1", 501, "Not Implemented", "text/html", fileLength, null, errorfile);
    }

    public String getErrorMessage(){
        return this.message;
    }

    public Response getErrorResponse(){ return this.response; }

}
