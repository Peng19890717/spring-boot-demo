package com.example.springbootdemo;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpDownloaderPDF {
    //pdf文件请求地址
    String remoteFileUrl = "";
    //本地存放pdf文件路径
    String localFilePath = "";

    public static  void httpDownloader(String remoteFileUrl, String localFilePath) {
        try {
            URL url = new URL(remoteFileUrl);
            // 5000 自定义连接超时毫秒数
            HttpURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5 * 1000);
            httpURLConnection.connect(); // 连接
            System.out.println("connect URL success!");

            int fileLenght = httpURLConnection.getContentLength();
            System.out.println("file size：" + (fileLenght / 1024.0) + " KB");

            System.out.println("start the download...");
            try (DataInputStream dis = new DataInputStream(
                    httpURLConnection.getInputStream());
                 FileOutputStream fos = new FileOutputStream(localFilePath)) {
                // 根据实际情况自定义 buf 大小
                byte[] buf = new byte[10240];
                for (int readSize; (readSize = dis.read(buf)) > 0;) {
                    fos.write(buf, 0, readSize);
                }
                System.out.println("download is complete!");
            } catch (IOException ex) {
                System.out.println("download is error");
            }

            httpURLConnection.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("URL Does not exist or connection timeout!");
        }
    }



    public static void main(String[] args) {

        Map<String,String> ll = new HashMap<>();
        //ll.put("https://service.ke.o-kash.com/api/user/contract/v1/info?applyId=17775568&app-key=okash-pay" , "17775568");

       // ll.put( "https://service.o-pesa.com/api/user/contract/v1/info?applyId=9949927&app-key=opesa-pay","9949927");
        ll.put( "https://service.o-pesa.com/api/user/contract/v1/info?applyId=9942811&app-key=opesa-pay","9942811");




        for (Map.Entry<String, String> entry : ll.entrySet()) {

            httpDownloader(entry.getKey(), "/Users/pengliu/peng/code/doc/opesa/"+entry.getValue()+".pdf");

        }


    }




}

