package edu.byohttp;

import java.io.IOException;

public interface Log {
    public void logInformation(String ... args);
    public void logResponse(Response response);
    public void logRequest(Request request);
    public String getDate();
    public void logError(IOException error);
}