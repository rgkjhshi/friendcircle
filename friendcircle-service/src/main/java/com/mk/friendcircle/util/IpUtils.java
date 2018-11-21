package com.mk.friendcircle.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * 获取本地ip地址的工具类
 *
 * @author song.shi
 * @since 2018-08-30
 */
public class IpUtils {
    private static final Logger logger = LoggerFactory.getLogger(IpUtils.class);

    private static final String LOCALHOST = "127.0.0.1";
    private static final String ANY_HOST = "0.0.0.0";
    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    private static volatile InetAddress LOCAL_ADDRESS = null;

    /**
     * 获取本机域名, 没有域名会返回 ip
     */
    public static String getLocalHostName() {
        if (null == LOCAL_ADDRESS) {
            LOCAL_ADDRESS = getLocalAddress0();
        }
        return LOCAL_ADDRESS.getHostName();
    }

    /**
     * 返回本机ip
     */
    public static String getLocalIPAddress() {
        if (null == LOCAL_ADDRESS) {
            LOCAL_ADDRESS = getLocalAddress0();
        }
        return LOCAL_ADDRESS.getHostAddress();
    }

    /**
     * 遍历本地网卡，返回第一个合理的IP。(这个方法是从dubbo包中拷出来的)
     *
     * @return 本地网卡IP
     */
    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        try {
            // 极有可能是 127.0.0.1
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                Enumeration<InetAddress> addresses = network.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (isValidAddress(address)) {
                        return address;
                    }
                }
            }
        } catch (IOException e) {
            logger.warn("Failed to retriving ip address, " + e.getMessage(), e);
        }
        logger.error("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }

    private static boolean isValidAddress(InetAddress address) {
        if (address == null || address.isLoopbackAddress()) {
            return false;
        }
        String ip = address.getHostAddress();
        return (ip != null && !ANY_HOST.equals(ip) && !LOCALHOST.equals(ip) && IP_PATTERN.matcher(ip).matches());
    }
}
