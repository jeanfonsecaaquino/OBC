package br.com.whitemartins.obc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class SendInvoiceActivity extends AppCompatActivity {

    private static int SEND_INVOICE_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_invoice);
        HelperActivitiy.setBarAction(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SendInvoiceActivity.this, SouthpawInvoiceActivity.class));
                finish();
            }}, SEND_INVOICE_TIME_OUT
        );
    }

}
