package com.dam2.m08;

import android.content.Context;
import android.widget.Toast;

public class ShowError {
    public static void showError(Context context, String error) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }
}
