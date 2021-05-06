/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import sun.net.www.http.HttpClient;

/**
 *
 * @author md.jubayer
 */
public class HTTPConnector {
    
    private  HttpsURLConnection getHttpsClient(String url) throws Exception {
 
        
 //
        //SSLContext sc = SSLContext.getInstance("SSL");
      //  sc.init(null, trustAllCerts, new java.security.SecureRandom());
       // HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        // Security section END
        
        HttpsURLConnection client = (HttpsURLConnection) new URL(url).openConnection();
       
        //add request header
        client.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        return client;
    }
    
    
    
    public static void requestForAddressesUsingPostCode(String postcode) throws Exception {
        
        try {
                String access_token="";
                String url = Constant.BASE_URL + "postcode=" + postcode;
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                // optional default is GET
                con.setRequestMethod("GET");
               // con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:27.0) Gecko/20100101 Firefox/27.0.2 Waterfox/27.0");
               // con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.setRequestProperty("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjExNyIsImNvbnN1bWVyTmFtZSI6IkludGVydmlld3MiLCJjb25zdW1lclR5cGUiOiIxIiwibmJmIjoxNjE5Nzc1NTY2LCJleHAiOjE5MzUzMDgzNjYsImlhdCI6MTYxOTc3NTU2Nn0.OIbvEbkNecLDOky7bI_fi1r6yxgLxwcFAvy6hbvKpTY");
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                 response.append(inputLine);
                }
                in.close();
                //print result
                System.out.println(response.toString());



                } catch (Exception e) {
                 System.out.println(e);
               }
    }
    
    
    
}
