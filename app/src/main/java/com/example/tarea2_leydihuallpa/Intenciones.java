package com.example.tarea2_leydihuallpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.URLEncoder;

public class Intenciones extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenciones);
    }

    public void maps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-18.0053523,-70.237483,17"));
        startActivity(intent);
    }

    public void foto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void permisos(View view) {
        startActivity(new Intent(this, Permisos.class));

    }
}