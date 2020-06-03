package edu.byohttp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RequestParserImpl implements RequestParser {

    public RequestParserImpl(){

    }

    @Override
    public Request parseRequest(InputStream inputStream) throws IOException {


        BufferedReader bufferedReader = null;
        HTTPServerConfig httpServerConfig = new HTTPServerConfig();




        //Vamos a leer los caracteres del cliente por medio de inputstream en el socket
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // toma primera linea del request del cliente
        String requestLine = bufferedReader.readLine();

        // Se parsea el request con un string tokenizer
        StringTokenizer requestLineParser = new StringTokenizer(requestLine);

        //dispara error si el request tiene una sintaxis invalida
        if (requestLineParser.countTokens() != 3){
            throw new BadRequestErrorException();
        }

        // Se toma el metodo HTTP del cliente  get -> GET
        String method = requestLineParser.nextToken().toUpperCase();

        // Se toma el file solicitado
        String resource = requestLineParser.nextToken().toLowerCase();

        //se toma la version del protocolo HTTP
        String version = requestLineParser.nextToken();

        Map<String, String> headersHashMap = new HashMap<String, String>();

        String header;

        // se parsea los headers 1 a 1 para guardarlos en un mapa hash
        boolean blankLine = false;
        while((header = bufferedReader.readLine()) != null){

            if (header.equals("")){
                return requestFactoryCreator(method, version, resource, headersHashMap);
            }else {
                StringTokenizer headersParser = new StringTokenizer(header);

                String headerKey = headersParser.nextToken();

                String headerValue = "";

                while (headersParser.hasMoreTokens()) {
                    headerValue += headersParser.nextToken();
                }
                headersHashMap.put(headerKey, headerValue);
            }

        }

        return requestFactoryCreator(method, version, resource, headersHashMap);
    }

    private Request requestFactoryCreator(String method, String resource, String version, Map<String, String> headers){
        RequestFactory requestFactory = new RequestFactory();
        return requestFactory.getInstance(method, resource, version, headers);
    }
}
