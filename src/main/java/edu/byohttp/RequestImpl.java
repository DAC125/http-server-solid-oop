package edu.byohttp;

import java.util.HashMap;
import java.util.Map;

public class RequestImpl implements Request {
    private String method;
    private String version;
    private String resource;
    Map<String, String> headers = new HashMap<String, String>();


    public RequestImpl(String method, String version, String resource, Map<String, String> headers) {
        this.method = method;
        this.version = version;
        this.resource = resource;
        this.headers = headers;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getResource() {
        return resource;
    }

    @Override
    public Map<String, String> getHeaders() { return headers; }

    @Override
    public String toString(){

        String strHeaders = "";

        for (String headerKeyInduviualValue: headers.keySet()){

            String headerKey = headerKeyInduviualValue.toString();

            String headerValue = headers.get(headerKey).toString();

            strHeaders += headerKey+headerValue+"\n";
        }
        return method + " " + version + " " + resource + "\n" + strHeaders;

    }
}


