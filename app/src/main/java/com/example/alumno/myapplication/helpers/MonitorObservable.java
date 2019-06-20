package com.example.alumno.myapplication.helpers;

import com.example.alumno.myapplication.models.Client;

import java.nio.channels.Channel;
import java.util.Observable;

public class MonitorObservable extends Observable {
    Client wachedValue;

    public MonitorObservable(Client o) {
        this.wachedValue = o;
    }

    public void setWachedValue(Client o) {
        if (o != null && o.getYeat_old() != this.wachedValue.getYeat_old()) {
            this.wachedValue = o;
            setChanged();
            notifyObservers(o);

        }else{
            setChanged();
            notifyObservers(o);
        }}
}


