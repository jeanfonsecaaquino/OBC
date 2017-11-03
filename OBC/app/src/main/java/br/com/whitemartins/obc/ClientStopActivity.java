package br.com.whitemartins.obc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class ClientStopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_stop);
        HelperActivitiy.setBarAction(this);
        Button buttonConfirm = (Button) findViewById(R.id.remake_travel);
        Button listClients = (Button) findViewById(R.id.list_clients);
        buttonConfirm.setOnClickListener(confirmClickListener);
        listClients.setOnClickListener(listClientClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ClientStopActivity.this, ConfirmClientActivity.class));
        }
    };

    private View.OnClickListener listClientClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ClientStopActivity.this, ClientListActivity.class));
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_stop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }
}
