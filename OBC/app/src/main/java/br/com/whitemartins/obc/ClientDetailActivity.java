package br.com.whitemartins.obc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class ClientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        HelperActivitiy.setBarAction(this);
    }
}
