package com.example.buscarparejas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;
    ImageButton ib4;
    ImageButton ib5;
    ImageButton ib6;
    int contador;
    int img;
    ArrayList<Integer> cartas = new ArrayList<Integer>();
    ArrayList<ImageButton> pareja = new ArrayList<ImageButton>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib1 = findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);
        ib3 = findViewById(R.id.ib3);
        ib4 = findViewById(R.id.ib4);
        ib5 = findViewById(R.id.ib5);
        ib6 = findViewById(R.id.ib6);
        contador = 0;
        empezar();
    }

    private void empezar() {
        int img1 = R.drawable.luispuyons;
        int img2 = R.drawable.luiscani;
        int img3 = R.drawable.luismaria;

        cartas.add(img1);
        cartas.add(img1);
        cartas.add(img2);
        cartas.add(img2);
        cartas.add(img3);
        cartas.add(img3);
        Collections.shuffle(cartas);
    }

    public void mostrar(View view) {
        ImageButton ib = findViewById(view.getId());

        if (ib.getId() == ib1.getId()){
            ib1.setImageResource(cartas.get(0));
            pareja.add(ib1);
            contador++;
        }
        if (ib.getId() == ib2.getId()){
            ib2.setImageResource(cartas.get(1));
            pareja.add(ib2);
            contador++;
        }
        if (ib.getId() == ib3.getId()){
            ib3.setImageResource(cartas.get(2));
            pareja.add(ib3);
            contador++;
        }
        if (ib.getId() == ib4.getId()){
            ib4.setImageResource(cartas.get(3));
            pareja.add(ib4);
            contador++;
        }
        if (ib.getId() == ib5.getId()){
            ib5.setImageResource(cartas.get(4));
            pareja.add(ib5);
            contador++;
        }
        if (ib.getId() == ib6.getId()){
            ib6.setImageResource(cartas.get(5));
            pareja.add(ib6);
            contador++;
        }
        if (contador % 2 == 0){
            encontrarPareja(pareja);
        }
    }

    private void encontrarPareja(ArrayList<ImageButton> pareja){
        if (pareja.get(0).getBackground() != pareja.get(1).getBackground()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pareja.get(0).setImageResource(R.drawable.luisaplaudiendo);
            pareja.get(1).setImageResource(R.drawable.luisaplaudiendo);

        }
        contador = 0;
    }

    public void reiniciar(View view) {
        img = R.drawable.luisaplaudiendo;
        ib1.setImageResource(img);
        ib2.setImageResource(img);
        ib3.setImageResource(img);
        ib4.setImageResource(img);
        ib5.setImageResource(img);
        ib6.setImageResource(img);
        contador = 0;
        empezar();
    }
}