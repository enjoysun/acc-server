package com.yunjia.lark.util;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.concurrent.TimeUnit;

/**
 * @Author myou
 * @Date 2021/3/9  4:12 下午
 */
public class EncryptorsKey {
    /**
     * 该类是密码加密类
     * 密码={id}encryptors{salt:password}
     */
    private static final String RSA = "RSA";

    public static String encryptors(String id, String salt, String password) {
        TextEncryptor textEncryptor = Encryptors.text("password", salt);
        String encrypt = textEncryptor.encrypt(password);
        return String.format("{%s}%d", id, encrypt);
    }

    public static String hashString(String string){
        return DigestUtils.md5Hex(string);
    }

    // salt生产器
    public static String keyGenerators() {
        return KeyGenerators.string().generateKey();
    }

    public static String rsaKey(String rsaCode) {
        return String.format("%s-%s-%s", "acc", "rsa", rsaCode);
    }

    public static String interceptRsaKey(String ip) {
        return String.format("%s-%s-%s", "acc", "intercept", ip);
    }
}
