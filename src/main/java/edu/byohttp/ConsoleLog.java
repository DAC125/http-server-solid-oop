package edu.byohttp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLog implements Log{

    public static ConsoleLog consoleLogObject;

    public void ConsoleLog() {

    }

    public static ConsoleLog getInstance(){
        if (consoleLogObject == null) consoleLogObject = new ConsoleLog();
        return consoleLogObject;
    }

    @Override
    public void logResponse(Response response){
        StringBuilder stringBuilder = new StringBuilder();
        String date = getDate();
        System.out.println(date+"\n" + response.toString());
    }

    @Override
    public void logRequest(Request request){
        String date = getDate();
        System.out.println(date+"\n" + request.toString());
    }

    @Override
    public void logError(IOException error){
        String date = getDate();
        System.out.println(date+" "+"Error: "+error.getMessage()+" Cause: "+error.getCause());
    }
    @Override
    public void logInformation(String ... inputStrings) {
        String date = getDate();

        for (String inputString : inputStrings) {
            System.out.print(date + inputString + "\n");
        }
        System.out.println();
    }
    @Override
    public String getDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "[" + dateTimeFormatter.format(now) + "] ";
    }

    //public void logError()

}