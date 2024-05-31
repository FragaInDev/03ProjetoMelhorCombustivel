package com.fraga.a03projetomelhorcombustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputGasolina, inputEtanol;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputGasolina = findViewById(R.id.inputGasolina);
        inputEtanol = findViewById(R.id.inputEtanol);
        result = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        String gasolina = inputGasolina.getText().toString();
        String etanol = inputEtanol.getText().toString();

        if (gasolina.isEmpty() || etanol.isEmpty()) {
            result.setText("Preencha os valores corretamente!");
            return;
        }

        double precoGasolina = Double.parseDouble(gasolina);
        double precoEtanol = Double.parseDouble(etanol);

        if (precoEtanol <= precoGasolina * 0.7) {
            result.setText("Melhor utilizar etanol!");
        } else {
            result.setText("Melhor utilizar gasolina!");
        }
    }

}