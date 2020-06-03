package edu.byohttp;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class NotFoundErrorException extends RuntimeException{

    private String message;
    private Response response;

    public NotFoundErrorException(Request request){
        File errorfile = new File("src/main/resources/404.html");
        int fileLength = (int) errorfile.length();
        this.message = "Error 404: The client does not have access rights to the content; that is, it is unauthorized, so the server is refusing to give the requested resource.\n";
        this.response = new ResponseImp("HTTP/1.1", 404, "Not Found", "text/html", fileLength, request.getHeaders(), errorfile);
    }

    public String getErrorMessage(){
        return this.message;
    }

    public Response getErrorResponse(){ return this.response; }

}
