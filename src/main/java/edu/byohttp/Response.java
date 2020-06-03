package edu.byohttp;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.io.InputStream;
import java.util.Map;

public interface Response{


    public String getVersion();

    public int getStatusCode();

    public String getStatusMessage();

    public String getContentType();

    public File getBody();

    public int getContentLength();

    public Map<String, String> getHeaders();

}