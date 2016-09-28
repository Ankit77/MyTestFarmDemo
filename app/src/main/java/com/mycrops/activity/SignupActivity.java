package com.mycrops.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mycrops.R;
import com.mycrops.fragment.OtpFragment;
import com.mycrops.utils.Utils;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Utils.replaceFragment(this, R.id.activity_signup_fr_container, new OtpFragment());
    }
}
