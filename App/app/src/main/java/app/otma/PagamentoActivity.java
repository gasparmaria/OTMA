package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoActivity extends AppCompatActivity {
    private LinearLayout viewEndereco, viewFormaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        viewEndereco = findViewById(R.id.viewEndereco);
        viewFormaPagamento = findViewById(R.id.viewFormaPagamento);

        /*
        viewFormaPagamento.setOnClickListener(v -> {
            ConstraintLayout telaFormaPagamento = findViewById(R.id.activityFormaPagamento);
            telaFormaPagamento.setVisibility(View.VISIBLE);
        });
        */

        viewEndereco.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LocalizacaoActivity.class);
            startActivity(intent);
        });
    }
}