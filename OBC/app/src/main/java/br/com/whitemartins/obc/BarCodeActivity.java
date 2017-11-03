package br.com.whitemartins.obc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import br.com.whitemartins.obc.util.HelperActivitiy;

public class BarCodeActivity extends AppCompatActivity {

    SurfaceView cameraPreview;
    private static final int CAMERA_PERMISSION_CAMERA = 0x000000;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    TextView barcodeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        cameraPreview = (SurfaceView) findViewById(R.id.camera_preview);
        createCameraResource();
    }

    private void createCameraResource() {
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this).build();
        final CameraSource cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setAutoFocusEnabled(true)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(640, 480)
                .build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ContextCompat.checkSelfPermission(BarCodeActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(BarCodeActivity.this,Manifest.permission.CAMERA)) {

                        } else {
                            ActivityCompat.requestPermissions(BarCodeActivity.this,new String[]{Manifest.permission.CAMERA},CAMERA_PERMISSION_CAMERA);
                        }
                    }
                    cameraSource.start(cameraPreview.getHolder());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if(barcodes.size()>0){
                    Intent intent = new Intent();
                    intent.putExtra("barcode",barcodes.valueAt(0));
                    setResult(CommonStatusCodes.SUCCESS, intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }
}
