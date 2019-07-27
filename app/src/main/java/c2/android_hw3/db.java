package c2.android_hw3;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.Proxy.Type.HTTP;


public class db {
    public static String executeQuery(String query_string) {
        String result = "";
        HttpURLConnection conn=null;
        InputStream is =null;
        try {
            URL url=new URL("http://192.168.1.2/android_hw3_php/db.php");//php的位置
            conn=(HttpURLConnection) url.openConnection();//對資料庫打開連結
            conn.setRequestMethod("POST");
            conn.connect();//接通資料庫
            is=conn.getInputStream();//從database 開啟 stream

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = bufReader.readLine()) != null) {
                builder.append(line + "\n");
            }
            is.close();
            result = builder.toString();
        } catch(Exception e) {
            Log.e("log_tag", e.toString());
        }

        return result;
    }
}