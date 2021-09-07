package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void entrar(View asc)
    {
        Toast.makeText(CadastroActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void abrirLogin(View asc)
    {
        Toast.makeText(CadastroActivity.this, "Login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), LocalizacaoActivity.class);
        startActivity(intent);
    }
}