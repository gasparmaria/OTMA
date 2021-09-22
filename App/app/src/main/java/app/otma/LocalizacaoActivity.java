package app.otma;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocalizacaoActivity extends AppCompatActivity implements SensorEventListener {
    private EditText inputLogradouro, inputNumero, inputCidade, inputEstado, inputCEP, inputBairro, inputPontoReferencia;
    private String logradouro, numero, cep, cidade, estado, bairro, pontoreferencia;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        LinearLayout btnLocalizacao = findViewById(R.id.btnLocalizacaoAtual);

        inputLogradouro = findViewById(R.id.inputLogradouro);
        inputNumero = findViewById(R.id.inputNumeroEndereco);
        inputCEP = findViewById(R.id.inputCEP);
        inputCidade = findViewById(R.id.inputCidade);
        inputEstado = findViewById(R.id.inputEstado);
        inputBairro = findViewById(R.id.inputBairro);
        inputPontoReferencia = findViewById(R.id.inputPontoReferencia);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnLimpar = findViewById(R.id.btnLimpar);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        // LIMPAR DADOS DO FORMULÁRIO
        btnLimpar.setOnClickListener(v -> {
            inputLogradouro.setText(null);
            inputNumero.setText(null);
            inputCEP.setText(null);
            inputCidade.setText(null);
            inputEstado.setText(null);
            inputBairro.setText(null);
            inputPontoReferencia.setText(null);
        });

        // SALVAR DADOS
        btnSalvar.setOnClickListener(v -> {
            validarCampos();
            Toast.makeText(this, "Endereço confirmado com sucesso.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), PagamentoActivity.class);
            intent.putExtra("log", inputLogradouro.getText().toString());
            startActivity(intent);
        });

        // PEGAR LOCALIZAÇÃO ATUAL
        btnLocalizacao.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(LocalizacaoActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                //PERMISSÃO CEDIDA
                getLocalizacaoAtual();
            } else {
                //PERMISSÃO NEGADA
                ActivityCompat.requestPermissions(LocalizacaoActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        44);
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocalizacaoAtual() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
            //PEGAR A LOCALIZAÇÃO
            Location location = task.getResult();
            if (location != null) {
                try {
                    Geocoder geocoder = new Geocoder(LocalizacaoActivity.this, Locale.getDefault());
                    List<Address> addressList = geocoder.getFromLocation(
                            location.getLatitude(), location.getLongitude(), 1
                    );
                    //EXIBIR TEXTOS
                    inputLogradouro.setText(Html.fromHtml(String.valueOf(addressList.get(0).getThoroughfare())));
                    inputNumero.setText(Html.fromHtml(String.valueOf(addressList.get(0).getFeatureName())));
                    inputCEP.setText((Html.fromHtml(String.valueOf(addressList.get(0).getPostalCode()))));
                    inputCidade.setText(Html.fromHtml(String.valueOf(addressList.get(0).getSubAdminArea())));
                    inputEstado.setText(Html.fromHtml(String.valueOf(addressList.get(0).getAdminArea())));
                    inputBairro.setText(Html.fromHtml(String.valueOf(addressList.get(0).getSubLocality())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // VALIDAR CAMPOS
    private void validarCampos(){
        boolean verificacao = false;

        logradouro = inputLogradouro.getText().toString();
        numero = inputNumero.getText().toString();
        cidade = inputCidade.getText().toString();
        estado = inputEstado.getText().toString();
        cep = inputCEP.getText().toString();
        bairro = inputBairro.getText().toString();
        pontoreferencia = inputPontoReferencia.getText().toString();

        if (verificacao = campoNulo(logradouro)) {
            inputLogradouro.requestFocus();
            Toast.makeText(this, "Preencha o campo logradouro.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(numero)) {
            inputNumero.requestFocus();
            Toast.makeText(this, "Preencha o campo número.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(cidade)) {
            inputCidade.requestFocus();
            Toast.makeText(this, "Preencha o campo cidade.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(estado)) {
            inputEstado.requestFocus();
            Toast.makeText(this, "Preencha o campo estado.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(cep)) {
            inputCEP.requestFocus();
            Toast.makeText(this, "Preencha o campo CEP.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(bairro)) {
            inputBairro.requestFocus();
            Toast.makeText(this, "Preencha o campo bairro.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean campoNulo (String campo){
        boolean verificacao = (TextUtils.isEmpty(campo) || campo.trim().isEmpty());
        return verificacao;
    }

    // SAVED INSTANCE
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        logradouro = inputLogradouro.getText().toString();
        numero = inputNumero.getText().toString();
        cidade = inputCidade.getText().toString();
        estado = inputEstado.getText().toString();
        cep = inputCEP.getText().toString();
        bairro = inputBairro.getText().toString();
        pontoreferencia = inputPontoReferencia.getText().toString();
        outState.putString("Logradouro", logradouro);
        outState.putString("Numero", numero);
        outState.putString("Cidade", cidade);
        outState.putString("Estado", estado);
        outState.putString("Cep", cep);
        outState.putString("Bairro", bairro);
        outState.putString("PontoReferencia", pontoreferencia);
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

    public void onAccuracyChanged(Sensor sensor, int accuracy) {    }

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
        if (brilho < 0) {
            brilho = 0;
        } else if (brilho > 255) {
            brilho = 255;
        }
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brilho);
    }
}
    
    
  
  

