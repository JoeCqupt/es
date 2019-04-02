package com.example.resolver;

import com.alibaba.fastjson.JSON;
import com.example.DTO.ResultDTO;
import com.example.constants.ErrorCode;
import com.example.exception.ESCheckedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 处理 spring mvc 处理请求时候抛出的异常
 */

@Component
public class ESCheckedExceptionResolver implements HandlerExceptionResolver {

    private static Logger LOGGER = LoggerFactory.getLogger(ESCheckedExceptionResolver.class);

    private static final String CONTENT_TYPE = "application/json; charset=utf-8";

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ResultDTO resultDTO = null;
        if (ex instanceof ESCheckedException) { // 如果是ESCheckedException
            resultDTO = ResultDTO.fail(((ESCheckedException) ex).getErrorCode());
        } else {
            resultDTO = ResultDTO.fail(ErrorCode.UNKNOWN_ERROR);
        }

        printResult(response, resultDTO);
        return null;
    }

    private void printResult(HttpServletResponse response, ResultDTO resultDTO) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(CONTENT_TYPE);
        try {
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(resultDTO));
            writer.flush();
//            writer.close();
        } catch (IOException e) {
            LOGGER.error("ESCheckedExceptionResolver print JSON error.", e);
        }
    }
}
