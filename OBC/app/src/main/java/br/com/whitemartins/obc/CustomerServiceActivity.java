package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class CustomerServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        HelperActivitiy.setBarAction(this);

        Button customerService = (Button) findViewById(R.id.customer_service);
        customerService.setOnClickListener(customerServiceClickListener);

        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(settingsClickListener);

    }

    private View.OnClickListener customerServiceClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(CustomerServiceActivity.this, ClientStopActivity.class));
        }
    };

    private View.OnClickListener settingsClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(CustomerServiceActivity.this, SettingsActivity.class));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

}
