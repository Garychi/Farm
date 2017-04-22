package com.model;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class TokenFactory {
	
	public String generateToken(String params){
		Key key = MacProvider.generateKey();
	
		String token = Jwts.builder()
				.setId(UUID.randomUUID().toString())
				.setSubject(params)
				.setIssuer(params)
				.setAudience(params)
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.setIssuedAt(new Date())
				.setNotBefore(new Date())
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();	
//		System.out.println(token);
		
//		try {
//
//		    Jws<Claims> parser = Jwts.parser().setSigningKey(key).parseClaimsJws(allType);
//		    System.out.println("--------------------");
//		    System.out.println(parser.getHeader());
//		    System.out.println(parser.getBody());
//		    System.out.println(parser.getSignature());
//
//		    //OK, we can trust this JWT
//
//		} catch (SignatureException e) {
//			e.printStackTrace();
//		    //don't trust the JWT!
//		}
		return token;
	}
}
