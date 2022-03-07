package com.mrcant.smsautomate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  Observador{
    private Observado mUserDataRepository;
    String phone = "+5537999594028";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDataRepository = SmsListenner.getInstance();
        mUserDataRepository.adicionaObservador(this);
    }
    @Override
    /**
     * RECEBE AS MESSAGENS RECEBIDAS PELO TELEFONE
     **/
    public void atualiza(String smg) {
        //txtMsg.setText(smg);
    }
    /**
     * ACIONA E DESLIGA A VALVULA
     **/
    public void acionarDesligarValvula(View view){


    }
    /**
     * ACIONA E DESLIGA A BOMBA
     **/
    public void acionarDesligarBomba(View view){

    }
    /**
     * TIRA FOTO E SALVA NO CARTÃO SD
     **/
    public void tirarFoto(View view){
        String messageText = "tirarfoto";
        String alert;
        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phone, null, messageText, null, null);
            alert = "Comando enviado";
        }catch (Exception e){
            alert = "Comando não enviado";
        }
        Toast.makeText(this,alert,Toast.LENGTH_SHORT).show();
    }
    /**
     * PEDE A INFORMAÇÃO SE ALGUM SISTEMA ESTÁ OFFLINE
     **/
    public void statusSistema(View view){
        String messageText = "statussistema";
        String alert;
        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phone, null, messageText, null, null);
            alert = "Comando enviado";
        }catch (Exception e){
            alert = "Comando não enviado";
        }
        Toast.makeText(this,alert,Toast.LENGTH_SHORT).show();
    }
    /**
     * PEDE A HUMIDADE DO SOLO
     **/
    public void humidade(View view){
        String messageText = "humidade";
        String alert;
        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phone, null, messageText, null, null);
            alert = "Comando enviado";
        }catch (Exception e){
            alert = "Comando não enviado";
        }
        Toast.makeText(this,alert,Toast.LENGTH_SHORT).show();
    }
}