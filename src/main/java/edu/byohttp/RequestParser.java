package edu.byohttp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public interface RequestParser {

    Request parseRequest(InputStream input) throws IOException;

}
