package br.com.whitemartins.obc.util;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.ConfirmClientActivity;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.model.ItemVO;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperMockDataConfirmClient {

    private EditText clientAddress, clientName, clientCnpjCpf, unit, routeNumber, clientNumber;

    private static final String PACIENTE = "PACIENTE";
    private static List<ClientVO> clients = new ArrayList<>();
    private static List<ItemVO> items = new ArrayList<>();

    public HelperMockDataConfirmClient(ConfirmClientActivity activity) {
        this.clientNumber = (EditText) activity.findViewById(R.id.confirm_client_number);
        this.clientName = (EditText) activity.findViewById(R.id.confirm_client_name);
        this.clientAddress = (EditText) activity.findViewById(R.id.confirm_client_address);
        this.clientCnpjCpf = (EditText) activity.findViewById(R.id.confirm_client_cnpj_cpf);
    }

    public void fillForm(ClientVO client) {
        this.clientNumber.setText(client.getClientNumber());
        this.clientName.setText(client.getName());
        this.clientAddress.setText(client.getAddress());
        this.clientCnpjCpf.setText(client.getCnpjCpf());
    }

    public static List<ClientVO> getListClientsMock() {
        if(clients.size()==0){
            new ClientVO(   "56262004" ,PACIENTE,
                                "DANIELE FRASCARELI",
                                "AVENIDA TRES DE MARCO",
                                "388.984.618-10").addMockClientToList(clients);
            new ClientVO(   "55687660" , PACIENTE,
                                "COMERCIO SUC.CARDOSO BOITUVA ME  ",
                                "AVENIDA MANOEL TRUJILLO, 126",
                                "008.463.816/0001-63").addMockClientToList(clients);
        }
        return clients;
    }

    public static ClientVO getClientByNumber(String number) {
        for (ClientVO client : clients) {
            if (client.getClientNumber().equalsIgnoreCase(number)) {
                return client;
            }
        }
        return null;
    }

    public static ItemVO getItemByNumber(String number) {
        for (ItemVO item : items) {
            if (item.getNumber().equalsIgnoreCase(number)) {
                return item;
            }
        }
        return null;
    }

    public static List<ItemVO> getItemsMock() {
        if(items.size()==0) {
            new ItemVO("40025532","Oxigenio Gas Cli T 10M3", "10.00", 10).addMockClientToList(items);
            new ItemVO("40038432","Oxigenio Medicinal Cli T 10M3", "10.00", 100).addMockClientToList(items);
            new ItemVO("40037393","Argonio Gas Cil K 7M3", "7.00", 200).addMockClientToList(items);
        }
        return items;
    }

}
