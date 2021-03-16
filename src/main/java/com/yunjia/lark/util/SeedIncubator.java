package com.yunjia.lark.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author myou
 * @Date 2021/3/9  10:39 上午
 * 服务端随机数生产器
 */
public class SeedIncubator {
    //    private static AtomicLong atomicLong;
    private static Long currentTimeStamp;

    static {
//        atomicLong = new AtomicLong();
//        currentTimeStamp = System.nanoTime(); //可用于安全实现签发花费时间，但随机种子较小，故切换当前签发时间
        currentTimeStamp = System.currentTimeMillis();
    }

    public static String seedSign() {
        return String.format("%s%d", IpIntTransfer.ipInt, currentTimeStamp);
    }

    public static class IpIntTransfer {

        private static String localHostIp = getLocalHostIp();

        public static int ipInt = ipToInt(localHostIp);

        private static String getLocalHostIp() {
            try {
                localHostIp = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                localHostIp = "0.0.0.0";
            }
            return localHostIp;
        }


        /**
         * IP转INT
         *
         * @param ipv4Addr
         * @return
         */
        public static int ipToInt(String ipv4Addr) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(ipv4Addr);
            int result = 0;
            int counter = 0;
            while (matcher.find()) {
                int value = Integer.parseInt(matcher.group());
                result = (value << 8 * (3 - counter++)) | result;
            }
            return result;
        }

        /**
         * INT转IP
         *
         * @param ip
         * @return
         */
        public static String intToIp(int ip) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            boolean needPoint = false;
            for (int i = 0; i < 4; i++) {
                if (needPoint) {
                    sb.append('.');
                }
                needPoint = true;
                int offset = 8 * (3 - i);
                num = (ip >> offset) & 0xff;
                sb.append(num);
            }
            return sb.toString();
        }

    }
}
