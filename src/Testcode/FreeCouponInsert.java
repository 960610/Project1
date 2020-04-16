package Testcode;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;

public class FreeCouponInsert {
    public static void main(String[] args) throws Exception{
        File file = new File("K:\\免费权益资源表.xls");
        File fileout = new File("K:\\freeInsert.txt");
        String str = "INSERT INTO `td_cc_coupon_uptodate`(`merchant_name`, `coupon_name`, `consum_way`, `expiry_date`, `seq_id`, `is_price`, `create_time`) VALUES ('";

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
                                stb.append(cellinfo).append("','免费',now());").append("\n");
                            }else{
                                stb.append(cellinfo).append("','");
                            }

                        }
                        fi.write(stb.toString());
                        //System.out.println(stb);
                    }
                    System.out.println("成功");
                }
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
