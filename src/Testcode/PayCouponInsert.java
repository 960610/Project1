package Testcode;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;

public class PayCouponInsert  {
    public static void main(String[] args) throws Exception{
        long time = System.currentTimeMillis();
        File file = new File("K:\\付费权益.xls");
        File fileout = new File("K:\\payInsert.txt");
        String str = "INSERT INTO `td_cc_coupon_uptodate`( `coupon_name`,  `consum_way`, `purchase_price`,  `seq_id`, `is_price`) VALUES ('";

        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            FileWriter fi = new FileWriter(fileout,true);
            try {
                Workbook wb = Workbook.getWorkbook(fis);
                int sheet_size = wb.getNumberOfSheets();
                for (int index = 0; index < sheet_size; index++) {
                    // 每个页签创建一个Sheet对象
                    Sheet sheet = wb.getSheet(index);
                    // sheet.getRows()返回该页的总行数
                    for (int i = 1; i < sheet.getRows(); i++) {
                        // sheet.getColumns()返回该页的总列数
                        StringBuffer stb = new StringBuffer();
                        stb.append(str);

                        for (int j = 0; j < sheet.getColumns(); j++) {
                            String cellinfo = sheet.getCell(j, i).getContents();
                            if(j == sheet.getColumns()-1){
                                stb.append(cellinfo).append("','付费');").append("\n");
                            }else{
                                stb.append(cellinfo).append("','");
                            }

                        }
                        fi.write(stb.toString());

                        //System.out.println(stb);
                    }
                }
                System.out.println("成功");
                System.out.println("所用时间：" + (System.currentTimeMillis()-time) + "毫秒");
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


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
