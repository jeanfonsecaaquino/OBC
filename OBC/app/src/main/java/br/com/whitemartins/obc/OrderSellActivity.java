package br.com.whitemartins.obc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class OrderSellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sell);
    }
}
