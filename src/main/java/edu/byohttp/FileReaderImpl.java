package edu.byohttp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderImpl implements FileReader{


    @Override
    public byte[] readFileData(File resourceFile, int resourceFileLength) throws IOException {
        // este metodo crea el outputstream y lo retorna
        FileInputStream fileInputStream = null;
        byte[] fileData = new byte[resourceFileLength];

        try {
            fileInputStream = new FileInputStream(resourceFile);
            fileInputStream.read(fileData);
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
        }
        return fileData;
    }
}
