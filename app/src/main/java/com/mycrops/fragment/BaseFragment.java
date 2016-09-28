package com.mycrops.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public abstract class  BaseFragment extends Fragment implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public abstract void initActionBar();
    public abstract void initComponent(View view);

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponent(view);
    }

//    @Override
//    public void onClick(View v) {
//
//    }
}
