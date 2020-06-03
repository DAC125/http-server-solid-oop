package edu.byohttp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResponseImp implements Response{

    private String version;
    private int statusCode;
    private String statusMessage;
    private String contentType;
    private int contentLength;
    private Map<String, String> headers = new HashMap<String, String>();
    private File body;

    public ResponseImp(String version, int statusCode, String statusMessage, String contentType, int contentLength, Map<String, String> headers, File body){

        this.version = version;
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public File getBody() {
        return body;
    }

    @Override
    public int getContentLength() {
        return contentLength;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {

        StringBuilder Headers = new StringBuilder();

        for (String headerKeyIndividualValue: headers.keySet()){

            String headerKey = headerKeyIndividualValue.toString();

            String headerValue = headers.get(headerKey).toString();

            Headers.append(headerKey).append(headerValue).append("\n");
        }

        return version + " " + statusCode + " " + statusMessage + " " + Headers;
    }

}