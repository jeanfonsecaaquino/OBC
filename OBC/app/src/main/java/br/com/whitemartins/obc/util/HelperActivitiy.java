package br.com.whitemartins.obs.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import br.com.whitemartins.obs.R;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperActivitiy {

    public static void setBarAction(AppCompatActivity activity){
        String barTitle = activity.getResources().getString(R.string.app_name_sigla);
        activity.getSupportActionBar().setTitle(barTitle);
    }

}
