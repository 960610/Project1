package FileTest;

import org.junit.Test;

import java.io.*;

public class bufferedTest {
    @Test
    public void streamBufferedTest() throws IOException {
        BufferedInputStream  bis = null;
        BufferedOutputStream bos = null;
        try{
            File file = new File("K:\\19.AVI");
            File fileout = new File("K:\\19back.AVI");

            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(fileout));

            int len;
            byte[] by = new byte[1024];
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
