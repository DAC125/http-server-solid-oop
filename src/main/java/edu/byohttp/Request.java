package edu.byohttp;

import java.util.HashMap;
import java.util.Map;

public interface Request {
    public String getMethod();

    public String getVersion();

    public String getResource();

    public Map<String, String> getHeaders();

    public String toString();
}
