package app.otma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CarrinhoActivity extends AppCompatActivity {

    public RelativeLayout telaEndereco, informacoesCard;
    public Button btn_confirmarPedido;
    public TextView addProdutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        telaEndereco=findViewById(R.id.endereco_activity);
        informacoesCard=findViewById(R.id.card_info);
        addProdutos=findViewById(R.id.txtaddProd);
        btn_confirmarPedido=findViewById(R.id.btn_confirmarPedido);
    }

    public void abrirTelaEndereco(View asc)
    {
        telaEndereco.setVisibility(View.VISIBLE);

        informacoesCard.setVisibility(View.INVISIBLE);
        addProdutos.setVisibility(View.INVISIBLE);
        btn_confirmarPedido.setVisibility(View.INVISIBLE);
    }
}