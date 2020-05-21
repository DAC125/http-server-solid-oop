package main.com.httpserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.StringTokenizer;

public class RequestProcessor extends Thread {

    private Socket connect;

    public RequestProcessor(Socket connect) {

        this.connect = connect;
    }

    public void run() {

        try {
            //RequestParser requestParser = new RequestParser(); // Se crea un nuevo Request Parser
            //requestParser.parse(connect.getInputStream());     // Se envia el inputStream al Parser

            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}