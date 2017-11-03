package br.com.whitemartins.obc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import br.com.whitemartins.obc.util.HelperActivitiy;

//import com.google.zxing.integration.android.IntentIntegrator;

public class OrderSellMedicine extends AppCompatActivity {

    SurfaceView cameraPreview;
    //private OrderSellMedicine orderSellMedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sell_medicine);
        HelperActivitiy.setBarAction(this);
        Button confirm = (Button) findViewById(R.id.confirm_order_sell);
        Button scanBarCode = (Button) findViewById(R.id.scan_bar_code);
        confirm.setOnClickListener(confirmClickListener);
        scanBarCode.setOnClickListener(scanBarCodeClickListener);
        //orderSellMedicine = this;
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(OrderSellMedicine.this, FinishOrderActivity.class));
        }
    };
    private View.OnClickListener scanBarCodeClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(OrderSellMedicine.this, BarCodeActivity.class);
            startActivityForResult(intent, 0);
            //new IntentIntegrator(orderSellMedicine).initiateScan();
            //startActivity(new Intent(OrderSellMedicine.this, FinishOrderActivity.class));
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if(resultCode == CommonStatusCodes.SUCCESS){
                if(intent!=null){
                    Barcode barcode = intent.getParcelableExtra("barcode");
                    if(barcode!=null){
                        Toast toast = Toast.makeText(OrderSellMedicine.this, R.string.bar_code_msg, Toast.LENGTH_SHORT);
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
