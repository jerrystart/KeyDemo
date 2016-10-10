package com.app.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-29 21:30
 */
public class HttpUtills {
    static HttpURLConnection httpURLConnection = null;
    static InputStream inputStream;
    static String result;
    static int code = -1;

    public static String postMethod(String url) {
        try {
            URL mUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) mUrl.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine = "";
            while ((inputLine = bufferedReader.readLine()) != null) {
                result += inputLine + "\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return result;
    }

    public static void getMethod() {
    }
}
