package com.example.cl1_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        Log.d("MainActivity", "onCreate: Actividad creada");


        TextInputEditText usuario = findViewById(R.id.username);
        TextInputEditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo =usuario.getText().toString().trim();
                String contrasena = password.getText().toString().trim();

                if(validarIngreso(correo,contrasena)){
                    goListaDeliverys();
                }else{
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public boolean validarIngreso(String correo, String contrasena){
        return correo.equals("wal.gustal@gmail.com") && contrasena.equals("1234");
    }

    public void goListaDeliverys(){
        Intent intent = new Intent(this, ListaAdaptadorActivity.class);
        startActivity(intent);
    }
}