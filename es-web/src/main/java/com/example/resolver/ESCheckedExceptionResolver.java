package com.example.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.DTO.ResultDTO;
import com.example.constants.ErrorCode;
import com.example.exception.ESCheckedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理 spring mvc 处理请求时候抛出的异常
 */

@Component
public class ESCheckedExceptionResolver implements HandlerExceptionResolver, PriorityOrdered {

    private static Logger LOGGER = LoggerFactory.getLogger(ESCheckedExceptionResolver.class);


    @Autowired
    private FastJsonHttpMessageConverter messageConverter;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ResultDTO resultDTO = null;
        if (ex instanceof ESCheckedException) { // 如果是ESCheckedException
            resultDTO = ResultDTO.fail(((ESCheckedException) ex).getErrorCode());
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
            BindingResult result = manve.getBindingResult();
            if (result.hasErrors()) {
                FieldError error = result.getFieldError();// 获取第一个错误
                String errorMsg = error.getField() + error.getDefaultMessage();
                resultDTO = ResultDTO.fail(ErrorCode.PARAM_ERROR, errorMsg);
            } else {
                resultDTO = ResultDTO.fail(ErrorCode.PARAM_ERROR);
            }
        } else {
            resultDTO = ResultDTO.fail(ErrorCode.UNKNOWN_ERROR);
        }


        printResult(response, resultDTO);
        return new ModelAndView();
    }

    private void printResult(HttpServletResponse response, ResultDTO resultDTO) {
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        try {
            messageConverter.write(resultDTO, MediaType.APPLICATION_JSON, outputMessage);
        } catch (Exception e) {
            LOGGER.error("ESCheckedExceptionResolver print JSON error.", e);
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE; //定义顺序最高级别
    }
}
