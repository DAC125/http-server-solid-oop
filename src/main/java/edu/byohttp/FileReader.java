package edu.byohttp;

import java.io.File;
import java.io.IOException;

public interface FileReader {

    byte[] readFileData(File resourceFile, int resourceFileLength) throws IOException;

}
