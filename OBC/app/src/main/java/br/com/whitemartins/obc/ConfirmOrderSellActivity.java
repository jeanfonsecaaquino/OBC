package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import br.com.whitemartins.obc.model.ItemVO;
import br.com.whitemartins.obc.util.HelperActivitiy;
import br.com.whitemartins.obc.util.HelperMockDataConfirmClient;
import br.com.whitemartins.obc.util.HelperMockDataConfirmTravel;

//import com.google.zxing.integration.android.IntentIntegrator;

public class ConfirmOrderSellActivity extends AppCompatActivity {

    SurfaceView cameraPreview;
    ItemVO item;
    Integer val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_sell);
        String clientNumber = getIntent().getExtras().getString("productNumber");
        item  = HelperMockDataConfirmClient.getItemByNumber(clientNumber);
        TextView detailOrderSell = (TextView) findViewById(R.id.detail_order_sell);
        detailOrderSell.setText(item.getNumber() + "-" + item.getName() + "- Capacidade:" + item.getVolume());
        Button confirm = (Button) findViewById(R.id.confirm_order_sell);
//        Button scanBarCode = (Button) findViewById(R.id.scan_bar_code);
        confirm.setOnClickListener(confirmClickListener);
        val = getIntent().getExtras().getInt("val");
//        scanBarCode.setOnClickListener(scanBarCodeClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent finishOrder = new Intent(ConfirmOrderSellActivity.this, OrderSellActivity.class);
            String qtd  = ((EditText)(findViewById(R.id.qtd_items))).getText().toString();
//            String cylinder  = ((EditText)(findViewById(R.id.cylinder))).getText().toString();
//            Integer lot  = Integer.valueOf(((EditText)(findViewById(R.id.lot))).getText().toString());
            if(qtd==null || qtd.isEmpty()){
                Toast.makeText(ConfirmOrderSellActivity.this, R.string.empty_data, Toast.LENGTH_SHORT).show();
            }else {
                Integer qtdInt = Integer.parseInt(qtd);
                String total = getIntent().getExtras().getString("total");
                Integer totalSomado = 0;
                Integer valTemp = qtdInt * item.getPrice();
                if(total!=null && !total.isEmpty()){
                    totalSomado = Integer.valueOf(total);
                    totalSomado = totalSomado + qtdInt;
                }else{
                    totalSomado = qtdInt;
                }

                if(val!=null){
                    valTemp = val + valTemp;
                }else{
                    totalSomado = qtdInt;
                }
                finishOrder.putExtra("total", totalSomado);
                finishOrder.putExtra("val", valTemp);
                startActivity(finishOrder);
                finish();
            }
        }
    };
    private View.OnClickListener scanBarCodeClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(ConfirmOrderSellActivity.this, BarCodeActivity.class);
            startActivityForResult(intent, 0);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if(resultCode == CommonStatusCodes.SUCCESS){
                if(intent!=null){
                    Barcode barcode = intent.getParcelableExtra("barcode");
                    if(barcode!=null){
                        Toast toast = Toast.makeText(ConfirmOrderSellActivity.this, R.string.bar_code_msg, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }

}
