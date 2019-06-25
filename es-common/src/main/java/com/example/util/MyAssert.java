package com.example.util;

import com.example.constants.ErrorCode;
import com.example.exception.ESCheckedException;
import org.apache.commons.lang.StringUtils;

public class MyAssert {

    public static void notNull(Object o){
        if(o == null){
            throw new ESCheckedException(ErrorCode.PARAM_ERROR);
        }
    }

    public static void notBlank(String str){
        if(StringUtils.isBlank(str)){
            throw new ESCheckedException(ErrorCode.PARAM_ERROR);
        }
    }
}
