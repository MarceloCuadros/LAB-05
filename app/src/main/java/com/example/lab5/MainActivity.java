package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Aves> avesss;

    private void inicializarDatos(){
        avesss = new ArrayList<>();
        avesss.add(new Aves("Ganso","15 Años","Es un ave acuatica",R.drawable.ganso));
        avesss.add(new Aves("Urraca","3 Años","Tiene el cuerpo blanco y negro",R.drawable.urraca));
        avesss.add(new Aves("Condor","52 Años","Representa la fuerza",R.drawable.condor));
        avesss.add(new Aves("Lechuza","10 Años","Es carnivora y nocturna",R.drawable.lechuza));
        avesss.add(new Aves("Golondrina","4 Años","Es un ave de pequeño tamaño",R.drawable.golondrina));
        avesss.add(new Aves("Loro","30 Años","Tiene un pico curvado",R.drawable.loro));
        avesss.add(new Aves("Koel","5 Años","Es un cuco grande",R.drawable.koel));
        avesss.add(new Aves("Azulejo","7 Años","Viene de la familia turdidos",R.drawable.azulejo));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        inicializarDatos();

        RVAdapter rvAdapter = new RVAdapter(avesss,getApplicationContext());
        recyclerView.setAdapter(rvAdapter);
    }
}