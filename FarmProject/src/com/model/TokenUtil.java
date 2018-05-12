package com.model;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenUtil {

	public static String parseJwt(Key key,String allType){
		try {

		    Jws<Claims> parser = Jwts.parser().setSigningKey(key).parseClaimsJws(allType);
		    Claims claimBody =parser.getBody();
		    		
		    parser.getBody().get(Claims.ISSUER);
//		    Claims.EXPIRATION
//		    Claims.key
//		    Claims.AUDIENCE
//		    Claims.ID
//		    Claims.ISSUED_AT
//		    Claims.ISSUER
//		    Claims.SUBJECT
		    System.out.println("--------------------");
		    System.out.println(parser.getHeader());
		    System.out.println(claimBody.get(Claims.ISSUER));
		    System.out.println(claimBody.get(Claims.ISSUED_AT));
		    System.out.println(claimBody.get(Claims.AUDIENCE));
		    System.out.println(claimBody.get(Claims.EXPIRATION));
		    System.out.println(claimBody.get(Claims.ID));
		    System.out.println(claimBody.get(Claims.SUBJECT));
		    System.out.println(claimBody.get(Claims.ID));
		    System.out.println(parser.getSignature());
		    System.out.println("--------------------");
		    //OK, we can trust this JWT

		} catch (SignatureException e) {
			e.printStackTrace();
		    //don't trust the JWT!
		}
		
		return "";
	}
}
