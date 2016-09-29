package com.mycrops.utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;

import com.mycrops.R;

public class Utils {

    public static void replaceFragment(final Activity activity
            , final int container
            , final Fragment fragment) {
        if (activity != null && !activity.isFinishing() && fragment != null) {
            activity.getFragmentManager()
                    .beginTransaction()
                    .replace(container, fragment, fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    public static void addFragment(final Activity activity
            , final int container
            , final Fragment currentFragment
            , final Fragment hideFragment) {
        if (activity != null && !activity.isFinishing() && currentFragment != null && hideFragment != null) {
            activity.getFragmentManager()
                    .beginTransaction()
                    .add(container, currentFragment, currentFragment.getClass().getSimpleName())
                    .hide(hideFragment)
                    .addToBackStack(currentFragment.getClass().getSimpleName())
                    .commit();
        }
    }


    public static void displayDialog(final Context context,
                                     final String message,
                                     final boolean isFinish) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (isFinish) {
                    ((Activity) context).onBackPressed();
                }

            }
        });
        builder.show();
    }

}
