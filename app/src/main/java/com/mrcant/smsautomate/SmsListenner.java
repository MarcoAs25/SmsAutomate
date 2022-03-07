package com.mrcant.smsautomate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsListenner extends BroadcastReceiver implements Observado {
    private static SmsListenner INSTANCE = null;
    Observador obs;

    public static SmsListenner getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SmsListenner();
        }
        return INSTANCE;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("OLA PESSOAS");
        StringBuilder builder = new StringBuilder();

        Object[] objects = (Object[]) intent.getExtras().get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[]) objects[0]);
        /*
        TODO replace UnityPlayer.UnitySendMessage function with AndroidJavaProxy callback
        https://docs.unity3d.com/ScriptReference/AndroidJavaProxy.html
        */
        String sender = message.getDisplayOriginatingAddress();
        for (int i = 0; i < objects.length; i++) {
            message = SmsMessage.createFromPdu((byte[]) objects[i]);
            builder.append(message.getDisplayMessageBody());
        }
        notificarObservadores(builder.toString()+"/"+sender);

    }

    @Override
    public void adicionaObservador(Observador obs) {
        this.obs = obs;
    }

    @Override
    public void notificarObservadores(String msg) {
        if(INSTANCE.obs != null)
            INSTANCE.obs.atualiza(msg);
        else
            System.out.println("olaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
