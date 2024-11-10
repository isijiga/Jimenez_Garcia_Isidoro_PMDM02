package com.example.pmpm_tarea2_ijg;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmpm_tarea2_ijg.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
    private boolean show=true;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashscreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        splashscreen.setKeepOnScreenCondition(() -> show);
        Handler handler = new Handler();
        handler.postDelayed(() -> show=false,3000);


        toggle = new ActionBarDrawerToggle(this, binding.drawerlayout,binding.myToolbar ,R.string.open, R.string.close);
        binding.drawerlayout.addDrawerListener(toggle);
        setSupportActionBar(binding.myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*para quitar el nombre de la app*/
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle.syncState();
        RecyclerView recyclerView = findViewById(R.id.recycledView);

        Adaptador adapter = new Adaptador(Datos.getDatos());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.info){
        AlertDialog acerca = new AlertDialog.Builder(this).create();
        acerca.setMessage(getResources().getString(R.string.acercade_descripcion));
        acerca.show();
        return true ;}
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}