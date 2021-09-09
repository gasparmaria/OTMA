package app.otma;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PagamentoActivity extends AppCompatActivity {
    private LinearLayout viewEndereco, viewFormaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        viewEndereco = findViewById(R.id.viewEndereco);
        viewFormaPagamento = findViewById(R.id.viewFormaPagamento);

        viewFormaPagamento.setOnClickListener(v -> {
            ConstraintLayout telaFormaPagamento = findViewById(R.id.activityFormaPagamento);
            telaFormaPagamento.setVisibility(View.VISIBLE);
        });

        viewEndereco.setOnClickListener(v -> {
            LinearLayout telaEndereco = findViewById(R.id.activityLocalizacao);
            telaEndereco.setVisibility(View.VISIBLE);
        });
    }
}