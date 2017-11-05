package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.model.ItemVO;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ArrayAdapter<ItemVO> adapter = new ArrayAdapter<ItemVO>(this, android.R.layout.simple_list_item_1, HelperMockDataConfirmClient.getItemsMock());
        final ListView itemList = (ListView) findViewById(R.id.item_list);
        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemVO item = (ItemVO) itemList.getItemAtPosition(position);
                Intent confirmClient = new Intent(ItemListActivity.this, ConfirmOrderSellActivity.class);
                if(getIntent().getExtras()!=null){
                    confirmClient.putExtra("total", getIntent().getExtras().getString("total"));
                    confirmClient.putExtra("val", getIntent().getExtras().getInt("val"));
                }
                confirmClient.putExtra("productNumber", item.getNumber());
                startActivity(confirmClient);
                finish();
            }
        });
    }
}
