package main.com.httpserver;

import java.io.IOException;
import java.io.InputStream;

public interface Parser {

    Request parse(InputStream input) throws IOException;
}
