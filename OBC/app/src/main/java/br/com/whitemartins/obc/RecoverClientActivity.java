package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class RecoverClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_client);
        Button confirmClient = (Button) findViewById(R.id.confirm_recover_client);
        confirmClient.setOnClickListener(confirmClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(RecoverClientActivity.this, ConfirmClientActivity.class));
        }
    };

}
