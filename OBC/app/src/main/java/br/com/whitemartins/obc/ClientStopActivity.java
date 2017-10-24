package br.com.whitemartins.obc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.util.HelperActivitiy;

public class ClientStopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_stop);
        HelperActivitiy.setBarAction(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }
}
