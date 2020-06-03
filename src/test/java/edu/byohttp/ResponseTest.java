package edu.byohttp;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResponseTest {
    @Test
    public void testRequest() throws IOException {

        HashMap<String, String> headers =new HashMap<String,String>();
        headers.put("Server:", "byohttp/0.0.1");
        headers.put("Date:","Tue, 10 Mar 2020 01:57:21 GMT");
        headers.put("Content-Type:","text/html");
        headers.put("Content-Length:","95");
        headers.put("Last-Modified:","Tue, 10 Mar 2020 01:57:00 GMT");
        headers.put("Connection:","keep-alive");
        headers.put("Accept-Ranges:","bytes");

        //Response response = new ResponseImp("HTTP/1.1", 200, "OK", headers);

        //System.out.println(response.toString());

    }
}
