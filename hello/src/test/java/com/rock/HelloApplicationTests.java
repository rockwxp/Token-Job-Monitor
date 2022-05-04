package com.rock;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@SpringBootTest(classes = HelloApplication.class)
class HelloApplicationTests {

    @Test
     void accountSubscribe(){
         RestTemplate restTemplate=new RestTemplate();
         String url = "wss://ancient-delicate-butterfly.solana-mainnet.quiknode.pro/993809acc9f1d922b520bef286512591c9128b9e/";
        String dataToSend="{\n" +
                "  \"jsonrpc\": \"2.0\",\n" +
                "  \"id\": 1,\n" +
                "  \"method\": \"accountSubscribe\",\n" +
                "  \"params\": [\n" +
                "    \"CM78CPUeXjn8o3yroDHxUtKsZZgoy4GPkPPXfouKNH12\",\n" +
                "    {\n" +
                "      \"encoding\": \"jsonParsed\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(dataToSend, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());

    }

    @Test
    void socketTest(){

    }

}
