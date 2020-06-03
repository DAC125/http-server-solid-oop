package edu.byohttp;

import java.io.*;
import java.net.*;
import java.util.Date;

public class InternalServerErrorException extends RuntimeException {
    private String message;
    private Response response;

    public InternalServerErrorException (){
        File errorfile = new File("src/main/resources/500.html");
        int fileLength = (int) errorfile.length();
        this.message = "Error 500: The server has encountered a situation it doesn't know how to handle.\n";
        this.response = new ResponseImp("HTTP/1.1", 500, "Internal Server Error", "text/html", fileLength, null, errorfile);
    }

    public String getErrorMessage(){
        return this.message;
    }

    public Response getErrorResponse(){ return this.response; }

}


