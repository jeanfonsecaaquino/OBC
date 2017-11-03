package br.com.whitemartins.obc;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.whitemartins.obc.util.CanvasView;
import br.com.whitemartins.obc.util.HelperActivitiy;
import honeywell.connection.ConnectionBase;
import honeywell.connection.Connection_Bluetooth;
import honeywell.printer.DocumentDPL;
import honeywell.printer.ParametersDPL;

public class SignatureActivity extends AppCompatActivity implements Runnable {

    private CanvasView canvasView;
    private ParametersDPL paramDPL;
    private DocumentDPL docDPL;
    byte[] printData = {0};
    Bitmap bitmap;
    ConnectionBase conn = null;
    private static final String m_printerMAC = "84:25:3F:26:3A:D9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        HelperActivitiy.setBarAction(this);
        canvasView = (CanvasView) findViewById(R.id.canvas);
        Button confirmSignature = (Button) findViewById(R.id.sav_canvas);
        confirmSignature.setOnClickListener(confirmSignatureClickListener);
    }

    public void clearCanvas(View view) {
        canvasView.clearCanvas();
    }

    private View.OnClickListener confirmSignatureClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            bitmap = canvasView.getmBitmap();
            try {
                printData = new byte[]{0};
                docDPL = new DocumentDPL();
                paramDPL = new ParametersDPL();
                docDPL.setEnableAdvanceFormatAttribute(true);
                //Using Internal Smooth Font with size 14
                paramDPL.setIsBold(true);
                docDPL.writeTextInternalSmooth("                                  DANFE SIMPLIFICADO                           ", 10, 1110, 5, paramDPL);
                docDPL.writeTextInternalSmooth("                WHITE MARTINS GASES INDS.NORTE LTDA.                           ", 10, 1090, 5, paramDPL);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("DADOS DA NOTA FISCAL", 8, 1050, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("Nota Fiscal de VENDA: 20 Série 119", 8, 1030, 5, paramDPL);
                docDPL.writeTextInternalSmooth("Data de Emissão: 24/062015 13:00:00 Tipo Operação: Saída", 8, 1010, 5, paramDPL);
                docDPL.writeTextInternalSmooth("                          CHAVE DE ACESSO                           ", 8, 980, 5, paramDPL);
                docDPL.writeBarCode("A", "BRCDA", 950, 40);
                docDPL.writeTextInternalSmooth("            13150634597955000462551190000000201575717400            ", 8, 910, 5, paramDPL);
                paramDPL.setIsBold(true);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("PROTOCOLO de AUTORIZAÇÃO DE USO", 8, 890, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("113150237780075             24/06/2015      14:00:42", 8, 870, 5, paramDPL);
                paramDPL.setIsBold(true);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("DADOS DO EMINENTE", 8, 840, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("NOME: USINA DE MANAUS", 6, 820, 5, paramDPL);
                docDPL.writeTextInternalSmooth("CNPJ: 34.597.955/0004-32    I.E.: 041946200    UF:AM", 6, 800, 5, paramDPL);
                paramDPL.setIsBold(true);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("DADOS DO DESTINATARIO", 8, 770, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("NOME: BRUNO FERNENDO FARIA PEREIRA      CNPQ 470143", 6, 750, 5, paramDPL);
                docDPL.writeTextInternalSmooth("CNPJ: 295.124.428-25        I.E.: ISENTO       UF:AM", 6, 730, 5, paramDPL);
                paramDPL.setIsBold(true);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("DADOS DOS PRODUTOS", 8, 700, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("Descrição                   Un.     Qtd.        V1.Uni      V1.Total", 6, 680, 5, paramDPL);
                docDPL.writeTextInternalSmooth("Acetileno 2.8AA Cilindro    KG      1/9,00      134,67      1212,00", 6, 660, 5, paramDPL);
                docDPL.writeTextInternalSmooth("Valor Total da Nota Fiscal R$ 1.375,00", 8, 640, 5, paramDPL);
                paramDPL.setIsBold(true);
                paramDPL.setIsUnderline(true);
                docDPL.writeTextInternalSmooth("DADOS ADICIONAIS", 8, 610, 5, paramDPL);
                paramDPL.setIsBold(false);
                paramDPL.setIsUnderline(false);
                docDPL.writeTextInternalSmooth("Filial: RBA 363 / Viagem 035031 / Veiculo: 1181", 8, 580, 5, paramDPL);
                docDPL.writeTextInternalSmooth("__________________________________________________", 8, 530, 5, paramDPL);
                docDPL.writeTextInternalSmooth("Recebemos de WHITE MARTINS GASES INDS. NORTE LTDA.", 8, 510, 5, paramDPL);
                docDPL.writeTextInternalSmooth("unidade USINA DE MANAUS, os produtos constantes na", 8, 490, 5, paramDPL);
                docDPL.writeTextInternalSmooth(" Nota Fiscal enviada acima.", 8, 470, 5, paramDPL);
                docDPL.writeTextInternalSmooth("Para Receber a NF Eletronica, Mantenha o email", 8, 450, 5, paramDPL);
                docDPL.writeTextInternalSmooth("atualizado pelo 0800 709 9000 (de tel fixo), ", 8, 430, 5, paramDPL);
                docDPL.writeTextInternalSmooth("(21) 3548-3500 (de celular). ", 8, 410, 5, paramDPL);
                docDPL.writeTextInternalSmooth("NOME: ROBERTA KELLY", 8, 390, 5, paramDPL);
                docDPL.writeImage(bitmap, 10, 5, paramDPL);
                printData = docDPL.getDocumentData();
                new Thread(SignatureActivity.this, "PrintingTask").start();
            } catch (Exception e) {
                e.printStackTrace();
                AlertDialog.Builder builder = new AlertDialog.Builder(SignatureActivity.this);
                builder.setTitle("Application Error")
                        .setMessage(e.getMessage())
                        .setCancelable(false)
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    };
    @Override
    public void run() {
        //Connection
        try
        {
            conn = null;
            Looper.prepare();
            conn = Connection_Bluetooth.createClient(m_printerMAC, false);
            if(!conn.getIsOpen()) { conn.open(); }
            Toast toast = Toast.makeText(SignatureActivity.this, R.string.send_data_printer, Toast.LENGTH_SHORT);
            toast.show();
            int bytesWritten = 0;
            int bytesToWrite = 1024;
            int totalBytes = printData.length;
            int remainingBytes = totalBytes;
            while (bytesWritten < totalBytes) {
                if (remainingBytes < bytesToWrite)
                    bytesToWrite = remainingBytes;
                conn.write(printData, bytesWritten, bytesToWrite);
                bytesWritten += bytesToWrite;
                remainingBytes = remainingBytes - bytesToWrite;
                Thread.sleep(100);
            }
            conn.close();
            toast = Toast.makeText(SignatureActivity.this, R.string.send_data_printer_ok, Toast.LENGTH_SHORT);
            toast.show();
        }
        catch (Exception e) {
            if(conn != null) {
                conn.close();
            }
            Toast toast = Toast.makeText(SignatureActivity.this, R.string.send_data_printer_fail, Toast.LENGTH_SHORT);
            toast.show();
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        HelperActivitiy.events(this, item);
        return super.onOptionsItemSelected(item);
    }

}
