package br.com.whitemartins.obc.util;

import android.widget.EditText;

import br.com.whitemartins.obc.ConfirmTravelDataActivity;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.TravelVO;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperMockDataConfirmTravel {

    private EditText travelNumber, travelDate, vehicleNumber, unit, routeNumber, driver;

    public HelperMockDataConfirmTravel(ConfirmTravelDataActivity activity){
        this.driver = (EditText) activity.findViewById(R.id.driver);
        this.travelDate = (EditText) activity.findViewById(R.id.travel_date);
        this.travelNumber = (EditText) activity.findViewById(R.id.travel_number);
        this.vehicleNumber = (EditText) activity.findViewById(R.id.vehicle_number);
        this.unit = (EditText) activity.findViewById(R.id.unit);
        this.routeNumber = (EditText) activity.findViewById(R.id.route_number);
    }

    public void fillForm(TravelVO travel){
        this.driver.setText(travel.getDriver());
        this.travelDate.setText(travel.getTravelDate());
        this.travelNumber.setText(travel.getTravelNumber());
        this.vehicleNumber.setText(travel.getVehicleNumber());
        this.unit.setText(travel.getUnit());
        this.routeNumber.setText(travel.getRouteNumber());
    }

}
