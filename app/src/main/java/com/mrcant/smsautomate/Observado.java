package com.mrcant.smsautomate;

public interface Observado {
    public void adicionaObservador(Observador obs);
    public void notificarObservadores(String msg);
}
