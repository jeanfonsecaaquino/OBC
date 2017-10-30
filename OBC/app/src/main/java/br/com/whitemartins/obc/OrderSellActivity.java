package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class OrderSellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sell);
        HelperActivitiy.setBarAction(this);
        Button orderNumber = (Button) findViewById(R.id.number_order);
        orderNumber.setOnClickListener(ordrClickListener);
    }

    private View.OnClickListener ordrClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(OrderSellActivity.this, OrderSellMedicine.class));
        }
    };

}
