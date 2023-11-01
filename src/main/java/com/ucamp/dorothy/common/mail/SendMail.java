package com.ucamp.dorothy.common.mail;

import java.security.SecureRandom;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.SendEmailHistory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendMail {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public SendEmailHistory sendMail(String email) {
		System.out.println("sendMail access");
		log.info("SendMail.sendMail() Start");
		SendEmailHistory emailInfo = null;
		String subjectTemplate = "이메일 인증 코드 전송";
		String contentTemplate = "이메일 인증 번호는 [?]입니다.";
		
		try {
			String randomCode = generateRandomCode(6);
			
			emailInfo = new SendEmailHistory();
			emailInfo.setEmailAddress(email);
			emailInfo.setVerifyCode(randomCode);
			emailInfo.setSubject(subjectTemplate);
			emailInfo.setContent(contentTemplate.replace("?", randomCode));
			emailInfo.setCreatedUser(email);
			
			ArrayList<String> list = new ArrayList<>();
			list.add(emailInfo.getEmailAddress());
			int listSize = list.size();
			
			SimpleMailMessage simpleMessage = new SimpleMailMessage();
			simpleMessage.setTo((String[]) list.toArray(new String[listSize]));
			simpleMessage.setSubject(emailInfo.getSubject());
			simpleMessage.setText(emailInfo.getContent());
			javaMailSender.send(simpleMessage);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		log.info("SendMail.sendMail() End");
		return emailInfo;
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
