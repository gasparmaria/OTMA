package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {
    private static final String FILE_NAME = "dadosCliente.json";
    private EditText txtEmail, txtSenha;
    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.edtxtEmailLogin);
        txtSenha = findViewById(R.id.edtxtSenhaLogin);

        btnLogin.setOnClickListener(v -> {
            Gson gson = new Gson();
            String clienteJson = lerDados();
            Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
            String emailLogin = String.valueOf(txtEmail.getText());
            String senhaLogin = String.valueOf(txtSenha.getText());

            validarCampos();

            if ((senhaLogin.equals(cliente.getSenha())) && (emailLogin.equals(cliente.getEmail()))) {
                entrar();
            } else {
                Toast.makeText(LoginActivity.this, "Usuário ou senha não correspondem", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // MÉTODOS PARA ENTRAR
    public void entrar() {
        Toast.makeText(LoginActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void abrirCadastro(View asc) {
        Toast.makeText(LoginActivity.this, "Cadastro", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }

    // VALIDAR CAMPOS
    private void validarCampos(){
        boolean verificacao = false;

        email = txtEmail.getText().toString();
        senha = txtSenha.getText().toString();

        if (verificacao = campoNulo(email)) {
            txtEmail.requestFocus();
            Toast.makeText(this, "Preencha o campo email.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(senha)) {
            txtSenha.requestFocus();
            Toast.makeText(this, "Preencha o campo senha.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean campoNulo (String campo){
        boolean verificacao = (TextUtils.isEmpty(campo) || campo.trim().isEmpty());
        return verificacao;
    }

    // LER DADOS
    private String lerDados() {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // SAVED INSTANCE
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String email = txtEmail.getText().toString();
        outState.putString("Email", email);
    }
}