package com.example.alumno.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.Client;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    Button btnEdad;
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    Client clientObjetc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientObjetc=new Client();
        clientObjetc.setYeat_old(19);

        monitorObservable=new MonitorObservable(clientObjetc);
        observerBind=new ObserverBind();
        observerBind.setCallback(new Callback(){
            //todo lo que yo quiera
            public void dothis(Observable o ,Object x){
                Log.v("bichito", "xxx");
               Toast.makeText( MainActivity.this,  "hola mundo", Toast.LENGTH_SHORT).show();
                btnEdad.setBackgroundColor(Color.parseColor("red"));
            }
        });
        monitorObservable.addObserver(observerBind);

        btnEdad=(Button)findViewById(R.id.btnEdad);
        btnEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientObjetc.setYeat_old(clientObjetc.getYeat_old()+1);
                monitorObservable.setWachedValue(clientObjetc);



            }
        });

    }
}
