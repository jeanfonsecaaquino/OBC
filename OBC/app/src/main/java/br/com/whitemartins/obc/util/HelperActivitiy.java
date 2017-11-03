package br.com.whitemartins.obc.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;

import br.com.whitemartins.obc.ConfirmTravelDataActivity;
import br.com.whitemartins.obc.CustomerServiceActivity;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.SplashScreemActivity;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperActivitiy {

    public static void setBarAction(AppCompatActivity activity){
        String barTitle = activity.getResources().getString(R.string.app_name_sigla);
        activity.getSupportActionBar().setTitle(barTitle);
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        if(!(activity instanceof SplashScreemActivity || activity instanceof ConfirmTravelDataActivity)){
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public static void events(AppCompatActivity activity, MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                activity.finish();
                break;
        }
    }

}
