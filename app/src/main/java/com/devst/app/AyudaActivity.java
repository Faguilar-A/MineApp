package com.devst.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AyudaActivity extends AppCompatActivity {

    private Button btnComandosVoz, btnTutorialCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Ayuda y Guía");
        }

        // Inicializar vistas
        inicializarVistas();

        // Configurar eventos
        configurarEventos();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void inicializarVistas() {
        btnComandosVoz = findViewById(R.id.btnComandosVoz);
        btnTutorialCompleto = findViewById(R.id.btnTutorialCompleto);
    }

    private void configurarEventos() {
        btnComandosVoz.setOnClickListener(v -> mostrarComandosVoz());
        btnTutorialCompleto.setOnClickListener(v -> iniciarTutorial());
    }

    private void mostrarComandosVoz() {
        // Simulación de comandos de voz
        Toast.makeText(this, "Funcionalidad de comandos de voz en desarrollo", Toast.LENGTH_SHORT).show();

        // Aquí podrías abrir un diálogo o nueva actividad con los comandos
        /*
        Ejemplo de comandos:
        - "Abrir perfil" → Navega a PerfilActivity
        - "Encender linterna" → Activa la linterna
        - "Agregar evento" → Abre CalendarioActivity
        - "Configurar wifi" → Abre configuración Wi-Fi
        */
    }

    private void iniciarTutorial() {
        // Simulación de tutorial
        Toast.makeText(this, "Tutorial interactivo iniciado", Toast.LENGTH_SHORT).show();

        // Aquí podrías implementar un tutorial paso a paso
        /*
        Pasos del tutorial:
        1. Explicar función principal
        2. Mostrar cómo usar la linterna
        3. Enseñar a agregar eventos al calendario
        4. Mostrar configuración del dispositivo
        5. Explicar compartir contenido
        */
    }
}