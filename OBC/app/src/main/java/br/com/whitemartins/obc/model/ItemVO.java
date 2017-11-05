package br.com.whitemartins.obc.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 1513 IRON on 29/10/2017.
 */

public class ItemVO {

    private String number, name, volume, cylinder, lot;
    private Integer qtd, price;

    public ItemVO(){}

    public ItemVO(String number, String name, String volume, Integer price){
        this.number = number;
        this.name = name ;
        this.volume = volume;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "/" + volume;
    }

    public void addMockClientToList(List<ItemVO> items){
        items.add(this);
    }
}
