package app.otma;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CadastroActivity extends AppCompatActivity implements SensorEventListener {

    private static final String FILE_NAME = "dadosCliente.json";
    private EditText txtNome, txtCPF, txtCelular, txtIdade, txtEmail, txtSenha, txtConfSenha;
    private String nome, cpf, celular, stringidade, email, senha, confsenha;
    private int idade;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        txtNome = findViewById(R.id.edtxtNome);
        txtCPF = findViewById(R.id.edtxtCPF);
        txtCelular = findViewById(R.id.edtxtCelular);
        txtIdade = findViewById(R.id.edtxtIdade);
        txtEmail = findViewById(R.id.edtxtEmail);
        txtSenha = findViewById(R.id.edtxtSenha);
        txtConfSenha = findViewById(R.id.edtxtConfSenha);

        btnCadastrar.setOnClickListener(v -> {
            nome = txtNome.getText().toString();
            cpf = txtCPF.getText().toString();
            celular = txtCelular.getText().toString();
            stringidade = txtIdade.getText().toString();
            idade = Integer.parseInt(stringidade);
            email = txtEmail.getText().toString();
            senha = txtSenha.getText().toString();
            confsenha = txtConfSenha.getText().toString();

            if (senha.equals(confsenha)) {
                Cliente cliente = new Cliente(nome, cpf, celular, idade, email, senha);
                Gson gson = new Gson();
                String json = gson.toJson(cliente);
                gravarDados(json);
                abrirLogin(null);
            } else {
                Toast.makeText(CadastroActivity.this, "As senhas não correspondem.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // MÉTODOS PARA ENTRAR

    public void abrirLogin(View view) {
        Toast.makeText(CadastroActivity.this, "Login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    // ARMAZENAR DADOS

    private void gravarDados(String json) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(json.getBytes());
            Toast.makeText(this, "Cadastro efetuado.", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // SAVED INSTANCE

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        nome = txtNome.getText().toString();
        cpf = txtCPF.getText().toString();
        celular = txtCelular.getText().toString();
        stringidade = txtIdade.getText().toString();
        email = txtEmail.getText().toString();

        outState.putString("Nome", nome);
        outState.putString("Cpf", cpf);
        outState.putString("Celular", celular);
        outState.putString("Idade", stringidade);
        outState.putString("Email", email);
    }

    //MÉTODOS DO SENSOR

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorLuz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            if(permissaoControlarBrilho()){
                int brilho = (int) (event.values[0]);
                controlarBrilho(brilho);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {    }

    private boolean permissaoControlarBrilho() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                return true;
            } else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData((Uri.parse("package:" + getApplication().getPackageName())));
                startActivity(intent);
                return false;
            }
        }
        return false;
    }

    private void controlarBrilho(int brilho) {
        if (brilho < 0) {
            brilho = 0;
        } else if (brilho > 255) {
            brilho = 255;
        }

        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brilho);
    }
}