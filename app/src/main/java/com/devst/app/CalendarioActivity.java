package com.devst.app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class CalendarioActivity extends AppCompatActivity {

    private TextInputEditText etTitulo, etUbicacion;
    private TextView tvFechaHoraSeleccionada;
    private Button btnSeleccionarFechaHora, btnAgregarEvento;

    private Calendar fechaHoraEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        // CONFIGURAR TOOLBAR CON BOTÓN ATRÁS
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Habilitar botón de retroceso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Agregar Evento");
        }

        inicializarVistas();
        configurarEventos();

        // Inicializar con la fecha y hora actual
        fechaHoraEvento = Calendar.getInstance();
        actualizarTextoFechaHora();
    }

    // MÉTODO PARA MANEJAR EL BOTÓN ATRÁS
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Regresar a la actividad anterior
        return true;
    }

    private void inicializarVistas() {
        etTitulo = findViewById(R.id.etTitulo);
        etUbicacion = findViewById(R.id.etUbicacion);
        tvFechaHoraSeleccionada = findViewById(R.id.tvFechaHoraSeleccionada);
        btnSeleccionarFechaHora = findViewById(R.id.btnSeleccionarFechaHora);
        btnAgregarEvento = findViewById(R.id.btnAgregarEvento);
    }

    private void configurarEventos() {
        btnSeleccionarFechaHora.setOnClickListener(v -> mostrarSelectorFechaHora());
        btnAgregarEvento.setOnClickListener(v -> agregarEventoAlCalendario());
    }

    private void mostrarSelectorFechaHora() {
        final Calendar calendarioActual = Calendar.getInstance();

        // Primero seleccionar fecha
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    // Luego seleccionar hora
                    TimePickerDialog timePickerDialog = new TimePickerDialog(
                            this,
                            (view1, hourOfDay, minute) -> {
                                fechaHoraEvento.set(year, month, dayOfMonth, hourOfDay, minute);
                                actualizarTextoFechaHora();
                            },
                            calendarioActual.get(Calendar.HOUR_OF_DAY),
                            calendarioActual.get(Calendar.MINUTE),
                            true
                    );
                    timePickerDialog.show();
                },
                calendarioActual.get(Calendar.YEAR),
                calendarioActual.get(Calendar.MONTH),
                calendarioActual.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void actualizarTextoFechaHora() {
        String fechaHora = android.text.format.DateFormat.format(
                "dd/MM/yyyy HH:mm", fechaHoraEvento
        ).toString();
        tvFechaHoraSeleccionada.setText(fechaHora);
    }

    private void agregarEventoAlCalendario() {
        String titulo = etTitulo.getText().toString().trim();
        String ubicacion = etUbicacion.getText().toString().trim();

        if (titulo.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un título", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);

            // Información básica del evento
            intent.putExtra(CalendarContract.Events.TITLE, titulo);
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, ubicacion);

            // Configurar fecha y hora de inicio
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    fechaHoraEvento.getTimeInMillis());

            // Configurar fecha y hora de fin (1 hora después)
            Calendar finEvento = (Calendar) fechaHoraEvento.clone();
            finEvento.add(Calendar.HOUR, 1);
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    finEvento.getTimeInMillis());

            // Configurar alarma por defecto
            intent.putExtra(CalendarContract.Events.HAS_ALARM, true);

            // Opciones adicionales
            intent.putExtra(CalendarContract.Events.DESCRIPTION,
                    "Evento creado desde MineApp");
            intent.putExtra(CalendarContract.Events.AVAILABILITY,
                    CalendarContract.Events.AVAILABILITY_BUSY);

            // Iniciar la actividad del calendario
            startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this, "Error al abrir el calendario: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}