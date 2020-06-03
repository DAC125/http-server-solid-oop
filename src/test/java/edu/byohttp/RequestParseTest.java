package edu.byohttp;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
public class RequestParseTest {

    @Test
    public void testRequestparse() throws IOException {
        RequestParserImpl requestParserImpl = new RequestParserImpl();

        File file = new File("src/main/resources/input.txt");

        InputStream input = new FileInputStream(file);

        Request request = requestParserImpl.parseRequest(input);

        assertEquals("GET",request.getMethod());
        assertEquals("/helloworld.html",request.getResource());
        assertEquals("HTTP/1.1",request.getVersion());
        assertEquals("PostmanRuntime/7.22.0", request.getHeaders().get("User-Agent:"));
        assertEquals("*/*", request.getHeaders().get("Accept:"));
        assertEquals("no-cache", request.getHeaders().get("Cache-Control:"));
        assertEquals("localhost", request.getHeaders().get("Host:"));
        assertEquals("gzip,deflate,br", request.getHeaders().get("Accept-Encoding:"));
        assertEquals("keep-alive", request.getHeaders().get("Connection:"));
    }
}
