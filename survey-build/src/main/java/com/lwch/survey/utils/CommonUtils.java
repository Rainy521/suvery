package com.lwch.survey.utils;

import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);
    
    public static String getIPS() {
        Enumeration<NetworkInterface> b;
        try {
            b = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            String random = "random-" + System.currentTimeMillis() + "-" + RandomStringUtils.randomAlphanumeric(8);
            LOGGER.error("Fail to get IPs. Use string [ " + random + " ] as IP.", e);
            return random;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (b.hasMoreElements()) {
            for (InterfaceAddress f : b.nextElement().getInterfaceAddresses())
                if (!f.getAddress().isLoopbackAddress() && f.getAddress() instanceof Inet4Address){
                    stringBuilder.append(f.getAddress().getHostAddress());
                    stringBuilder.append(";");
                }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
    
    public static boolean arrayEquals(String[] array1, String[] array2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(array1));
        Set<String> set2 = new HashSet<>(Arrays.asList(array2));
        
        return set1.size() == set2.size() && set1.containsAll(set2);
    }
}
