package com.mycrops.webservice;

import org.json.JSONException;
import org.json.JSONObject;

public class WSConstants {

    public static final int CONNECTION_TIMEOUT = 30; // 30 SEC
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_FAIL = 0;
    //    public static final int STATUS_LOGOUT = 101;
//    public static final int STATUS_SUSPENDED = 102;
    public static final int STATUS_NETWORK_ERROR = 201;

    public static String getNetworkError() {

        try {
            final JSONObject object = new JSONObject();
            object.put("status", STATUS_FAIL);
            object.put("code", STATUS_NETWORK_ERROR);
            object.put("message", "Network error, Please try after some time.");
            return object.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
