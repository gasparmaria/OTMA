package app.otma;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity implements SensorEventListener, Serializable{

    private EditText txtNome, txtCPF, txtCelular, txtIdade, txtEmail, txtSenha, txtConfSenha;
    private String nome, cpf, numero, stringidade, email, senha, confsenha;
    private int idade;
    private SensorManager sensorManager;
    private Sensor sensorLuz;
    private Button btnCadastrar;
    public File dadosCadastro;
    private Object Cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



        txtNome = findViewById(R.id.edtxtNome);
        txtCPF = findViewById(R.id.edtxtCPF);
        txtCelular = findViewById(R.id.edtxtCelular);
        txtIdade = findViewById(R.id.edtxtIdade);
        txtEmail = findViewById(R.id.edtxtEmail);
        txtSenha = findViewById(R.id.edtxtSenha);
        txtConfSenha = findViewById(R.id.edtxtConfSenha);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = txtNome.getText().toString();
                cpf = txtCPF.getText().toString();
                numero = txtCelular.getText().toString();
                stringidade = txtIdade.getText().toString();
                idade = Integer.parseInt(stringidade);
                email = txtEmail.getText().toString();
                senha = txtSenha.getText().toString();
                confsenha = txtConfSenha.getText().toString();

                if(senha.equals(confsenha))
                {
                    Cliente cliente = new Cliente(nome, cpf, numero, idade, email, senha);
                    // método entrar()
                    Toast.makeText(CadastroActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    try {
                        gravarDados();
                    } catch (IOException e) {
                        try {
                            lerDados();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(CadastroActivity.this, "As senhas não correspondem.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // MÉTODOS PARA ENTRAR

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

    // ARMAZENAR DADOS

    private void gravarDados() throws IOException {
        File fileDados = new File(getFilesDir(), String.valueOf(dadosCadastro));
        FileOutputStream fos = new FileOutputStream(fileDados);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Cliente);
        oos.close();
        fos.close();
    }

    private void lerDados() throws IOException, ClassNotFoundException {
        File fileDados = new File(getFilesDir(), String.valueOf(dadosCadastro));
        FileInputStream fis = new FileInputStream(fileDados);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object retorno = (Cliente) ois.readObject();
        ois.close();
        fis.close();
    }

    //MÉTODOS DO SENSOR

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

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

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private boolean permissaoControlarBrilho()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                return true;
            }
            else
            {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData((Uri.parse("package:" + getApplication().getPackageName())));
                startActivity(intent);
                return false;
            }
        }
        return false;
    }

    private void controlarBrilho(int brilho)
    {
        if(brilho < 0)
        {
            brilho = 0;
        }
        else if(brilho > 255)
        {
            brilho = 255;
        }

        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brilho);
    }
}