package com.yunjia.lark.model.entity;

import lombok.Data;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * @Author myou
 * @Date 2021/3/9  4:12 下午
 */
@Data
public class EncryptorsPassword {
    /**
     * 该类是密码加密抽象类
     * 密码={id}encryptors{salt:password}
     */

    private static String encryptors(String id, String salt, String password) {
        TextEncryptor textEncryptor = Encryptors.text("password", salt);
        String encrypt = textEncryptor.encrypt(password);
        return String.format("{%s}%d", id, encrypt);
    }

    // salt生产器
    private static String keyGenerators() {
        return KeyGenerators.string().generateKey();
    }
}
