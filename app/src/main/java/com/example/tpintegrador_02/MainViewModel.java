package com.example.tpintegrador_02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> mldCajaResultado;
    public MutableLiveData<Boolean> mldRadioDolar;
    public MutableLiveData<Boolean> mldRadioEuro;

    public LiveData<String> getldtvResultado(){
        if(mldCajaResultado == null){
            mldCajaResultado = new MutableLiveData<String>();
        }
        return mldCajaResultado;
    }

    public LiveData<Boolean> getmldrbDolar(){
        if(mldRadioDolar == null){
            mldRadioDolar = new MutableLiveData<Boolean>();
        }
        return mldRadioDolar;
    }
    public LiveData<Boolean> getmldrbEuro(){
        if(mldRadioEuro == null){
            mldRadioEuro = new MutableLiveData<Boolean>();
        }
        return mldRadioEuro;
    }

    public void cambiarDolar(){
        mldRadioDolar.setValue(false);
    }
    public void cambiarEuro(){
        mldRadioEuro.setValue(false);
    }

    public void convertirMoneda(String moneda,String op){
        double m,res=0;
        m = Integer.parseInt(moneda);
        switch (op){
            case "dolar": res = m * 1.09;
                break;
            case "euro": res = m * 0.92;
                break;
        }

        mldCajaResultado.setValue(res+"");
    }

}
