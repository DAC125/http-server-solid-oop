package edu.byohttp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetMethod implements Method{

    private Map<String, String > mimeExtensions; // Buscar
    private String contentType;
    private int fileLength;

    @Override
    public String getExtension(String resource) {

        String[] resourceSplitExtension = resource.split("\\.");

        String fileExtension = "." + resourceSplitExtension[1];  // html



        return fileExtension;
    }

    @Override
    public Response process(Request request, String fileRoot, String mimeExtensionsFilePathString) throws IOException {


        ResourceFileBrowser resourceFileBrowser = new ResourceFileBrowser();
        File resourceFile = resourceFileBrowser.browseFile(request, fileRoot); // archivo

        fileLength = (int) resourceFile.length(); // largo del contenido

        // Parseo HashMap para mimeExtensions
        HashMapParserImpl hashMapParserImpl = new HashMapParserImpl();
        mimeExtensions = hashMapParserImpl.parseMimeExtensions(mimeExtensionsFilePathString);
        String extension = getExtension(request.getResource());

        contentType = mimeExtensions.get(extension); // Tipo de MIME del recurso

        ResponseFactory responseFactory = new ResponseFactory();


        return responseFactory.getInstanceResponse(request.getVersion(),200, "OK", contentType, fileLength,request.getHeaders(), resourceFile);
    }
}
