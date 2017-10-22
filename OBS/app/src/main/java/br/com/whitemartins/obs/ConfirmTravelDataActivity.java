package br.com.whitemartins.obs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.whitemartins.obs.model.TravelVO;
import br.com.whitemartins.obs.util.HelperActivitiy;
import br.com.whitemartins.obs.util.HelperMockDataConfirmTravel;

public class ConfirmTravelDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        HelperActivitiy.setBarAction(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_travel_data);
        TravelVO travel = new TravelVO();
        travel.setTravelNumber("077936");
        travel.setTravelDate("04/04/2016");
        travel.setRouteNumber("102");
        travel.setUnit("3212");
        travel.setVehicleNumber("102");
        travel.setDriver("0");
        new HelperMockDataConfirmTravel(this).fillForm(travel);
        Button button = (Button) findViewById(R.id.confirm);
        button.setOnClickListener(confirmClickListener);
    }

    private View.OnClickListener confirmClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ConfirmTravelDataActivity.this, CustomerServiceActivity.class));
        }
    };

}
