package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileInputOutStream {
    @Test
    public void fileInputStream(){

        FileInputStream fis = null;

        try {
            File file = new File("K:\\hello.txt");
            fis = new FileInputStream(file);
            int len;
            byte[] buff = new byte[5];
            while((len = fis.read(buff)) != -1){
                String str = new String(buff,0,len);
                System.out.println( str);
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
