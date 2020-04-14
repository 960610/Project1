package Testcode;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.*;

public class ChineseToEnglish {

    //读取excel文件中的数据，并将汉字的首字母提取出来，拼接为insert语句
    //origin push
    //push remote
    public static void main(String[] args) {
        File file = new File("K:\\test1.xls");
        File fout = new File("K:\\test2.txt");
        String str = "INSERT INTO `prod_rai_dsystem`.`td_s_commpara`(`subsys_code`, `param_attr`, `param_code`, `param_name`, `PARA_CODE1`, `para_code2`, `para_code3`, `start_date`, `end_date`, `REMARK`) VALUES ('rai', 9180, 'province_abbreviation', '省分地市对应缩写', '";
        try {
            FileInputStream fis = new FileInputStream(file);
            FileWriter fi = new FileWriter(fout,true);
            try {
                Workbook wb1 = Workbook.getWorkbook(fis);
                int sheet_size = wb1.getNumberOfSheets();
                for (int index = 0; index < sheet_size; index++) {
                    // 每个页签创建一个Sheet对象
                    Sheet sheet = wb1.getSheet(index);
                    // sheet.getRows()返回该页的总行数
                    for (int i = 0; i < sheet.getRows(); i++) {

                        StringBuffer stb = new StringBuffer();
                        stb.append(str);
                        // sheet.getColumns()返回该页的总列数
                        for (int a = 0; a < sheet.getColumns(); a++) {
                            String cellinfo = sheet.getCell(a, i).getContents();
                            if(a == sheet.getColumns()-1){
                                stb.append(cellinfo).append("',now(),'2050-12-31 23:59:59','subsys_code rai param_attr 9180 param_code province_abbreviation param_name 省分地市对应缩写 PARA_CODE1 province_code或者city_code para_code2 省分名称或者地市名称 para_code3 对应省份地市缩写编码');").append("\n");
                            }else{
                                stb.append(cellinfo).append("','");
                            }

                        }
                        fi.write(stb.toString());

                        //System.out.println(stb);
                    }
                }
                System.out.println("成功");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }finally {
                try {
                    fi.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            //String res = getPinYinHeadChar(src);

            //System.out.println(res);

            System.out.println("filsh");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getPinYinHeadChar(String src){
        String convert = "";
        for (int i = 0; i < src.length(); i++) {
            char word = src.charAt(i);
            String[] pinyinarr = PinyinHelper.toHanyuPinyinStringArray(word);
            if(pinyinarr != null){
                convert += pinyinarr[0].charAt(0);
            }else{
                convert += word;
            }
        }
        return convert;
    }
}
