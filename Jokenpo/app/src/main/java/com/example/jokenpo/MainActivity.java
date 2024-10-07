package com.example.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int pc;
    private int player;
    private TextView textViewResult;
    private ImageView pcSelected;
    private ImageView playerSelected;
    private TextView pcPoints;
    private TextView playerPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton buttonPedra = findViewById(R.id.buttonPedra);
        ImageButton buttonPapel = findViewById(R.id.buttonPapel);
        ImageButton buttonTesoura = findViewById(R.id.buttonTesoura);
        textViewResult = findViewById(R.id.textViewResult);

        pcSelected = findViewById(R.id.pcSelected);
        playerSelected = findViewById(R.id.playerSelected);

        pcPoints = findViewById(R.id.pcPoints);
        playerPoints = findViewById(R.id.playerPoints);
        pc = 0;
        player = 0;

        buttonPedra.setOnClickListener(view -> {
            playerSelected.setImageResource(R.drawable.full_pedra);
            textViewResult.setText(calculaResultado(0, escolhaPcRandom()));
        });

        buttonPapel.setOnClickListener(view -> {
            playerSelected.setImageResource(R.drawable.full_papel);
            textViewResult.setText(calculaResultado(1, escolhaPcRandom()));
        });

        buttonTesoura.setOnClickListener(view -> {
            playerSelected.setImageResource(R.drawable.full_tesoura);
            textViewResult.setText(calculaResultado(2, escolhaPcRandom()));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private int escolhaPcRandom(){
        int escolhaPC = new Random().nextInt(3);
        if(escolhaPC == 0)
            pcSelected.setImageResource(R.drawable.full_pedra);

        if(escolhaPC == 1)
            pcSelected.setImageResource(R.drawable.full_papel);

        if(escolhaPC == 2)
            pcSelected.setImageResource(R.drawable.full_tesoura);

        return escolhaPC;
    }

    private String calculaResultado(int escolhaPlayer, int escolhaPC){
        this.pcSelected.setVisibility(View.VISIBLE);
        this.playerSelected.setVisibility(View.VISIBLE);

        if(escolhaPlayer == escolhaPC)
            return "Empate";

        if(escolhaPlayer == 0)
            if(escolhaPC == 1){
                pcPoints.setText(String.valueOf(++pc));
                return "Você Perdeu";
            }
            else {
                playerPoints.setText(String.valueOf(++player));
                return "Você Venceu";
            }


        if(escolhaPlayer == 1)
            if(escolhaPC == 2){
                pcPoints.setText(String.valueOf(++pc));
                return "Você Perdeu";
            }
            else {
                playerPoints.setText(String.valueOf(++player));
                return "Você Venceu";
            }

        if(escolhaPlayer == 2)
            if(escolhaPC == 0){
                pcPoints.setText(String.valueOf(++pc));
                return "Você Perdeu";
            }
            else {
                playerPoints.setText(String.valueOf(++player));
                return "Você Venceu";
            }

        return "";
    }
}