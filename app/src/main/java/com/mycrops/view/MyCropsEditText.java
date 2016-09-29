package com.mycrops.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.mycrops.utils.CustomFontHelper;


/**
 * Purpose: This class set the font to textView according to attribute
 *
 * @author
 * @version 1.0
 * @date
 */
public class MyCropsEditText extends EditText {

    public MyCropsEditText(Context context) {
        super(context);
    }

    public MyCropsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public MyCropsEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }


}