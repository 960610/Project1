package FileTest;

import java.io.*;

public class insertAccount_Check {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        BufferedWriter fw = null;
        BufferedReader fr = null;
        try {
            String temp=null;
            File filein = new File("K:\\check.txt");
            File fileout = new File("K:\\hello1.txt");
            fw = new BufferedWriter(new FileWriter(fileout,true));
            fr = new BufferedReader(new FileReader(filein));
            int len;
            while((temp = fr.readLine()) != null){
                String str = StringToarray(temp);
                //System.out.println(str);
                fw.write(str + "\n");

            }
            System.out.println("成功");
            System.out.println("所用时间：" + (System.currentTimeMillis()-time));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fr!= null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!= null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String StringToarray(String temp){
        String[] str = temp.split(",");
        String pat = "INSERT INTO `tr_account_check_qs`( `BILL_DATE`, `ORDER_ID`, `BUSI_ID`, `ORDER_TYPE`, `PAY_method`, `OUT_ORDER_ID`, `TOTAL_FEE`, `REAL_FEE`, `COUPON_FEE`, `OLD_ORDER_NO`, `PROVINCE`, `CITY`, `DISTRICT`, `CHANNEL_ID`, `CREATE_OPER_ID`, `TRADE_TIME`, `MERCHANT_ID`, `USER_ACCOUNT`, `USER_MOBILE`, `PAY_AGENT`, `PAY_TRANSACTION_ID`, `CREATE_TIME`) VALUES ( '";

        StringBuffer sb = new StringBuffer();
        sb.append(pat);
        for (int i = 0; i < str.length; i++) {
            if(i == str.length-1){
                sb.append(str[i]);
                sb.append("',now());");
            }else{
                sb.append(str[i]);
                sb.append("','");
            }
        }
        String sub = sb.toString();
        return sub;
    }
}
