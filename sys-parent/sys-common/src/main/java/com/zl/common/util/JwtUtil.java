package com.zl.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

/**
 * @author zhongliang
 */
public class JwtUtil {

    public static  Map<String, Claim>  parse(String token){
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        return  claims;
    }

    public static void verify(String token){
        JWTVerifier build = JWT.require(Algorithm.HMAC256("cjs")).build();
        DecodedJWT verify = build.verify(token);
    }

}
