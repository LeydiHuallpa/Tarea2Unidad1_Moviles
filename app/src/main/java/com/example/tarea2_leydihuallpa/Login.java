package com.example.tarea2_leydihuallpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);

        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignUp.class));
                finish();
            }
        });

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Bienvendio Usuario:", Toast.LENGTH_SHORT).show();
                String usuario = ((EditText) findViewById(R.id.edtUsuario)).getText().toString();
                String password = ((EditText) findViewById(R.id.et_contrasena)).getText().toString();
                if (usuario.equals("Alumno") && password.equals("Android"))
                {
                    Intent nuevoform = new Intent(Login.this, Permisos.class);
                    startActivity(nuevoform);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "USUARIO INCORRECTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registro(View view) {

        startActivity(new Intent(this, SignUp.class));
    }
}
