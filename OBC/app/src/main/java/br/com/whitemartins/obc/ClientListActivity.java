package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class ClientListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);
        HelperActivitiy.setBarAction(this);
        ArrayAdapter<ClientVO> adapter = new ArrayAdapter<ClientVO>(this, android.R.layout.simple_list_item_1,HelperMockDataConfirmClient.getListClientsMock());
        final ListView clientList = (ListView) findViewById(R.id.client_list);

        clientList.setAdapter(adapter);

        clientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClientVO cliente = (ClientVO) clientList.getItemAtPosition(position);
                Intent confirmClient = new Intent(ClientListActivity.this, ConfirmClientActivity.class);
                confirmClient.putExtra("clientNumber", cliente.getClientNumber());
                startActivity(confirmClient);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_stop, menu);
        return true;
    }

}
