package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNombre, tvEmail, tvCarrera, tvSemestre;
    private Button btnEditarPerfil, btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil);

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Inicializar vistas
        inicializarVistas();

        // Configurar datos del perfil
        configurarDatosPerfil();

        // Configurar eventos
        configurarEventos();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void inicializarVistas() {
        tvNombre = findViewById(R.id.tvNombre);
        tvEmail = findViewById(R.id.tvEmail);
        tvCarrera = findViewById(R.id.tvCarrera);
        tvSemestre = findViewById(R.id.tvNombre);
        btnEditarPerfil = findViewById(R.id.btnEditarPerfil);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
    }

    private void configurarDatosPerfil() {
        // Obtener email del intent
        String emailUsuario = getIntent().getStringExtra("email_usuario");
        if (emailUsuario != null) {
            tvEmail.setText(emailUsuario);
        }

        // Datos de ejemplo para el perfil universitario
        tvNombre.setText("Aguilar Álvarez");
        tvCarrera.setText("Analista Programador");
        tvSemestre.setText("4to Semestre");
    }

    private void configurarEventos() {
        btnEditarPerfil.setOnClickListener(v -> {
            // Crear intent para devolver datos editados
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nombre_editado", "Juan Pérez (Editado)");
            setResult(RESULT_OK, resultIntent);
            finish();

            Toast.makeText(this, "Perfil editado exitosamente", Toast.LENGTH_SHORT).show();
        });

        btnCerrarSesion.setOnClickListener(v -> {
            // Cerrar sesión y volver al login
            Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
        });
    }
}