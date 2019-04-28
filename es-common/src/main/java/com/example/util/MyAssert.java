package com.example.util;

import com.example.constants.ErrorCode;
import com.example.exception.ESCheckedException;

public class MyAssert {

    public static void notNull(Object o){
        if(o == null){
            throw new ESCheckedException(ErrorCode.PARAM_ERROR);
        }
    }
}
