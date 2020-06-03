package edu.byohttp;

import java.io.File;
import java.util.HashMap;

public interface FileBrowser {

    File browseFile(Request request, String fileRoot);

}
