package com.example.costedeviaje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etDistance, etConsumption, etPrice;
    private Button btnCalculate;
    private TextView tvResult;
    private ImageView headerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerImage   = findViewById(R.id.headerImage);
        etDistance    = findViewById(R.id.etDistance);
        etConsumption = findViewById(R.id.etConsumption);
        etPrice       = findViewById(R.id.etPrice);
        btnCalculate  = findViewById(R.id.btnCalculate);
        tvResult      = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                calcularCoste();
            }
        });
    }

    private void calcularCoste() {
        etDistance.setError(null);
        etConsumption.setError(null);
        etPrice.setError(null);

        String sDist  = etDistance.getText().toString().trim();
        String sCons  = etConsumption.getText().toString().trim();
        String sPrice = etPrice.getText().toString().trim();

        boolean hayError = false;
        if (sDist.isEmpty())  { etDistance.setError(getString(R.string.error_empty)); hayError = true; }
        if (sCons.isEmpty())  { etConsumption.setError(getString(R.string.error_empty)); hayError = true; }
        if (sPrice.isEmpty()) { etPrice.setError(getString(R.string.error_empty)); hayError = true; }
        if (hayError) return;

        try {
            double distanciaKm = Double.parseDouble(sDist);
            double consumoL100 = Double.parseDouble(sCons);
            double precioL     = Double.parseDouble(sPrice);

            if (distanciaKm <= 0) { etDistance.setError(getString(R.string.error_non_positive)); return; }
            if (consumoL100 <= 0) { etConsumption.setError(getString(R.string.error_non_positive)); return; }
            if (precioL <= 0)     { etPrice.setError(getString(R.string.error_non_positive)); return; }

            // coste = (distancia/100) * consumo(L/100km) * precio(€/L)
            double litros = (distanciaKm / 100.0) * consumoL100;
            double coste  = litros * precioL;

            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
            String costeFmt = nf.format(coste);

            tvResult.setText(getString(R.string.result_text, costeFmt));
            Toast.makeText(this, getString(R.string.toast_done), Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            tvResult.setText(getString(R.string.result_placeholder));
        }
    }
}
