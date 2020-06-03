package edu.byohttp;

import java.io.File;
import java.util.HashMap;

public class ResourceFileBrowser implements FileBrowser{


    private String fileRoot;

    @Override
    public File browseFile(Request request, String fileRoot) {

        String resourceFileRoot = fileRoot + request.getResource(); // /src/resources + /index.html

        File resourceFile = new File(resourceFileRoot);

        if(!resourceFile.exists()) throw new NotFoundErrorException(request);

        return resourceFile;

    }


}

