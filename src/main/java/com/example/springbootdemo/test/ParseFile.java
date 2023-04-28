package com.example.springbootdemo.test;

import java.io.*;

public class ParseFile {

    public  static void inputStreamReaderReadAndDealWith(String date, String name) {
        BufferedReader bf = null;
        InputStreamReader inputReader = null;

        Integer count = 0;

        try {
                String names = "/Users/pengliu/Downloads/MPJ78100.FSAL0015.20220413.txt";
                inputReader = new InputStreamReader(new FileInputStream(names));

            bf = new BufferedReader(inputReader);
            String temp;
            while ((temp = bf.readLine()) != null) {
                //不处理  空数据/非指定类型
                if ("CC".contains(temp.substring(182, 184))) {
                    count++;
                    String ll= temp.substring(182, 184);
                    System.out.println("CC_type:"+ll+
                            "|"+temp.substring(263, 273)+
                            "|"+temp.substring(291, 312)+
                            "|"+temp.substring(312, 315)+
                            "|"+temp.substring(315, 345)+
                            "|"+temp.substring(345, 346)+
                            "|"+temp.substring(349, 366)+
                            "|"+temp.substring(367, 368)+
                            "|"+temp.substring(369, 386)+
                            "|"+temp.substring(387, 396)+
                            "|NUMAUT:"+temp.substring(397, 403));
                }else {
                    String ll= temp.substring(182, 184);
                    System.out.println("type:"+ll);
                }
            }

        } catch (IOException e) {

         System.out.println(e);
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        inputStreamReaderReadAndDealWith("", "");
    }
}
