package com.rock.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author Rock
 * @date 4/16/22 4:11 PM
 * @description TODO
 */
public class RestClient {

    static RestTemplate restTemplate=new RestTemplate();
    static String url = "https://api.mainnet-beta.solana.com";
    //static String url = "https://ancient-delicate-butterfly.solana-mainnet.quiknode.pro/993809acc9f1d922b520bef286512591c9128b9e";

    public static void getConfirmedSignaturesForAddress2(){
        String dataToSend="{\"jsonrpc\": \"2.0\",\"id\": 1,\"method\": \"getConfirmedSignaturesForAddress2\",\"params\": [\"E1qnXaxTeKacRsvisH6GnyUjsf8YoDGDjJvvyBFpnmM7\",{\"limit\": 1}]}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(dataToSend, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        JSONArray result = JSON.parseObject(responseEntity.getBody()).getJSONArray("result");
        String signature = result.getJSONObject(0).get("signature").toString();

        System.out.println("signature: "+signature);
    }

    public static void accountSubscribe(){
        String dataToSend="{\"jsonrpc\": \"2.0\",\"id\": 1,\"method\": \"getConfirmedSignaturesForAddress2\",\"params\": [\"E1qnXaxTeKacRsvisH6GnyUjsf8YoDGDjJvvyBFpnmM7\",{\"limit\": 1}]}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(dataToSend, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println(responseEntity.getBody());

    }

    public static void main(String[] args) {
        accountSubscribe();

    }


}

