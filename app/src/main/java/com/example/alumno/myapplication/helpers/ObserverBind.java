package com.example.alumno.myapplication.helpers;

import android.database.Observable;
import android.util.Log;

import java.util.Observer;


public class ObserverBind implements Observer {
    private  Callback callback;


    public void setCallback(Callback callback){
        if (callback==null){
            return;
        }
        this.callback=callback;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        Log.v( "bichito",  "update <<<<");
        if (this.callback!=null){
            this.callback.dothis(o,arg);

        }
    }
}
