package c2.android_hw3;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by user on 2019/7/25.
 */

public class db {
    public static String executeQuery(String query_string) {
        String result = "";
        HttpURLConnection urlConnection=null;
        InputStream is =null;
        try {
            URL url=new URL("127.0.0.1:3306");
            urlConnection=(HttpURLConnection) url.openConnection();//對資料庫打開連結
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();//接通資料庫
            is=urlConnection.getInputStream();//從database 開啟 stream

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
