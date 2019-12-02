package com.hew.springcloudcommon.utils;

import static java.util.Locale.ENGLISH;

/**
 * @author HeXiaoWei
 * @date 2019/12/1 20:47
 */
public class BeanUtils {
    static final String GET_PREFIX = "get";
    static final String SET_PREFIX = "set";

    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
    }
}
