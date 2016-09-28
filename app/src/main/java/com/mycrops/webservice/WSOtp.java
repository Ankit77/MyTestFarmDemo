package com.mycrops.webservice;

import android.content.Context;

import com.mycrops.utils.Constants;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/******************************************************************************
 * *                                                                            *
 * *                                                                            *
 * * Author: Iconflux Technologies                                              *
 * * Created: 9/28/2016                                                      *
 * * Purpose:                                             			          *
 * *                                                                            *
 * * Change Log:                                                                *
 * * ===========                                                                *
 * * Name            Date        Purpose                                        *
 * * Prachi Pandya                                                                           *
 * *                                                                            *
 * *                                                                            *
 *******************************************************************************/
public class WSOtp {
    private String message = "";
    private int success = 0;

    public WSOtp(Context context) {
    }

    public String getMessage() {
        return message;
    }

    public int getSuccess() {
        return success;
    }

    public boolean executeWebservice(String mobile, String request_type, String otp) {
        final String url = Constants.BASE_URL + "/" + Constants.MODULE + "/" + Constants.OTP_VERIFICATION;

        return parseJSONResponse(WSUtils.callServiceHttpPost(url, generateRequest(mobile, request_type, otp)));
    }


    public boolean parseJSONResponse(final String response) {
//        ArrayList<RecipesModel> arrayList = new ArrayList<>();
//        try {
//            if (!TextUtils.isEmpty(response)) {
//
//                JSONObject jsonObject = new JSONObject(response);
//                if (jsonObject.getString("result").equalsIgnoreCase("1")) {
//                    return true;
//                } else {
//                    return false;
//                }
//
//
//            } else {
//                return false;
//            }

//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//
//        }
        return false;
    }

    private RequestBody generateRequest(String mobile, String request_type, String otp) {
//        final FormBody requestBody = new FormBody().;
//        requestBody.add("battery_status", batteryStatus);
//        requestBody.add("connection_type", connectiontype);
//        requestBody.add("device", device);
//        return requestBody.build();
        RequestBody formBody = new FormBody.Builder()
                .add("mobile_no", mobile).add("request_type", request_type).add("otp_code", otp)
                .build();
        return formBody;

    }

}
