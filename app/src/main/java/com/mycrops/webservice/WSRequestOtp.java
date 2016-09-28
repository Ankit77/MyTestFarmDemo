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
public class WSRequestOtp {
    private String message = "";
    private int success = 0;

    public WSRequestOtp(Context context) {
    }

    public String getMessage() {
        return message;
    }

    public int getSuccess() {
        return success;
    }

    public String executeWebservice(String mobile, String request_type) {
        final String url = Constants.BASE_URL + "/" + Constants.MODULE + "/" + Constants.OTP_VERIFICATION;
        return WSUtils.callServiceHttpPost(url, generateRequest(mobile, request_type));
    }


    private RequestBody generateRequest(String mobile, String request_type) {
        RequestBody formBody = new FormBody.Builder()
                .add("mobile_no", mobile).add("request_type", request_type)
                .build();
        return formBody;

    }
}
