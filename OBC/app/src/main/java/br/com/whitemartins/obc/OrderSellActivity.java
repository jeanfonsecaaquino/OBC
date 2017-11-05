package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.whitemartins.obc.model.ItemVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;

public class OrderSellActivity extends AppCompatActivity {

    private Integer val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sell);
        if(getIntent().getExtras()!=null){
            Integer total = getIntent().getExtras().getInt("total");
            val = getIntent().getExtras().getInt("val");
            Integer cylinder = getIntent().getExtras().getInt("cylinder");
            Integer lot = getIntent().getExtras().getInt("lot");
                if(total!=null){
                    ((EditText)findViewById(R.id.total_qtd)).setText(total.toString());
                }
        }
        Object o = getIntent().getExtras();
        HelperActivitiy.setBarAction(this);

        Button confirmOrderSell = (Button) findViewById(R.id.confirm_order_sell);
        confirmOrderSell.setOnClickListener(confirmOrderSellClickListener);

        Button listItens = (Button) findViewById(R.id.list_itens);
        listItens.setOnClickListener(itemListClickListener);

        Button finishOrder = (Button) findViewById(R.id.finish_order);
        finishOrder.setOnClickListener(finishOrderClickListener);
    }

    private View.OnClickListener confirmOrderSellClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent confirmSell = new Intent(OrderSellActivity.this, ConfirmOrderSellActivity.class);
            String productNumber = ((EditText) findViewById(R.id.order_sell_product_number)).getText().toString();
            HelperMockDataConfirmClient.getItemsMock();
            if(productNumber== null || productNumber.isEmpty()){
                Toast.makeText(OrderSellActivity.this, R.string.empty_product_code_msg, Toast.LENGTH_SHORT).show();
            }else {
                ItemVO item = HelperMockDataConfirmClient.getItemByNumber(productNumber);
                if(item!=null){
                    confirmSell.putExtra("productNumber", item.getNumber());
                    String total = ((EditText)findViewById(R.id.total_qtd)).getText().toString();
                    if(total!=null && !total.isEmpty()){
                        confirmSell.putExtra("total", total);
                    }
                    if(val!=null){
                        confirmSell.putExtra("val", val);
                    }
                    startActivity(confirmSell);
                    finish();
                }else{
                    Toast.makeText(OrderSellActivity.this, R.string.invalid_product_code_msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    private View.OnClickListener itemListClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent itemListActivity = new Intent(OrderSellActivity.this, ItemListActivity.class);
            String total = ((EditText)findViewById(R.id.total_qtd)).getText().toString();
            if(total!=null && !total.isEmpty()){
                itemListActivity.putExtra("total", total);
            }
            if(val!=null){
                itemListActivity.putExtra("val", val);
            }
            startActivity(itemListActivity);
        }
    };

    private View.OnClickListener finishOrderClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent finishOrder = new Intent(OrderSellActivity.this, FinishOrderActivity.class);
            finishOrder.putExtra("val", val);
            startActivity(finishOrder);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_detail_menu, menu);
        return true;
    }

}
