package br.com.whitemartins.obc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class ClientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperActivitiy.setBarAction(this);
        setContentView(R.layout.activity_client_detail);
        HelperActivitiy.setBarAction(this);
        Button sellOrder = (Button) findViewById(R.id.client_sell);
        sellOrder.setOnClickListener(sellOrderClickListener);
        Button client_future_delivery = (Button) findViewById(R.id.client_future_delivery);
        Button client_shipping_sale = (Button) findViewById(R.id.client_shipping_sale);
        Button client_shipping_service = (Button) findViewById(R.id.client_shipping_service);
        client_future_delivery.setBackgroundColor(Color.GRAY);
        client_shipping_sale.setBackgroundColor(Color.GRAY);
        client_shipping_service.setBackgroundColor(Color.GRAY);
    }

    private View.OnClickListener sellOrderClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ClientDetailActivity.this, OrderSellActivity.class));
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_detail_menu, menu);
        return true;
    }

}
