package com.example.tarea2_leydihuallpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playlist(View view){

        startActivity(new Intent(this, PlayList.class));
    }

    public void login(View view){

        startActivity(new Intent(this, PrincipalLogin.class));
    }
    public void salir(View view) {

        finish();
    }

}
