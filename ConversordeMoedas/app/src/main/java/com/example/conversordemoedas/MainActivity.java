package com.example.conversordemoedas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.bg));

        Button buttonRealToDolar = findViewById(R.id.buttonReal2Dolar);
        Button buttonDolarToReal = findViewById(R.id.buttonDolar2Real);
        Button buttonRealToBitcoin = findViewById(R.id.buttonReal2BTC);
        Button buttonBC = findViewById(R.id.buttonOpenBC);

        buttonRealToDolar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RealToDolarActivity.class);
            startActivity(intent);
        });

        buttonDolarToReal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DolarToRealActivity.class);
            startActivity(intent);
        });

        buttonRealToBitcoin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RealToBTCActivity.class);
            startActivity(intent);
        });

        buttonBC.setOnClickListener(view -> {
            Uri url = Uri.parse("https://www.bcb.gov.br/conversao");
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}