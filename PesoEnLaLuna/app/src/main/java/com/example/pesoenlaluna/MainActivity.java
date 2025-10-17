package com.example.pesoenlaluna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pesoenlaluna.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Variable para el objeto de Data Binding. Su nombre se genera a partir del XML.
    private ActivityMainBinding binding;

    // Constante para la relación de gravedad Tierra-Luna. Es 'static final' por convención.
    private static final double MOON_GRAVITY_RATIO = 0.166;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // En lugar de 'setContentView(R.layout.activity_main)', usamos DataBindingUtil.
        // Esto crea la conexión entre el XML y el código Java.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Asignamos la instancia de esta clase a la variable 'mainActivity' declarada en el XML.
        binding.setMainActivity(this);
    }

    /**
     * Este método se llama directamente desde el XML cuando se hace clic en el botón.
     * La anotación 'public' es necesaria para que Data Binding pueda acceder a él.
     */
    public void calculateMoonWeight() {
        // Obtenemos el texto que el usuario escribió en el EditText.
        String weightOnEarthString = binding.editTextWeight.getText().toString();

        // Verificamos si el usuario realmente escribió algo.
        if (weightOnEarthString.isEmpty()) {
            // Si el campo está vacío, mostramos un mensaje de advertencia (Toast).
            Toast.makeText(this, "Por favor, introduce un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Convertimos el texto a un número (double).
            double weightOnEarth = Double.parseDouble(weightOnEarthString);

            // Realizamos el cálculo.
            double weightOnMoon = weightOnEarth * MOON_GRAVITY_RATIO;

            // Usamos el recurso 'result_text' para formatear y mostrar el resultado en el TextView.
            binding.textViewResult.setText(getString(R.string.result_text, weightOnMoon));

        } catch (NumberFormatException e) {
            // Si el texto no se puede convertir a número, mostramos un error.
            Toast.makeText(this, "Entrada inválida. Por favor, introduce un número.", Toast.LENGTH_SHORT).show();
        }
    }
}