package com.dixson.sharedparking.http.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    public static final String URL_STR = "";

    public static  String get(String urlStr){
        String result = null;
        try{
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            if(connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                result = new String(StreamTool.readInputStream(inputStream));
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static  String post (String urlStr,String username,String password){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("username",username);
        paramMap.put("password",password);
        return post(urlStr,paramMap);
    }


    public static String post(String urlStr, Map<String,Object> paramMap)
        throws Exception {
        StringBuffer sb=null;
        //拼接参数
        StringBuilder params = new StringBuilder();
        int i = 0;
        for (String key : paramMap.keySet()){
            Object value = paramMap.get(key);
            params.append(key);
            params.append("=");
            params.append(value);
            if (i < paramMap.size() - 1) {
                params.append("&");
            }
            ++i;
        }

        //创建请求地址
        URL url = new URL(urlStr);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

       //设置参数
        httpConn.setDoInput(true);
        httpConn.setDoOutput(true);
        httpConn.setUseCaches(false);
        httpConn.setRequestMethod("POST");
        //设置请求属性
        httpConn.setRequestProperty("Charset","UTF-8");
        //连接，同时httpConn.getOutputStream()能够自动连接
        httpConn.connect();
        //建立输入流
        DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
        dos.writeBytes(params.toString());
        dos.flush();
        dos.close();
        //获取相应状态
        int resultCode = httpConn.getResponseCode();
        sb = new StringBuffer();

        if (HttpURLConnection.HTTP_OK == resultCode){

            //解析服务器返回的数据
            String readLine = new String();
            BufferedReader responseReader = new BufferedReader(
                    new InputStreamReader(httpConn.getInputStream(),"UTF-8"));
            while ( (readLine == responseReader.readLine()) != null){
                sb.append(readLine).append("\n");
            }
            responseReader.close();
            return sb.toString();
        }
        return null;

    }


    public  interface OnHttpResultListener{
        public void onResult(String result);
    }
}
