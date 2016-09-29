package com.mycrops.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.mycrops.utils.CustomFontHelper;


public class MyCropsButton extends Button {

    public MyCropsButton(Context context) {
        super(context);
    }

    public MyCropsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public MyCropsButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

}