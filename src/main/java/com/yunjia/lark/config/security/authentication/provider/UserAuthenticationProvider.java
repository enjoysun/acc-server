package com.yunjia.lark.config.security.authentication.provider;

import com.yunjia.lark.config.event.LoginFailEvent;
import com.yunjia.lark.config.security.authentication.handler.LoginFailureHandler;
import com.yunjia.lark.model.entity.SysUserDetail;
import com.yunjia.lark.service.impl.SysUserDetailServiceImpl;
import com.yunjia.lark.util.EncryptorsKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * @Author myou
 * @Date 2021/3/17  3:53 下午
 * <p>
 * 自定义provider进行特殊定制密码格式验证
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SysUserDetailServiceImpl sysUserDetail;

    // 验证发布事件(用于发布主体验证不通过事件，阻断验证链)
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  获取登录请求上下文(用于验证码等机制验证)
        String userName = authentication.getName();
        String passWord = String.valueOf(authentication.getCredentials());
        if (StringUtils.isEmpty(passWord)) {
            throw new BadCredentialsException("缺少密码凭证");
        }
        SysUserDetail userDetails = (SysUserDetail) sysUserDetail.loadUserByUsername(userName);
        String hashString = EncryptorsKey.hashString(EncryptorsKey.encryptors("MD5", userDetails.getSlat(), passWord));
        if (!StringUtils.equals(hashString, userDetails.getPassword())) {
            publisher.publishEvent(new LoginFailEvent(authentication));
            // 认证采用providers链持续认证，所以此处不能返回null否则会走默认的DaoAuthenticationProvider
            throw new BadCredentialsException("密码验证失败");
//            return null;
        }
        return new UsernamePasswordAuthenticationToken(userDetails, passWord, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
