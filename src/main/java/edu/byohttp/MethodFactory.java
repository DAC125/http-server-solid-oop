package edu.byohttp;

public class MethodFactory {
    public Method getGetMethod (Request request){
        GetMethod getMethod = new GetMethod();
        return getMethod;
    }



    public Method getHeadMethod (Request request){
        HeadMethod headMethod = new HeadMethod();
        return headMethod;
    }
}
