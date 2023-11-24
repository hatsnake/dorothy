package com.ucamp.dorothy.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.ucamp.dorothy.domain.Member;
import com.ucamp.dorothy.domain.OAuthAttributes;
import com.ucamp.dorothy.domain.SessionMember;
import com.ucamp.dorothy.mapper.MemberMapper;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberMapper mapper;
	private final HttpSession httpSession;
	
	public CustomOAuth2UserService(MemberMapper mapper, HttpSession httpSession) {
		this.mapper = mapper;
		this.httpSession = httpSession;
	}
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		Member member = null;
		
		try {
			member = saveOrUpdate(attributes);
			httpSession.setAttribute("member", new SessionMember(member));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new DefaultOAuth2User(
				Collections.singleton(new SimpleGrantedAuthority(member.getAuth())),
				attributes.getAttributes(),
				attributes.getNameAttributeKey()
		);
	}
	
	private Member saveOrUpdate(OAuthAttributes attributes) throws Exception {
		Member member;
		System.out.println("attributes : " + attributes.getEmail());
		
		if(mapper.findByEmail(attributes.getEmail()) != null) {
			member = mapper.findByEmail(attributes.getEmail());
		} else {
			member = attributes.toEntity();
			mapper.save(member);
			member = mapper.findByEmail(attributes.getEmail());
		}
		System.out.println("member test : " + member.toString());
		return member;
	}

}
