package com.ucamp.dorothy.common.sms;

import java.security.SecureRandom;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Slf4j
@Service
public class SendSms {
	@Value("${coolsms.apiKey}")
	private String apiKey;
	
	@Value("${coolsms.apiSecret}")
	private String apiSecret;
	
	public String singleSms(String number) {
		String contentTemplate = "전화번호 인증 번호는 [?]입니다.";
		String randomCode = generateRandomCode(6);
		
		Message coolsms = new Message(apiKey, apiSecret);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", number);
		params.put("from", "01045146106");
		params.put("type", "SMS");
		params.put("text", 	contentTemplate.replace("?", randomCode));
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			log.info(obj.toString());
		} catch (CoolsmsException e) {
			log.info("code : " + e.getCode() + ", message : " + e.getMessage());
		}
		
		return randomCode;
	}
	
    private String generateRandomCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            code.append(characters.charAt(randomIndex));
        }

        return code.toString();
    }
}
