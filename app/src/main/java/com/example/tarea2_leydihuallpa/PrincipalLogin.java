package com.example.tarea2_leydihuallpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalLogin extends AppCompatActivity {

    Button ir_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_login);

        ir_login=findViewById(R.id.ir_login);
        ir_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalLogin.this,Login.class));
                finish();
            }
        });
    }
}
