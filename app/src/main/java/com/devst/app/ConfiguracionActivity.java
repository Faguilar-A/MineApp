package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ConfiguracionActivity extends AppCompatActivity {

    private Button btnWifiSettings, btnBluetoothSettings, btnWirelessSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        // CONFIGURAR TOOLBAR CON BOTÓN ATRÁS
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Habilitar botón de retroceso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Configuración");
        }

        // Inicializar botones
        inicializarBotones();

        // Configurar listeners
        configurarEventos();
    }

    // MÉTODO PARA MANEJAR EL BOTÓN ATRÁS
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Regresar a la actividad anterior
        return true;
    }

    private void inicializarBotones() {
        btnBluetoothSettings = findViewById(R.id.btnBluetoothSettings);
        btnWifiSettings = findViewById(R.id.btnWifiSettings);
        btnWirelessSettings = findViewById(R.id.btnWirelessSettings);
    }

    private void configurarEventos() {
        // Botón para configuración Wi-Fi
        btnWifiSettings.setOnClickListener(v -> abrirConfiguracionWifi());

        // Botón para configuración Bluetooth
        btnBluetoothSettings.setOnClickListener(v -> abrirConfiguracionBluetooth());

        // Botón para configuración inalámbrica general
        btnWirelessSettings.setOnClickListener(v -> abrirConfiguracionInalambrica());
    }

    private void abrirConfiguracionWifi() {
        try {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "Abriendo configuración Wi-Fi", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir configuración Wi-Fi", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void abrirConfiguracionBluetooth() {
        try {
            Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "Abriendo configuración Bluetooth", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir configuración Bluetooth", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void abrirConfiguracionInalambrica() {
        try {
            Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "Abriendo configuración inalámbrica", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Fallback para dispositivos más nuevos
            try {
                Intent intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
                startActivity(intent);
                Toast.makeText(this, "Abriendo configuración de red", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this, "Error al abrir configuración inalámbrica", Toast.LENGTH_SHORT).show();
                ex.printStackTrace();
            }
        }
    }
}