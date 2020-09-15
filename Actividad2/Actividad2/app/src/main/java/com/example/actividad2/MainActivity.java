package com.example.actividad2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.actividad2.R.id.btn_calcular;
import static com.example.actividad2.R.id.edt_pesion;
import static com.example.actividad2.R.id.edt_salar_total;
import static com.example.actividad2.R.id.edt_salud;
import static com.example.actividad2.R.id.edt_valor2;
import static com.example.actividad2.R.id.edt_valor3;
import static com.example.actividad2.R.id.edt_valor4;
import static com.example.actividad2.R.id.pension;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Valor1, Valor2, Valor3, Valor4, pension, salud, salario;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Valor3 = findViewById(R.id.edt_valor3);
        Valor1 = findViewById(R.id.edt_valor1);
        Valor2 = findViewById(R.id.edt_valor2);
        Valor4 = findViewById(R.id.edt_valor4);
        pension = findViewById(R.id.edt_pesion);
        salud = findViewById(R.id.edt_salud);
        salario = findViewById(R.id.edt_salar_total);

        calcular = findViewById(R.id.btn_calcular);
        calcular.setOnClickListener(this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        double var_salario = 877000;

        if (id == R.id.salario_minimo) {
            Valor2.setText(String.valueOf(var_salario));
        }


        if (id == R.id.Limp_datos) {
            Valor1.setText("");
            Valor2.setText("");
            Valor3.setText("");
            Valor4.setText("");
            pension.setText("");
            salud.setText("");
            salario.setText("");


        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {

        double valor2 = Double.parseDouble(Valor2.getText().toString());
        double valor3 = Double.parseDouble(Valor3.getText().toString());
        double valor4 = Double.parseDouble(Valor4.getText().toString());

        switch (v.getId()) {
            case R.id.btn_calcular:
                if (TextUtils.isEmpty(Valor2.getText().toString()) || TextUtils.isEmpty(Valor3.getText().toString()) || TextUtils.isEmpty(Valor4.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();
                } else {
                    double cal_pension = valor2 * 0.04;
                    pension.setText(String.valueOf(cal_pension));

                    double cal_salud = valor2 * 0.04;
                    salud.setText(String.valueOf(cal_salud));

                    double cal_salario = (valor2 - cal_pension - cal_salud)+ (valor3*valor4);
                    salario.setText(String.valueOf(cal_salario));
                }
        }
    }



}