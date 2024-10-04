package com.example.conversordemoedas;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DolarToRealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dolar_to_real);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.button));

        TextView textResult = findViewById(R.id.textViewResult);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        EditText editTextReal = findViewById(R.id.editTextValor);

        buttonConvert.setOnClickListener(view -> {
            double dolar = Double.parseDouble(editTextReal.getText().toString());
            double cotacao = 5.4850002;
            double real = dolar * cotacao;

            textResult.setText(String.format("R$ %.3f", real));
        });

        buttonVoltar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}