package com.yunjia.lark.util.rsa;

import java.util.Map;

// 打算作为非对称加密策略进行抽象进行
public interface AsymmetryService {

    /**
     * 生产秘钥对(map=>{publicKey:key1,privateKey:key2})
     *
     * @return
     */
    static Map<String, String> createKeys(int keySize) {
        return null;
    }


}
