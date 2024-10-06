package com.example.cl1_cibertec;

import android.os.Bundle;
import android.util.Log;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdaptadorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private ArrayList<datoscardModel> arrayList = new ArrayList<>();

    private static final String TAG = "ListaAdaptadorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_adaptador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lista_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(TAG, "onCreate: Actividad creada");

        showToolbar(getResources().getString(R.string.toolbar_title_lista_adaptador),true);

        recyclerView=findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListaAdaptadorActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList.add(new datoscardModel("Iron Man",R.drawable.pizza1,3));
        arrayList.add(new datoscardModel("Spider Man ",R.drawable.perfil1,2));
        CardAdapter cardAdapter = new CardAdapter(this,arrayList);
        recyclerView.setAdapter(cardAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Mensaje cuando la actividad empieza
        Log.d(TAG, "onStart: La actividad está visible y a punto de empezar");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Mensaje cuando la actividad se detiene
        Log.d(TAG, "onStop: La actividad ha sido detenida");
    }

    public void showToolbar(String title, boolean upButton) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}