package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class FinishOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);
        HelperActivitiy.setBarAction(this);
        Button finishOrder = (Button) findViewById(R.id.finish_order);
        finishOrder.setOnClickListener(finishOrderClickListener);
    }

    private View.OnClickListener finishOrderClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(FinishOrderActivity.this, SendInvoiceActivity.class));
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