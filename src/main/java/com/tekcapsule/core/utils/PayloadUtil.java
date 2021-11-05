package com.tekcapsule.core.utils;

import java.util.HashMap;
import java.util.Map;

public class PayloadUtil {

    public static final String ERROR_MESSAGE = "Something went wrong! Please try again later!";
    public static final String ERROR_CODE = "500";
    public static final String SUCCESS_MESSAGE = "Congratulations! Your request has made its way!";
    public static final String SUCCESS_CODE = "200";

    public static Map<String, Object> composePayload(Outcome outcome) {

        Map<String, Object> payload = new HashMap();

        if (outcome == Outcome.SUCCESS) {
            payload.put("code", SUCCESS_CODE);
            payload.put("message", SUCCESS_MESSAGE);
        } else {
            payload.put("code", ERROR_CODE);
            payload.put("message", ERROR_MESSAGE);
        }
        return payload;
    }
}