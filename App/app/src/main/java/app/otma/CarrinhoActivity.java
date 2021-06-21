package app.otma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CarrinhoActivity extends AppCompatActivity {

    public RelativeLayout telaEndereco, informacoesCard;
    public Button btn_confirmarPedido;
    public TextView addProdutos;
    public ConstraintLayout telaFormaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        telaEndereco=findViewById(R.id.endereco_activity);
        informacoesCard=findViewById(R.id.card_info);
        addProdutos=findViewById(R.id.txtaddProd);
        btn_confirmarPedido=findViewById(R.id.btn_confirmarPedido);
        telaFormaPagamento=findViewById(R.id.forma_pagamento_activity);

    }

    public void voltar(View asc)
    {
        Toast.makeText(CarrinhoActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void abrirTelaEndereco(View asc)
    {
        telaEndereco.setVisibility(View.VISIBLE);

        informacoesCard.setVisibility(View.INVISIBLE);
        addProdutos.setVisibility(View.INVISIBLE);
        btn_confirmarPedido.setVisibility(View.INVISIBLE);
    }

    public void abrirMaps(View asc)
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                    Uri.parse("http://maps.google.com/maps"));
        startActivity(intent);
    }

    public void abrirFormaPagamento(View view) {
        telaFormaPagamento.setVisibility(View.VISIBLE);
    }
}