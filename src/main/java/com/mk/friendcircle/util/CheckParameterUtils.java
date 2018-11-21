package com.mk.friendcircle.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mk.friendcircle.enums.ExceptionEnum;
import com.mk.friendcircle.exception.BusinessException;

/**
 * @author shisong02
 * @since 2018-09-04
 */
public class CheckParameterUtils {
    /**
     * 检查所传字符串均不为空
     *
     * @param args 要检查的字符串
     */
    public static void checkString(String... args) {
        try {
            for (String str : args) {
                Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "所需字符串不能为空");
            }
        } catch (Exception e) {
            throw new BusinessException(ExceptionEnum.INVALID_PARAMETER, e.getMessage());
        }
    }

}
