package com.yunjia.lark.config.security.authentication.provider;

import com.yunjia.lark.config.SecurityProperties;
import com.yunjia.lark.config.event.LoginFailEvent;
import com.yunjia.lark.config.security.authentication.code.VerifyService;
import com.yunjia.lark.controller.SysLoginController;
import com.yunjia.lark.model.entity.SysUserDetail;
import com.yunjia.lark.service.impl.SysUserDetailServiceImpl;
import com.yunjia.lark.util.EncryptorsKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author myou
 * @Date 2021/3/19  5:07 下午
 */
public class UserAndCodeAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private SecurityProperties securityProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SysUserDetailServiceImpl sysUserDetail;

    // 验证发布事件(用于发布主体验证不通过事件，阻断验证链)
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String code = req.getHeader("code");
        String name = authentication.getName();
        String passWord = String.valueOf(authentication.getCredentials());
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(name))
            return null;
        boolean verifyCode = VerifyService.getDefaultVerifyServiceInstance().verifyCode(name, code, redisTemplate);
        if (verifyCode) {
            SysUserDetail userDetails = (SysUserDetail) sysUserDetail.loadUserByUsername(name);
            String hashString = EncryptorsKey.hashString(EncryptorsKey.encryptors("MD5", userDetails.getSlat(), passWord));
            if (!StringUtils.equals(hashString, userDetails.getPassword())) {
                publisher.publishEvent(new LoginFailEvent(authentication));
                return null;
            }
            return new UsernamePasswordAuthenticationToken(userDetails, passWord, userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
