package br.com.whitemartins.obc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import br.com.whitemartins.obc.model.ItemVO;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

/**
 * Created by 1513 IRON on 05/11/2017.
 */

public class PosConfirmActivity extends AppCompatActivity {

    String total;
    Integer val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_confirm_activity);

        total = getIntent().getExtras().getString("total");
        val = getIntent().getExtras().getInt("val");

        EditText totalItens = (EditText) findViewById(R.id.qtd_itens);
        totalItens.setText(total);

        ArrayAdapter<ItemVO> adapter = new ArrayAdapter<ItemVO>(this, android.R.layout.simple_list_item_1, HelperMockDataConfirmClient.getItemsMock());
        final ListView itemList = (ListView) findViewById(R.id.item_list);
        itemList.setAdapter(adapter);

        Button buttonConfirm = (Button) findViewById(R.id.confirm_order_sell);
        buttonConfirm.setOnClickListener(posConfijrmClickListener);

    }

    private View.OnClickListener posConfijrmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent finishOrder = new Intent(PosConfirmActivity.this, FinishOrderActivity.class);
            finishOrder.putExtra("val", val);
            finishOrder.putExtra("total", total);
            startActivity(finishOrder);
        }
    };

}
