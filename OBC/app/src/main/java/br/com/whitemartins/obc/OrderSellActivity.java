package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        orderNumber.setOnClickListener(orderClickListener);

        Button listItens = (Button) findViewById(R.id.list_itens);
        listItens.setOnClickListener(itemListClickListener);

    }

    private View.OnClickListener orderClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(OrderSellActivity.this, OrderSellMedicine.class));
        }
    };

    private View.OnClickListener itemListClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(OrderSellActivity.this, ItemListActivity.class));
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
