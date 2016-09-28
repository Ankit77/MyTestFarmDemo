package com.mycrops.utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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

    public static ProgressDialog showProgressBar(Context context) {
        ProgressDialog pd = new ProgressDialog(context, R.style.MyTheme);
        pd.setCancelable(false);
        pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pd.show();
        return pd;
    }

    public static void hideProgressBar(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();

    }
    public static void hideSoftKeyboard(View view, Context activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftKeyboard(View view, Context activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
