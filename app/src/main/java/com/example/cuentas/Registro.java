package com.example.cuentas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_BD;

public class Registro extends AppCompatActivity {

    Button btnRegistrar;
    EditText txtNombre, txtApellido, txtCorreo, txtCorreo_C, txtContrasena, txtContrasena_C;

    SQLite_BD bd = new SQLite_BD(this, "BD_APP_ECONOMIA", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellidos);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtCorreo_C = (EditText) findViewById(R.id.txtCorreo_C);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        txtContrasena_C = (EditText) findViewById(R.id.txtContrasena_C);

        if(txtCorreo.equals(txtCorreo_C)) {
            if (txtContrasena.equals(txtContrasena_C)) {
                btnRegistrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bd.abrirBD();
                        bd.insertarRegistro(String.valueOf(txtNombre.getText()), String.valueOf(txtApellido.getText()), String.valueOf(txtCorreo.getText()), String.valueOf(txtContrasena.getText()));
                        bd.cerrarBD();

                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
            } else{
                Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Los correos no son iguales", Toast.LENGTH_LONG).show();
        }
    }
}