package br.com.whitemartins.obc;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;

import br.com.whitemartins.obc.model.TravelVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmTravel;

public class ConfirmTravelDataActivity extends AppCompatActivity {

    private static int POST_DELAYED_TIMEOUT = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_travel_data);
        TravelVO travel = new TravelVO();
        travel.setTravelNumber("077936");
        travel.setTravelDate("04/04/2016");
        travel.setRouteNumber("102");
        travel.setUnit("3212");
        travel.setVehicleNumber("102");
        travel.setDriver("0");
        new HelperMockDataConfirmTravel(this).fillForm(travel);
        Button buttonConfirm = (Button) findViewById(R.id.confirm);
        Button buttonCancel = (Button) findViewById(R.id.cancel);
        buttonConfirm.setOnClickListener(confirmClickListener);
        buttonCancel.setOnClickListener(cancelClickListener);
        /*final EditText travelEditText = (EditText)findViewById(R.id.travel_date);
        travelEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        int s=monthOfYear+1;
                        String a = dayOfMonth+"/"+s+"/"+year;
                        travelEditText.setText(""+a);
                    }
                };

                Date date = Calendar.getInstance().getTime();
                DatePickerDialog d = new DatePickerDialog(ConfirmTravelDataActivity.this, dpd, date.getYear() ,date.getMonth(), date.getDay());
                d.show();
                return true;
            }
        }); */
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ConfirmTravelDataActivity.this, CustomerServiceActivity.class));
        }
    };

    private View.OnClickListener cancelClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            new AlertDialog.Builder(ConfirmTravelDataActivity.this)
                    .setMessage(R.string.exit_confirm_travel_msg)
                    .setCancelable(false)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ProgressBar progressBar = (ProgressBar) findViewById(R.id.confirm_travel_progressbar);
                            progressBar.setVisibility(View.VISIBLE);
                            Toast toast = Toast.makeText(ConfirmTravelDataActivity.this, R.string.exit_confirm_clean_table_data, Toast.LENGTH_SHORT);
                            toast.show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(ConfirmTravelDataActivity.this, SplashScreemActivity.class));
                                    finish();
                                }},POST_DELAYED_TIMEOUT
                            );
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }
}
