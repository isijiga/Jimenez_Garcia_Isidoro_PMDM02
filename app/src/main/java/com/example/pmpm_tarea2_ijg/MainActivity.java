package com.example.pmpm_tarea2_ijg;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.pmpm_tarea2_ijg.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private boolean show = true;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;


    /**
     * Metodo inicial que se lanza al crear la actividad principal
     *
     * @param savedInstanceState estado de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashscreen = SplashScreen.installSplashScreen(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*carga el ultimo idioma del usuario*/
        configIdioma();

        /*configuracion de splash donde se establecen 3segundos */
        splashscreen.setKeepOnScreenCondition(() -> show);
        Handler handler = new Handler();
        handler.postDelayed(() -> show = false, 3000);

        /*barra de navegacion lateral*/
        toggle = new ActionBarDrawerToggle(this, binding.drawerlayout, binding.myToolbar, R.string.open, R.string.close);
        binding.drawerlayout.addDrawerListener(toggle);
        setSupportActionBar(binding.myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*para quitar el nombre de la app*/
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle.syncState();

        /*carga de datos al adaptador*/
        Adaptador adapter = new Adaptador(Datos.getDatos());
        binding.recycledView.setAdapter(adapter);
        binding.recycledView.setLayoutManager(new LinearLayoutManager(this));


        /*visualizacion del Snackbar de bienvenida*/
        showSnackbar(binding.recycledView);

        super.onCreate(savedInstanceState);

        /*asignacion al switch de  listener para saber si se activa o no el idioma Español  */
        binding.languageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean spanish) {
                if (spanish) {
                    PreferencesHelper.saveLanguage(binding.getRoot().getContext(), true);
                    Toast.makeText(binding.getRoot().getContext(), "Guardado idioma Español", Toast.LENGTH_SHORT).show();
                    configIdioma();
                }
                if (!spanish) {
                    PreferencesHelper.saveLanguage(binding.getRoot().getContext(), false);
                    Toast.makeText(binding.getRoot().getContext(), "Guardado idioma Ingles", Toast.LENGTH_SHORT).show();
                    configIdioma();
                }
            }
        });

        /*asignacion al navigationView de un listener para saber que boton se pulsa  */
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_home) {
                    /*cierra/abre el menu lateral*/
                    binding.drawerlayout.closeDrawer(GravityCompat.START);
                }
                /*si se pulsa setting se hace visible el switch para cambiar el idioma*/
                if (item.getItemId() == R.id.item_setting) {
                    binding.languageSwitch.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });

    }

    /**
     * Metodo para inflar el menu de 'acerca de'
     *
     * @param menu menu a inflar
     * @return true si se ha inflado el menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Metodo que se ejecuta cuando se pulsa un item del menu
     *
     * @param item item pulsado. Dos opciones: o el drawner lateral o el icono para el 'acerca de'
     * @return true si se ha pulsado alguna opcion
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*si se ha pulsado el icono de 'acerca de' se muestra el dialogo con la descripcion*/
        if (item.getItemId() == R.id.info) {
            AlertDialog acerca = new AlertDialog.Builder(this).create();
            acerca.setMessage(getResources().getString(R.string.acercade_descripcion));
            acerca.show();
            return true;
        }
        /*si se pulsa el bocadillo se abre/cierra el menu lateral. posteriormente en el
         * setNavigationItemSelectedListener se escucha que item se selecciona dentro del submenu*/
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo que configura el idioma de la aplicación segun el switch
     */
    public void configIdioma() {
        boolean languagePref;
        Configuration config = new Configuration();
        /*obtengo el idioma guardado en las preferencias*/
        languagePref = PreferencesHelper.getLanguage(binding.getRoot().getContext());
        /*para que el switch quede en el idioma guardado*/
        binding.languageSwitch.setChecked(languagePref);
        if (languagePref) {
            config.setLocale(new Locale("es"));
        } else {
            config.setLocale(new Locale("en"));
        }
        /*Actualiza la configuración del movil para no tener que reiniciar la app*/
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * Muestra una notificación tipo SnackBar al inicio de visualizar los personajes
     *
     * @param view vista que contiene el snackbar
     */
    public void showSnackbar(View view) {
        Snackbar  snackbar = Snackbar.make(view, getResources().getString(R.string.snackbar), Snackbar.LENGTH_LONG);
        snackbar.setDuration(5000);
        snackbar.show();

    }

}