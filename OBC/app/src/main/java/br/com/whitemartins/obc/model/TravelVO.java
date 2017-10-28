package br.com.whitemartins.obc.model;

import java.util.Calendar;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class TravelVO {

    private String travelDate, travelNumber, vehicleNumber, unit, routeNumber, driver;

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getTravelNumber() {
        return travelNumber;
    }

    public void setTravelNumber(String travelNumber) {
        this.travelNumber = travelNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

   /* public String getDriver() {
        return driver;
    }
*/
  /*  public void setDriver(String driver) {
        this.driver = driver;
    }*/
}
