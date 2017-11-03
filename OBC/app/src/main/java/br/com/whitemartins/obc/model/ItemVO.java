package br.com.whitemartins.obc.model;

import java.util.List;

/**
 * Created by 1513 IRON on 29/10/2017.
 */

public class ItemVO {

    private String name, volume;

    public ItemVO(){}

    public ItemVO(String name, String volume){
        this.name = name ;
        this.volume = volume;
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

    @Override
    public String toString() {
        return name + "/" + volume;
    }

    public void addMockClientToList(List<ItemVO> items){
        items.add(this);
    }
}
