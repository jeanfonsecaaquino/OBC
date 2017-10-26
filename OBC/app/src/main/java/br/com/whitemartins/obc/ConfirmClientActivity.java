package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class ConfirmClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_client);
        ClientVO cliente = new ClientVO();
        cliente.setClientNumber("52288641");
        cliente.setName("UNIMED RIO COOPERATIVA DE TRABALHO MEDIC");
        cliente.setAddress("AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ");
        cliente.setCnpjCpf("1-42.163.881/0001-01");
        new HelperMockDataConfirmClient(this).fillForm(cliente);
        Button confirmClient = (Button) findViewById(R.id.confirm_client);
        confirmClient.setOnClickListener(confirmClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ConfirmClientActivity.this, ClientDetailActivity.class));
        }
    };

}
