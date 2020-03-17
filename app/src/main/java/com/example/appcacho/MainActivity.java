package com.example.appcacho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int idImg []  = {R.drawable.and_cacho, R.drawable.and_uno, R.drawable.and_dos, R.drawable.and_tres, R.drawable.and_cuatro, R.drawable.and_cinco, R.drawable.and_seis};
    boolean sw = false;

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    ImageButton btn5;

    Button btnLanzar;
    Button btnNuevo;

    TextView txtPuntos;
    TextView txtNumeros;

    int uno, dos, tres, cuatro, cinco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (ImageButton)findViewById(R.id.uno);
        btn2 = (ImageButton)findViewById(R.id.dos);
        btn3 = (ImageButton)findViewById(R.id.tres);
        btn4 = (ImageButton)findViewById(R.id.cuatro);
        btn5 = (ImageButton)findViewById(R.id.cinco);

        btnLanzar = (Button)findViewById(R.id.button);
        btnNuevo = (Button)findViewById(R.id.button2);

        txtNumeros = (TextView)findViewById(R.id.txtnumeros);
        txtPuntos = (TextView)findViewById(R.id.txtpuntos);

        btnNuevo.setEnabled(false);


    }

    public void lanzar(View view){

        uno = numRandom();
        dos = numRandom();
        tres = numRandom();
        cuatro = numRandom();
        cinco = numRandom();


        btn1.setImageResource(idImg[uno]);
        btn2.setImageResource(idImg[dos]);
        btn3.setImageResource(idImg[tres]);
        btn4.setImageResource(idImg[cuatro]);
        btn5.setImageResource(idImg[cinco]);

        sw  = true;
        btnLanzar.setEnabled(false);
        btnNuevo.setEnabled(true);

        puntuacion(uno,dos,tres,cuatro,cinco);
    }

    public void vuelta(View view){
        if(sw == true){
             if(view.getId() == R.id.uno){
                uno = asignar(btn1, uno);


             }else{
                 if (view.getId() == R.id.dos){
                     dos = asignar(btn2, dos);


                 }else{
                     if (view.getId() == R.id.tres){
                         tres = asignar(btn3, tres);

                     }else{
                         if (view.getId() == R.id.cuatro){
                             cuatro = asignar(btn4, cuatro);

                         }else{
                             if (view.getId() == R.id.cinco){
                                 cinco = asignar(btn5, cinco);

                             }
                         }
                     }

                 }
             }



            sw = false;
        }
        txtPuntos.setText("");
        puntuacion(uno,dos,tres,cuatro,cinco);
    }



    public int numRandom(){

        int r = (int)(Math.random()*6+1);

        return r;
    }

    public void Nuevo (View view){
        sw = false;

        btn1.setImageResource(idImg[0]);
        btn2.setImageResource(idImg[0]);
        btn3.setImageResource(idImg[0]);
        btn4.setImageResource(idImg[0]);
        btn5.setImageResource(idImg[0]);

        btnLanzar.setEnabled(true);
        btnNuevo.setEnabled(false);

        txtPuntos.setText("");
        txtNumeros.setText("");
    }

    public int asignar(ImageButton btn, int a){
        switch (a){
            case 1: btn.setImageResource(idImg[6]);
                a = 6;
                break;
            case 2: btn.setImageResource(idImg[5]);
                a = 5;
                break;
            case 3: btn.setImageResource(idImg[4]);
                a = 4;
                break;
            case 4: btn.setImageResource(idImg[3]);
                a = 3;
                break;
            case 5: btn.setImageResource(idImg[2]);
                a = 2;
                break;
            case 6: btn.setImageResource(idImg[1]);
                a = 1;
                break;
        }
        return a;
    }

    public void puntuacion(int a, int b, int c, int d, int e){
        String suma = a+""+b+""+c+""+d+""+e+"";
        String suma2 = a+" "+b+" "+c+" "+d+" "+e+" ";
        if (suma.equals("12345") || suma.equals("23456") || suma.equals("13456")){
            txtPuntos.setText("ESCALERA");
        }else{
            if((a==b && c==d && c==e) || (a==c && b==d && b==e) || (a==d && c==b && c==e) || (a==e && c==d && c==b) || (b==c && a==d && a==e) || (b==d && a==c && a==e) || (b==e && a==d && a==c) || (c==d && a==b && a==e) || (c==e && a==d && a==b) || (d==e && a==b && a==c))  {
                txtPuntos.setText("FULL");
                txtNumeros.setTextColor(Color.parseColor("#4CAF50"));
                txtPuntos.setTextColor(Color.parseColor("#4CAF50"));
            }else{
                if((a==b && a==c && a==d) || (a==b && a==c && a==e) || (a==b && a==e && a==d) || (a==e && a==c && a==d) || (e==b && e==c && e==d)){
                    txtPuntos.setText("POKER");
                    txtNumeros.setTextColor(Color.parseColor("#4CAF50"));
                    txtPuntos.setTextColor(Color.parseColor("#4CAF50"));

                }else{
                    if(a==b && a==c && a==d && a ==e){
                        txtPuntos.setText("GRANDE");
                        txtNumeros.setTextColor(Color.parseColor("#4CAF50"));
                        txtPuntos.setTextColor(Color.parseColor("#4CAF50"));
                    }else{
                        txtPuntos.setText("SIN PUNTOS");
                        txtNumeros.setTextColor(Color.parseColor("#f44336"));
                        txtPuntos.setTextColor(Color.parseColor("#f44336"));
                    }
                }
            }
        }
        txtNumeros.setText(suma2);
    }

}
