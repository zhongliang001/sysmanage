package com.zl.uua.config;

import com.zl.common.util.ObjectUtil;
import com.zl.uua.domain.UserDomain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Map;

/**
 * @author zhongliang
 */
@Configuration
public class ZlJwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserDomain principal = (UserDomain)authentication.getPrincipal();
        principal.getUserDto().setPassword(null);
        Map<String, Object> info = ObjectUtil.objectToMap(principal);
        //设置附加信息
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
