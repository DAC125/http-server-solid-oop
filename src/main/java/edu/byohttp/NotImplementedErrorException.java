package edu.byohttp;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class NotImplementedErrorException extends RuntimeException {

    private String message;
    private Response response;

    public NotImplementedErrorException(Request request){
        File errorfile = new File("src/main/resources/501.html");
        int fileLength = (int) errorfile.length();
        this.message = "Error 501: The request method is not supported by the server and cannot be handled.\n";
        this.response = new ResponseImp("HTTP/1.1", 501, "Not Implemented", "text/html", fileLength, request.getHeaders(), errorfile);
    }

    public String getErrorMessage(){
        return this.message;
    }

    public Response getErrorResponse(){ return this.response; }

    }


