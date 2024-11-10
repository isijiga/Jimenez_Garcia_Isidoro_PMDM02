package com.example.pmpm_tarea2_ijg;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmpm_tarea2_ijg.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    private boolean show=true;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;
    private boolean spanish;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashscreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);


        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        configIdioma();
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




        binding.languageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean spanish) {
                if(spanish){
                    PreferencesHelper.saveLanguage(binding.getRoot().getContext(),true);
                    Toast.makeText(binding.getRoot().getContext(), "Guardado idioma Español", Toast.LENGTH_SHORT).show();
                    configIdioma();
                }
                if(!spanish){
                    PreferencesHelper.saveLanguage(binding.getRoot().getContext(),false);
                    Toast.makeText(binding.getRoot().getContext(), "Guardado idioma Ingles", Toast.LENGTH_SHORT).show();
                    configIdioma();
                }


            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.item_home){
                    /*cierra el menu lateral*/
                    binding.drawerlayout.closeDrawer(Gravity.LEFT);
                }
                if(item.getItemId()==R.id.item_setting){
                    binding.languageSwitch.setVisibility(View.VISIBLE);


                }
                return true;
            }
        });

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
        /*si se pulsa el bocadillo se abre/cierra el menu lateral. posteriormente en el
        * setNavigationItemSelectedListener se escucha que item se selecciona*/
        if(toggle.onOptionsItemSelected(item)){
        return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void configIdioma(){

        spanish = PreferencesHelper.getLanguage(binding.getRoot().getContext());
        Configuration config = new Configuration();
        res = getResources();
        binding.languageSwitch.setChecked(spanish);
        if(spanish){
            config.setLocale(new Locale("es"));
        }else{
            config.setLocale(new Locale("en"));
        }

        /*Actualiza la configuración del movil*/
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


    }

}