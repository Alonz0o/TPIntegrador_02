package com.example.tpintegrador_02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText vetDolar, vetEuro;
    private RadioButton vrbDolar, vrbEuro;
    private Button vbtnConvertir;
    private TextView vtvResultado;

    private MainViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializarVista();
    }

    private void inicializarVista(){
        vetDolar = findViewById(R.id.edtDolares);
        vetEuro = findViewById(R.id.edtEuros);
        vrbDolar = findViewById(R.id.rbEuroAdolar);
        vrbEuro = findViewById(R.id.rbDolarAeuro);
        vbtnConvertir = findViewById(R.id.btnConvertir);
        vtvResultado = findViewById(R.id.tvResultado);

        vrbEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarDolar();
                vetEuro.setEnabled(false);
                vetDolar.setEnabled(true);
                vetEuro.setText("");
                vetDolar.setFocusable(true);
                vtvResultado.setText("");
            }
        });

        vrbDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarEuro();
                vetDolar.setEnabled(false);
                vetEuro.setEnabled(true);
                vetDolar.setText("");
                vetEuro.setFocusable(true);
                vtvResultado.setText("");
            }
        });

        vbtnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vrbDolar.isChecked()){
                    vm.convertirMoneda(vetEuro.getText().toString(),"dolar");
                }
                else{
                    vm.convertirMoneda(vetDolar.getText().toString(),"euro");
                }
            }
        });
    }
}
