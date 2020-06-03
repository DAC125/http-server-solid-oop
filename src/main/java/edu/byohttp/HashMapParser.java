package edu.byohttp;

import java.io.IOException;
import java.util.Map;

public interface HashMapParser {
    Map<String, String> parseMimeExtensions (String mimeExtensionsFilePath) throws IOException;
}
