package com.ly.common.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

    /**
     * 将对象转换为json字符串
     * @param value
     * @return
     * @throws JsonProcessingException
     */
    public static   String ObjToJsonStr(Object value) throws JsonProcessingException {
        return  objectWriter.writeValueAsString(value);
    }
}
