package main.com.httpserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.StringTokenizer;

public class RequestProcessor extends Thread{

    private Socket connect;

    public RequestProcessor(Socket connect){

        this.connect = connect;
    }

}
