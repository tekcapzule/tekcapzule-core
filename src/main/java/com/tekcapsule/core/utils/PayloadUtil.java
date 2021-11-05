package com.tekcapsule.core.utils;

import java.util.HashMap;
import java.util.Map;

public class PayloadUtil {

    public static final String ERROR_MESSAGE = "Something went wrong! Please try again later!";
    public static final String ERROR_CODE = "500";
    public static final String SUCCESS_MESSAGE = "Congratulations! Your request has made its way!";
    public static final String SUCCESS_CODE = "200";

    public static Map<String, Object> populatePayload(Map<String, Object> responseHeader, Outcome outcome) {

        Map<String, Object> payload = new HashMap();

        if (outcome == Outcome.SUCCESS) {
            responseHeader.put("code", SUCCESS_CODE);
            responseHeader.put("message", SUCCESS_MESSAGE);
        } else {
            responseHeader.put("code", ERROR_CODE);
            responseHeader.put("message", ERROR_MESSAGE);
        }
        return responseHeader;
    }
}