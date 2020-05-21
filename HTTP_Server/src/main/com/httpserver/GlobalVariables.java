package main.com.httpserver;

import java.io.File;

public interface GlobalVariables {

    public static final boolean verbose = true;
    public static final int port = 8008;
    public static final String fileRoot = "src/index.html";
    public static final File webRoot = new File(".");
    public static final String defaultFile = "src/index.html";
    public static final String fileNotFound = "src/404.html";
    public static final String methodNotImplemented = "src/501.html";
}
