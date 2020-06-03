package edu.byohttp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashMapParserImpl implements HashMapParser{

    @Override
    public Map<String, String> parseMimeExtensions(String mimeExtensionsFilePath) throws IOException {
        File file = new File(mimeExtensionsFilePath);
        Map<String, String> hashMapMimeExtensions = new HashMap<String, String>();

        InputStream mimeExtensionsFileInputStream = new FileInputStream(file);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mimeExtensionsFileInputStream));

        String mimeExtensionFileLine;
        while((mimeExtensionFileLine = bufferedReader.readLine())!= null) {


            // Se parsea el request con un string tokenizer
            StringTokenizer requestLineParser = new StringTokenizer(mimeExtensionFileLine);

            String mimeExtensionKey = requestLineParser.nextToken();
            String mimeExtensionValue = requestLineParser.nextToken();


            hashMapMimeExtensions.put(mimeExtensionKey, mimeExtensionValue);
        }
        return hashMapMimeExtensions;
    }
}
