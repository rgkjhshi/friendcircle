package com.mk.friendcircle.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 流水号生成工具类
 * <p>
 * 前缀 + 时间 + ip的后四位 + 序号
 * </p>
 * <p>使用举例:</p>
 * <pre>
 * // 无前缀, 生成24位序列号
 * SerialNumberUtils.getSerialNumber();
 * // 使用前缀
 * SerialNumberUtils.getSerialNumber("T");
 * </pre>
 *
 * @author shisong02
 * @since 2018-08-30
 */
public class SerialNumberUtils {

    private static final String IP;
    private static final AtomicInteger RANDOM_INTEGER;
    private static final int MAX_INT = 999999;

    static {
        IP = getIp();
        // [0, 999999)
        RANDOM_INTEGER = new AtomicInteger(new Random().nextInt(MAX_INT));
    }

    /**
     * 24位流水号
     */
    public static String getSerialNumber() {
        return getSerialNumber("");
    }

    /**
     * 前缀 + 24位流水号
     */
    public static String getSerialNumber(String prefix) {
        String timeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String randomString = getRandomString();
        return prefix + timeString + IP.substring(8) + randomString;
    }

    private static String getIp() {
        StringBuilder ipString = new StringBuilder();
        String ip = IpUtils.getLocalIPAddress();
        for (String data : Splitter.on(".").trimResults().split(ip)) {
            ipString.append(Strings.padStart(data, 3, '0'));
        }
        return ipString.toString();
    }

    /**
     * 获取6位随机数 (0, 999999]
     */
    private static String getRandomString() {
        int data = RANDOM_INTEGER.incrementAndGet();
        // data 有可能 > MAX_INT, 不能用compareAndSet
        if (data > MAX_INT) {
            RANDOM_INTEGER.set(0);
            // 这条不能省略, 否则多个并发线程可能得到相同值0
            data = RANDOM_INTEGER.incrementAndGet();
        }
        String randomString = String.valueOf(data);
        // 前面补0, 保证6位
        return Strings.padStart(randomString, 6, '0');
    }
}
