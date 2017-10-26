package br.com.whitemartins.obc.util;

import android.widget.EditText;

import br.com.whitemartins.obc.ConfirmClientActivity;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.ClientVO;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class HelperMockDataConfirmClient {

    private EditText clientAddress, clientName, clientCnpjCpf, unit, routeNumber, clientNumber;

    public HelperMockDataConfirmClient(ConfirmClientActivity activity){
        this.clientNumber = (EditText) activity.findViewById(R.id.confirm_client_number);
        this.clientName = (EditText) activity.findViewById(R.id.confirm_client_name);
        this.clientAddress = (EditText) activity.findViewById(R.id.confirm_client_address);
        this.clientCnpjCpf = (EditText) activity.findViewById(R.id.confirm_client_cnpj_cpf);
    }

    public void fillForm(ClientVO client){
        this.clientNumber.setText(client.getClientNumber());
        this.clientName.setText(client.getName());
        this.clientAddress.setText(client.getAddress());
        this.clientCnpjCpf.setText(client.getCnpjCpf());
    }

}
