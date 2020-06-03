package edu.byohttp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ResponseFactory {

    public Response getInstanceResponse(String version, int statusCode, String statusMessage, String contentType, int contentLength, Map<String, String> headers, File body){

        Response response = new ResponseImp(version, statusCode, statusMessage,contentType,contentLength,headers,body);

        return response;
    }

}
