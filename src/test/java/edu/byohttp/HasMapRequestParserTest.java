package edu.byohttp;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HasMapRequestParserTest {

    @Test
    public void testparseMimeExtensions() throws IOException{

        HashMapParserImpl hashMapParser = new HashMapParserImpl();
        Map<String, String> hashMapMimeExtensions = hashMapParser.parseMimeExtensions("src/main/resources/MimeTypeFile.txt");
        assertEquals("audio/aac", hashMapMimeExtensions.get(".aac"));
        assertEquals("image/jpeg", hashMapMimeExtensions.get(".jpg"));
        assertEquals("application/xml", hashMapMimeExtensions.get(".xml"));








    }
}
