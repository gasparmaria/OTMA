package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CarrinhoActivity extends AppCompatActivity {

    private Button btnPagamento;
    private TextView addProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        addProdutos = findViewById(R.id.txtaddProd);
        btnPagamento = findViewById(R.id.btnPagamento);

        btnPagamento.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Toast.makeText(CarrinhoActivity.this, "Pagamento", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), PagamentoActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    public void voltar(View asc)
    {
        Toast.makeText(CarrinhoActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}