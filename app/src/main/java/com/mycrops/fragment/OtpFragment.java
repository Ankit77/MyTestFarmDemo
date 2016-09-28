package com.mycrops.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mycrops.R;

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
public class OtpFragment extends BaseFragment implements View.OnClickListener{
    private View view;
    private Button btnSubmit;
    private EditText etOtp;
    private TextView tvResend;
    private TextView tvRemainigTime;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otp,container,false);
    }

    @Override
    public void initActionBar() {

    }

    @Override
    public void initComponent(View view) {
        btnSubmit=(Button)view.findViewById(R.id.fragment_otp_btnSubmit);
        tvRemainigTime=(TextView) view.findViewById(R.id.fragment_otp_tvtime);
        tvResend=(TextView) view.findViewById(R.id.fragment_otp_tvresendcode);
        etOtp=(EditText)view.findViewById(R.id.fragment_otp_etnumber);
        btnSubmit.setOnClickListener(this);
        tvResend.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v==btnSubmit)
        {

        }else if(v==tvResend)
        {

        }
    }
}
