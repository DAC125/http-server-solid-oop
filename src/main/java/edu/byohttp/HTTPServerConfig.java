package edu.byohttp;

import java.util.HashMap;

public class HTTPServerConfig {

    public ServerThreadManager threadManagerCreator(int portNumber, String fileRoot, String mimeExtensionsFilePathString){

        ServerThreadManager serverThreadManager;
        serverThreadManager = ServerThreadManager.getInstance(portNumber, fileRoot, mimeExtensionsFilePathString);

        return serverThreadManager;
    }

}
