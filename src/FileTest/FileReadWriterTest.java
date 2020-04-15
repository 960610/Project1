package FileTest;

import org.junit.Test;

import java.io.*;

public class FileReadWriterTest {

    @Test
    //单元测试
    public void testFileRead(){
        FileReader fr = null;
        try {
            File file = new File("K:\\hello.txt");
            fr = new FileReader(file);
            int len ;
            char[] cbuf = new char[5];
            while((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len ; i++) {
                    System.out.print(cbuf[i]);
                }
                //方式二
                //String str = new String(cbuf,0,len);
                //System.out.println(str);
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
@Test
    public void testFileWriter() {
        FileWriter fw = null;

        try {
            File file = new File("K:\\hello1.txt");

            fw = new FileWriter(file,true);
            fw.write("i have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


}
}
