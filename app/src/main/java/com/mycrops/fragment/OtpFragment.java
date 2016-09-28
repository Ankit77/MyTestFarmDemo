package com.mycrops.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mycrops.R;
import com.mycrops.utils.Constants;
import com.mycrops.utils.Utils;
import com.mycrops.webservice.WSOtp;
import com.mycrops.webservice.WSRequestOtp;

import org.json.JSONObject;

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
public class OtpFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private Button btnSubmit;
    private EditText etOtp;
    private TextView tvResend;
    private TextView tvRemainigTime;
    private TextView tvError;
    private TextView tvOtpLabel;
    private AsyncSendOtp asyncSendOtp;
    private AsyncResendOtp asyncResendOtp;
    private String mobilenumber = "5656565656";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otp, container, false);
    }

    @Override
    public void initActionBar() {

    }

    @Override
    public void initComponent(View view) {
        btnSubmit = (Button) view.findViewById(R.id.fragment_otp_btnSubmit);
        tvRemainigTime = (TextView) view.findViewById(R.id.fragment_otp_tvtime);
        tvResend = (TextView) view.findViewById(R.id.fragment_otp_tvresendcode);
        etOtp = (EditText) view.findViewById(R.id.fragment_otp_etnumber);
        tvError = (TextView) view.findViewById(R.id.fragment_otp_tverror);
        tvOtpLabel = (TextView) view.findViewById(R.id.fragment_otp_tvotplabel);
        btnSubmit.setOnClickListener(this);
        tvResend.setOnClickListener(this);
        etOtp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {

                if (hasFocus) {
                    tvOtpLabel.setVisibility(View.VISIBLE);
                    etOtp.setHint("");
                } else {

                    if (etOtp.getText().toString().length() == 0) {
                        tvOtpLabel.setVisibility(View.INVISIBLE);
                        etOtp.setHint("" + getResources().getString(R.string.otp));
                    }
                    Utils.hideSoftKeyboard(view, getActivity());
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            Utils.hideSoftKeyboard(v, getActivity());
            if (etOtp.getText().toString().length() >= 6) {

                asyncSendOtp = new AsyncSendOtp();
                asyncSendOtp.execute(mobilenumber, "" + Constants.REGISTRATION_OTP_REQUEST, etOtp.getText().toString());

            } else {
                Utils.displayDialog(getActivity(), "OTP number must be greater than 5 digit", false);
            }
        } else if (v == tvResend) {
            asyncResendOtp = new AsyncResendOtp();
            asyncResendOtp.execute(mobilenumber, "" + Constants.REGISTRATION_OTP_REQUEST);
        }
    }

    private class AsyncSendOtp extends AsyncTask<String, Void, String> {
        private WSOtp wsOtp;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = Utils.showProgressBar(getActivity());

        }

        @Override
        protected String doInBackground(String... params) {
            String mobile = params[0];
            String request_type = params[1];
            String otp = params[2];
            wsOtp = new WSOtp(getActivity());
            return wsOtp.executeWebservice(mobile, request_type, otp);
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (!isCancelled()) {
                Utils.hideProgressBar(progressDialog);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.optInt("code");
                    String message = jsonObject.optString("msg");
                    switch (code) {
                        case 200:
//                            ACTION = USER_REGISTRATION;
//                            jsonObject = new JSONObject();
//                            jsonObject.put("mobile_no", sharedPref.getRegMobileNo(getApplicationContext()));
//                            jsonObject.put("password", sharedPref.getRegPassword(getApplicationContext()));
//                            jsonObject.put("request_type", Constants.REGISTRATION_OTP_REQUEST);
//                            jsonObject.put("user_type", Constants.FARM_MITRA);
//                            new BaseAPIService(RegistrationOtpVerification.this, Constants.MODULE, Constants.USER_REGISTRATION, jsonObject.toString(), responseListener, true);
                            break;
                        case 201:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 202:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 203:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);

                        case 204:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 205:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 206:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 500:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                        default:
                    /* display alert box if error occurred. */
                            Utils.displayDialog(getActivity(), message, false);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    private class AsyncResendOtp extends AsyncTask<String, Void, String> {
        private WSRequestOtp wsRequestOtp;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = Utils.showProgressBar(getActivity());

        }

        @Override
        protected String doInBackground(String... params) {
            String mobile = params[0];
            String request_type = params[1];
            wsRequestOtp = new WSRequestOtp(getActivity());
            return wsRequestOtp.executeWebservice(mobile, request_type);
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (!isCancelled()) {
                Utils.hideProgressBar(progressDialog);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.optInt("code");
                    String message = jsonObject.optString("msg");
                    switch (code) {
                        case 200:
                            tvResend.setEnabled(false);
                            tvRemainigTime.setVisibility(View.VISIBLE);
                            new CountDownTimer(30000, 1000) {

                                public void onTick(long millisUntilFinished) {
                                    tvRemainigTime.setText("Wait For 0:" + millisUntilFinished / 1000 + " Seconds");
                                }

                                public void onFinish() {
                                    tvRemainigTime.setText("" + getResources().getString(R.string.timer));
                                    tvRemainigTime.setVisibility(View.INVISIBLE);
                                    tvResend.setEnabled(true);
                                    tvError.setVisibility(View.INVISIBLE);
                                }
                            }.start();
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 201:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 202:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 203:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            tvResend.setEnabled(false);

                            tvRemainigTime.setVisibility(View.VISIBLE);
                            new CountDownTimer(30000, 1000) {

                                public void onTick(long millisUntilFinished) {

                                    tvRemainigTime.setText("Wait For 0:" + millisUntilFinished / 1000 + " Seconds");
                                }

                                public void onFinish() {
                                    tvRemainigTime.setText("" + getResources().getString(R.string.timer));
                                    tvRemainigTime.setVisibility(View.INVISIBLE);
                                    tvResend.setEnabled(true);
                                    tvError.setVisibility(View.INVISIBLE);
                                }
                            }.start();

                            break;
                        case 204:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            tvResend.setEnabled(false);
                        case 205:
                            tvResend.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 206:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 207:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 208:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 209:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                            break;
                        case 500:
                            tvError.setText("" + message);
                            tvError.setVisibility(View.VISIBLE);
                        default:
                    /* display alert box if error occurred. */
                            Utils.displayDialog(getActivity(), message, false);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
