package br.com.whitemartins.obc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class ClientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperActivitiy.setBarAction(this);
        setContentView(R.layout.activity_client_detail);
        HelperActivitiy.setBarAction(this);
        Button client_future_delivery = (Button) findViewById(R.id.client_future_delivery);
        Button client_shipping_sale = (Button) findViewById(R.id.client_shipping_sale);
        Button client_shipping_service = (Button) findViewById(R.id.client_shipping_service);


        client_future_delivery.setBackgroundColor(Color.GRAY);
        client_shipping_sale.setBackgroundColor(Color.GRAY);
        client_shipping_service.setBackgroundColor(Color.GRAY);
    }
}
