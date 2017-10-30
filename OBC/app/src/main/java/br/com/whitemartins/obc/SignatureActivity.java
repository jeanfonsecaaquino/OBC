package br.com.whitemartins.obc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obc.util.CanvasView;
import br.com.whitemartins.obc.util.HelperActivitiy;

public class SignatureActivity extends AppCompatActivity {

    private CanvasView canvasView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        HelperActivitiy.setBarAction(this);
        canvasView = (CanvasView) findViewById(R.id.canvas);
        Button confirmSignature = (Button) findViewById(R.id.sav_canvas);
        confirmSignature.setOnClickListener(confirmSignatureClickListener);
    }

    public void clearCanvas(View view){
            canvasView.clearCanvas();
    }

    private View.OnClickListener confirmSignatureClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };


}
