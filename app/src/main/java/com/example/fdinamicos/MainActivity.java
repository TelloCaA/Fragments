package com.example.fdinamicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//AGREGAR ESTA IMPLEMENTACIÓN PARA PODER TRABAJAR CON LA NAVEGACIÓN
public class MainActivity extends AppCompatActivity implements View.OnClickListener, fragment1.OnFragmentInteractionListener,fragment2.OnFragmentInteractionListener,fragment3.OnFragmentInteractionListener{

    Button btn1,btn2,btn3, btn4;
    private TextView texto1;
    private Typeface prueba;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARAMOS LOS ELEMENTO QUE VAMOS A OCUPAR, LOS 2 BOTONES Y EL FRAGMENT.
        fragment1 frag=new fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,frag);
        btn1=(Button)findViewById(R.id.btnfrag1);
        btn2=(Button)findViewById(R.id.btnfrag2);
        btn3=(Button)findViewById(R.id.button3);
        btn4 =(Button)findViewById(R.id.button4);

//ESTE APARTADO ES PARA EL BOTON DE ORDENAR LOS ANIMES/MANGAS POR ANO DE LANZAMIENT
        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        String cambio1="fuentes/Best.otf";
        this.prueba=Typeface.createFromAsset(getAssets(),cambio1);

        texto1=(TextView)findViewById(R.id.txt1);
        texto1.setTypeface(prueba);

    }
    @Override
    //ONCLICK PARA MANDA A LLAMAR LOS FRAGMENTS
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnfrag1:
                fragment1 frag=new fragment1();
                FragmentTransaction transition=getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.contenedor,frag);// NOMBRRE DEL ELEMENTO CONTENEDOR PARA ALMACENAR Y MOSTRAR EL FRAGMENT ELEGIDO..
                transition.commit();
                break;

            case R.id.btnfrag2:
                fragment2 frag1=new fragment2();
                FragmentTransaction transition1=getSupportFragmentManager().beginTransaction();
                transition1.replace(R.id.contenedor,frag1);
                transition1.commit();
                break;


            case R.id.btnfrag3:
                fragment3 frag3=new fragment3();
                FragmentTransaction transition3=getSupportFragmentManager().beginTransaction();
                transition3.replace(R.id.contenedor,frag3);
                transition3.commit();
                break;
/*
            case R.id.btnano:
                fragment4 frag4=new fragment4();
                FragmentTransaction transition4=getSupportFragmentManager().beginTransaction();
                transition4.replace(R.id.contenedor, frag4);
                transition4.commit();
                break;
                */
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}