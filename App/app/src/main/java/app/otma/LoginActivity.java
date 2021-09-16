package app.otma;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.otma.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText inputEmail, inputSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        inputEmail = (EditText) findViewById(R.id.edtxtEmailLogin);
        inputSenha = (EditText) findViewById(R.id.edtxtSenhaLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = String.valueOf(inputEmail.getText());
                String senha = String.valueOf(inputSenha.getText());
                /*
                if((senha.equals(cliente.getClienteSenha())) && (email.equals(cliente.getClienteEmail())))
                {
                    Toast.makeText(LoginActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }*/
                Toast.makeText(LoginActivity.this, "Usuário ou senha não correspondem", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void abrirCadastro(View asc)
    {
        Toast.makeText(LoginActivity.this, "Cadastro", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }
}