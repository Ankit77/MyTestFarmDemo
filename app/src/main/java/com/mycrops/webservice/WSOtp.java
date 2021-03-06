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

    public String executeWebservice(String mobile, String request_type, String otp) {
        final String url = Constants.BASE_URL + "/" + Constants.MODULE + "/" + Constants.OTP_VERIFICATION;

        return WSUtils.callServiceHttpPost(url, generateRequest(mobile, request_type, otp));
    }




    private RequestBody generateRequest(String mobile, String request_type, String otp) {
        RequestBody formBody = new FormBody.Builder()
                .add("mobile_no", mobile).add("request_type", request_type).add("otp_code", otp)
                .build();
        return formBody;

    }

}
