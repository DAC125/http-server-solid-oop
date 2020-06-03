package edu.byohttp;

import java.util.HashMap;
import java.util.Map;

public class RequestFactory {
    public static Request getInstance(String method, String version, String resource, Map<String,String> headers) {

        Request request = new RequestImpl(method,version,resource,headers);
        return request;
    }
}
