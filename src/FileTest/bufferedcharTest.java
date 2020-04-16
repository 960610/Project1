package FileTest;

import org.junit.Test;

import java.io.*;

public class bufferedcharTest {

    @Test
    public void BufferedTest() throws IOException {
        BufferedReader bis = null;
        BufferedWriter bos = null;
        try{
            File file = new File("K:\\hello.txt");
            File fileout = new File("K:\\helloback.txt");

            bis = new BufferedReader(new FileReader(file));
            bos = new BufferedWriter(new FileWriter(fileout));

            int len;
            char[] by = new char[1024];
            while((len = bis.read(by)) != -1){
                bos.write(by,0,len);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(bos != null){
                bos.close();
            }
            if(bis != null){
                bis.close();
            }
        }

    }
}
