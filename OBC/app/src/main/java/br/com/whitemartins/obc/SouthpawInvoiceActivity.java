package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import br.com.whitemartins.obc.model.ItemVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class SouthpawInvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southpaw_invoice);
        HelperActivitiy.setBarAction(this);
        ArrayAdapter<ItemVO> adapter = new ArrayAdapter<ItemVO>(this, android.R.layout.simple_list_item_1, HelperMockDataConfirmClient.getItemsMock());
        final ListView itemList = (ListView) findViewById(R.id.item_list);
        itemList.setAdapter(adapter);
        Button confirm = (Button) findViewById(R.id.southpaw_confirm);
        confirm.setOnClickListener(confirmSouthpawClickListener);
    }

    private View.OnClickListener confirmSouthpawClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(SouthpawInvoiceActivity.this, SignatureActivity.class));
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }

}
