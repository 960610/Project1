package Testcode;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;

public class province {
    public static void main(String[] args) throws Exception{
        long time = System.currentTimeMillis();
        File file = new File("K:\\province.xls");

        File fileout = new File("K:\\province.txt");
        String str = "INSERT INTO `prod_rai_dparam`.`td_s_commpara`(`subsys_code`, `param_attr`, `param_code`, `param_name`, `PARA_CODE1`, `para_code2`, `para_code3`, `para_code4`, `PARA_CODE5`, `para_code6`, `para_code7`, `para_code8`, `para_code9`, `para_code10`, `para_code11`, `para_code12`, `para_code13`, `para_code14`, `para_code15`, `para_code16`, `para_code17`, `para_code18`, `para_code19`, `para_code20`, `para_code21`, `para_code22`, `para_code23`, `para_code24`, `para_code25`, `para_code26`, `para_code27`, `para_code28`, `para_code29`, `para_code30`, `start_date`, `end_date`, `province_code`, `city_code`, `REMARK`, `update_staff_id`, `update_time`) VALUES ('rai', 9155, 'kafka_grab_data', 'kafka抓取cbss产品资源配置', '1 ', '3', NULL, NULL, '1', NULL, NULL, NULL, NULL, '1000000000267607', '温馨提示：尊敬的5G升级包用户，您专属的2.99元优惠购权益资格等您使用，腾讯、爱奇艺、优酷等多款权益任您挑选，请前往联通手机营业厅APP-服务-5G-优惠购，或点击  https://qy.chinaunicom.cn/5gyixuan 选用。【中国联通】', '90779084', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ";

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
                    for (int i = 0; i < sheet.getRows(); i++) {
                        // sheet.getColumns()返回该页的总列数
                        StringBuffer stb = new StringBuffer();
                        stb.append(str);

                        for (int j = 0; j < sheet.getColumns(); j++) {
                            String cellinfo = sheet.getCell(j, i).getContents();
                            if(j == sheet.getColumns()-1){
                                stb.append("DATE_SUB(NOW(),INTERVAL ");
                                stb.append(i);
                                stb.append(" minute)");
                                stb.append(", '2050-12-31 23:59:59', '");
                                stb.append(cellinfo).append("', NULL, 'PARA_CODE1 序列 para_code2 抓取的数据类型 1 主产品 2 子产品 3 资费 para_code3 抓取的产品ID/资费ID para_code4 抓取的产品/资费名称 para_code5 是否发送短信 0 不发短信 1发短信 para_code6 短信模版编码 para_code7 短信发送模式 0 按天 1按月 3 指定时间 para_code8 时分秒 para_code9 时分秒 para_code10 活动ID,短信表的source para_code11 短信内容，短信表的send_content para_code12 产品ID，二次校验的产品ID start_date 开始时间 end_date 结束时间 province_code 省份编码(全国)', NULL, NULL);").append("\n");
                            }else{
                                stb.append(cellinfo).append("','");
                            }

                        }
                        fi.write(stb.toString());
                        //System.out.println(stb);
                    }
                    System.out.println("成功");
                    System.out.println("所用时间：" + (System.currentTimeMillis()-time) + "毫秒");
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
