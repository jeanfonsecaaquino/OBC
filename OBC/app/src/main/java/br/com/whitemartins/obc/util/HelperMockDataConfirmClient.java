package br.com.whitemartins.obc.util;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.ConfirmClientActivity;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.ClientVO;
import br.com.whitemartins.obc.model.Item;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperMockDataConfirmClient {

    private EditText clientAddress, clientName, clientCnpjCpf, unit, routeNumber, clientNumber;

    private static final String PACIENTE = "PACIENTE";
    private static List<ClientVO> clients = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();

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
            new ClientVO("5184657" , PACIENTE, "LUIZ FELIPE ALVARENGA", "AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ", "1-42.163.881/0001-01").addMockClientToList(clients);
            new ClientVO("52180830", PACIENTE, "CARLOS JORGE", "AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ", "1-42.163.881/0001-01").addMockClientToList(clients);
            new ClientVO("52180830", PACIENTE, "CARLOS JORGE", "AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ", "1-42.163.881/0001-01").addMockClientToList(clients);
            new ClientVO("53417434", PACIENTE, "PAULO JOSE DE ABREU", "AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ", "1-42.163.881/0001-01").addMockClientToList(clients);
            new ClientVO("54784972", PACIENTE, "PEDRO HENRIQUE", "AVENIDA ARMANDO LOMBARDI 400 L101 BARRA DA TIJUCA RIO DE JANEIRO RJ", "1-42.163.881/0001-01").addMockClientToList(clients);
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

    public static List<Item> getItemsMock() {
        new Item("OxigenioGas CLi T 10M3", "10.00").addMockClientToList(items);
        new Item("OxigenioGas CLi T 10M3", "10.00").addMockClientToList(items);
        new Item("OxigenioGas CLi T 10M3", "10.00").addMockClientToList(items);
        return items;
    }

}
