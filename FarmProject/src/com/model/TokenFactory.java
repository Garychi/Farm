package com.model;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class TokenFactory {
	
	TokenBean tokenBean = new TokenBean();
	private static final Key key = MacProvider.generateKey();
	private static final SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS512;
	private static final byte[] apiKeySecretBytes = key.getEncoded(); 
	private static final Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	public static void main(String args[]){
		TokenFactory factory = new TokenFactory();
		factory.generateToken("id", "Issuer", "subject", 360000);
	}
	
	public String refreshToken(String id,String issuer,String subject,long plusTime){
		return generateToken(id, issuer, subject, plusTime);
	}
	
	public String generateToken(String id,String issuer,String subject,long plusTime){			
		String token = Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer(issuer)
				.setAudience(id)
				.setExpiration(new Date(System.currentTimeMillis() +plusTime))
				.setIssuedAt(new Date())
				.setNotBefore(new Date())
				.signWith(signatureAlgorithm, signingKey)
				.compact();
		
		this.tokenBean.setToken(token);
		
		TokenUtil.parseJwt(signingKey, token);
		
		return token;
	}
}
