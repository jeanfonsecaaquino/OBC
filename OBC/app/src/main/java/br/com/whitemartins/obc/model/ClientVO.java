package br.com.whitemartins.obc.model;

import java.util.List;

/**
 * Created by 1513 IRON on 26/10/2017.
 */

public class ClientVO {

    public ClientVO (String clientNumber, String codigoJde, String name, String address, String cnpjCpf){
        this.clientNumber = clientNumber;
        this.name = name;
        this.address = address;
        this.codigoJde = codigoJde;
        this.cnpjCpf = cnpjCpf;
    }

    public ClientVO (){}

    private String clientNumber,name,address,codigoJde,cnpjCpf;

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getCodigoJde() {
        return codigoJde;
    }

    public void setCodigoJde(String codigoJde) {
        this.codigoJde = codigoJde;
    }

    @Override
    public String toString() {
        return clientNumber + " - " + codigoJde + " - " + name;
    }

    public void addMockClientToList(List<ClientVO> clients){
        clients.add(this);
    }

}
