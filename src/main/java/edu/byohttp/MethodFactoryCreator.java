package edu.byohttp;

import java.util.HashMap;

public class MethodFactoryCreator {

    public Method getMethodFromHashMap(Request request){



        HashMap<String,Method> methodHashMapInstance = new HashMap<String, Method>();
        MethodFactory methodFactory = new MethodFactory();

        //Inyeccion de los metodos existentes dentro del HashMap
        methodHashMapInstance.put("GET",methodFactory.getGetMethod(request));
        methodHashMapInstance.put("HEAD",methodFactory.getHeadMethod(request));





        Method method = methodHashMapInstance.get(request.getMethod());


        return method;

    }
}
