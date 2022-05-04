package com.rock.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * @author Rock
 * @date 4/16/22 10:56 PM
 * @description TODO
 */
public class HttpUtils {

    private static final String enpoint="https://api.mainnet-beta.solana.com";
   // private static final String enpoint="https://ancient-delicate-butterfly.solana-mainnet.quiknode.pro/993809acc9f1d922b520bef286512591c9128b9e";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static String postExchange(String requestBody ){

        String dataToSend=requestBody;
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.RETRY_AFTER,"1000");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(dataToSend, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(enpoint, HttpMethod.POST, entity, String.class);
        return responseEntity.getBody();
    }

    public static String postHttpClient(String requestBody){

        String responce = "";
        try {
            URL url = new URL(enpoint);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");

            byte[] out = requestBody.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = http.getOutputStream();
            stream.write(out);
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + " "+http.getRequestMethod());

            if(http.getResponseCode()==200){
                InputStream inputStream = http.getInputStream();
                responce = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            }else {
                responce="error";
            }
            http.disconnect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responce;
    }


}
