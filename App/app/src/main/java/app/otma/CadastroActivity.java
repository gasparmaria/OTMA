package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText inputNomeCompleto,
                    inputCPF,
                    inputCelular,
                    inputIdade,
                    inputEmail,
                    inputSenha,
                    inputConfirmarSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        inputNomeCompleto = (EditText) findViewById(R.id.edtxtNome);
        inputCPF = (EditText) findViewById(R.id.edtxtCPF);
        inputCelular = (EditText) findViewById(R.id.edtxtNumero);
        inputIdade = (EditText) findViewById(R.id.edtxtIdade);
        inputEmail = (EditText) findViewById(R.id.edtxtEmail);
        inputSenha = (EditText) findViewById(R.id.edtxtSenha);
        inputConfirmarSenha = (EditText) findViewById(R.id.edtxtConfSenha);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeCompleto = String.valueOf(inputNomeCompleto.getText());
                String CPF = String.valueOf(inputCPF.getText());
                String Celular = String.valueOf(inputCelular.getText());
                int Idade = Integer.valueOf((String.valueOf(inputIdade.getText())));
                String Email = String.valueOf(inputEmail.getText());
                String Senha = String.valueOf(inputSenha.getText());
                String ConfirmarSenha = String.valueOf(inputConfirmarSenha.getText());

                if(Senha.equals(ConfirmarSenha))
                {
                    Cliente cliente = new Cliente(nomeCompleto,
                                                  CPF,
                                                  Celular,
                                                  Idade,
                                                  Email, Senha);
                    Toast.makeText(CadastroActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(CadastroActivity.this, "As senhas não correspondem", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void abrirLogin(View asc)
    {
        Toast.makeText(CadastroActivity.this, "Login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), LocalizacaoActivity.class);
        startActivity(intent);
    }
}