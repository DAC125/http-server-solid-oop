package edu.byohttp;

import java.io.IOException;

public interface Method {

    Response process(Request request, String fileRoot, String mimeExtensionsFilePathString) throws IOException;

    String getExtension(String resource);

}
