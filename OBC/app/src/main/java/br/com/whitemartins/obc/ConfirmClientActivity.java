package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class ConfirmClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_client);
        HelperActivitiy.setBarAction(this);
        ClientVO cliente = null;
        HelperMockDataConfirmClient mockData = new HelperMockDataConfirmClient(ConfirmClientActivity.this);
        mockData.getListClientsMock();
        if(getIntent().getExtras()!=null){
            String clientNumber = getIntent().getExtras().getString("clientNumber");
            cliente = mockData.getClientByNumber(clientNumber);
        }else{
            cliente = mockData.getClientByNumber("5184657");
        }
        new HelperMockDataConfirmClient(this).fillForm(cliente);
        Button confirmClient = (Button) findViewById(R.id.confirm_client);
        confirmClient.setOnClickListener(confirmClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ConfirmClientActivity.this, ClientDetailActivity.class));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_stop, menu);
        return true;
    }

}
