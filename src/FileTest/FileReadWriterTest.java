package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWriterTest {

    @Test
    public void testFileRead(){
        FileReader fr = null;
        try {
            File file = new File("K:\\hello.txt");
            fr = new FileReader(file);
            int read ;
            String str = new String();
            while((read = fr.read()) != -1){
                System.out.print( (char)read);
                read = fr.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
