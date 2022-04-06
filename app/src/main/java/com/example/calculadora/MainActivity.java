package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonS;
    private Button buttonI;
    private Button buttonC;
    private Button buttonR;
    private Button buttonD;
    private Button buttonM;
    private Button buttonP;
    private Integer resultado;
    private CheckBox desabilitar;
    private RadioButton suma;
    private RadioButton resta;
    private RadioButton multiplicacion;
    private RadioButton division;
    private Float aux;
    private RadioGroup grupo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = 0;
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);
        button0 = findViewById(R.id.b0);
        buttonS = findViewById(R.id.bSuma);
        buttonI = findViewById(R.id.bIgual);
        buttonC = findViewById(R.id.bc);

        buttonD = findViewById(R.id.bEn);
        buttonR = findViewById(R.id.bRes);
        buttonM = findViewById(R.id.bPor);
        buttonP = findViewById(R.id.bp);

        grupo = findViewById(R.id.grupo);
        textView = findViewById(R.id.resultado);

        desabilitar = findViewById(R.id.desabilitar);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multiplicacion = findViewById(R.id.multiplicacion);
        division = findViewById(R.id.division);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonS.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonR.setOnClickListener(this);
        buttonM.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonP.setOnClickListener(this);


//        boolean desa =desabilitar.isChecked() ;
//        if (desa){
//
//        }


        if (suma.isSelected()) {
            buttonS.setEnabled(false);
        } else {
            buttonS.setEnabled(true);
        }

        desabilitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof CheckBox) {
                    CheckBox c = (CheckBox) view;
                    if (grupo.getVisibility() == View.VISIBLE) {
                        grupo.setVisibility(View.GONE);

                        suma.setChecked(false);
                        resta.setChecked(false);
                        multiplicacion.setChecked(false);
                        division.setChecked(false);

                        buttonS.setEnabled(true);
                        buttonR.setEnabled(true);
                        buttonM.setEnabled(true);
                        buttonD.setEnabled(true);
                    } else {
                        grupo.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        RadioButton r = (RadioButton) view;
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.suma:
                if (buttonS.isEnabled()) {
                    buttonS.setEnabled(false);
                    buttonR.setEnabled(true);
                    buttonM.setEnabled(true);
                    buttonD.setEnabled(true);
                }

                break;
            case R.id.resta:
                if (buttonR.isEnabled()) {
                    buttonS.setEnabled(true);
                    buttonR.setEnabled(false);
                    buttonM.setEnabled(true);
                    buttonD.setEnabled(true);
                }

                break;
            case R.id.multiplicacion:
                if (buttonM.isEnabled()) {
                    buttonS.setEnabled(true);
                    buttonR.setEnabled(true);
                    buttonM.setEnabled(false);
                    buttonD.setEnabled(true);
                }
                break;
            case R.id.division:
                if (buttonD.isEnabled()) {
                    buttonS.setEnabled(true);
                    buttonR.setEnabled(true);
                    buttonM.setEnabled(true);
                    buttonD.setEnabled(false);
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;

            if (b == buttonI) {
                // textView.setText(String.valueOf(resultado + Integer.parseInt(textView.getText().toString())));
                textView.setText(String.valueOf(resultado));

            } else if (b == buttonS) {
                if (resultado == 0) {
                    resultado = resultado + Integer.parseInt(textView.getText().toString());
                    textView.setText("0");
                } else {
                    resultado = resultado + Integer.parseInt(textView.getText().toString());
                    textView.setText(String.valueOf(resultado));
                }


            } else if (b == buttonR) {
//                resultado = resultado -Integer.parseInt(textView.getText().toString());
//                textView.setText("0");
                if (resultado == 0) {
                    resultado = resultado - Integer.parseInt(textView.getText().toString());
                    textView.setText("0");
                } else {
                    resultado = resultado - Integer.parseInt(textView.getText().toString());
                    textView.setText(String.valueOf(resultado));
                }
            } else if (b == buttonM) {
//                resultado = resultado *Integer.parseInt(textView.getText().toString());
//                textView.setText("0");
                if (resultado == 0) {
                    resultado = resultado * Integer.parseInt(textView.getText().toString());
                    textView.setText("0");
                } else {
                    resultado = resultado * Integer.parseInt(textView.getText().toString());
                    textView.setText(String.valueOf(resultado));
                }
            } else if (b == buttonD) {
//                resultado = resultado /Integer.parseInt(textView.getText().toString());
//                textView.setText("0");
                if (resultado == 0) {
                    resultado = resultado / Integer.parseInt(textView.getText().toString());
                    textView.setText("0");
                } else {
                    resultado = resultado / Integer.parseInt(textView.getText().toString());
                    textView.setText(String.valueOf(resultado));
                }
            } else if (b == buttonP) {
//                textView.setText(".");
                //pasar a float o a dobble
            } else if (b == buttonC) {
                textView.setText("0");
                resultado = 0;
            } else {
                if (textView.getText().equals("0"))
                    textView.setText(b.getText().toString());
                else
                    textView.setText(b.getTag().toString());
            }

        }


    }
}