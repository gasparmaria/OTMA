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
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FormaPagamentoActivity extends AppCompatActivity implements SensorEventListener {
    private EditText inputNumeroCartao, inputNomeTitular, inputValidade, inputCVV, inputTroco;
    private String numerocartao, nometitular, validade, cvv, troco;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pagamento);

        inputNumeroCartao = findViewById(R.id.inputNumeroCartao);
        inputNomeTitular = findViewById(R.id.inputNomeTitular);
        inputValidade = findViewById(R.id.inputValidade);
        inputCVV = findViewById(R.id.inputCVV);
        inputTroco = findViewById(R.id.inputTroco);

        Button btnSalvarFormaPagto = findViewById(R.id.btnSalvarFormaPagto);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        btnSalvarFormaPagto.setOnClickListener(v -> {
            validarCampos();
            Toast.makeText(this, "Forma de pagamento confirmada com sucesso.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), PagamentoActivity.class);
            intent.putExtra("num", inputNumeroCartao.getText().toString());
            startActivity(intent);
        });
    }

    // VALIDAR CAMPOS
    private void validarCampos(){
        boolean verificacao = false;

        numerocartao = inputNumeroCartao.getText().toString();
        nometitular = inputNomeTitular.getText().toString();
        validade = inputValidade.getText().toString();
        cvv = inputCVV.getText().toString();

        if (verificacao = campoNulo(numerocartao)) {
            inputNumeroCartao.requestFocus();
            Toast.makeText(this, "Preencha o campo número do cartão.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(nometitular)) {
            inputNomeTitular.requestFocus();
            Toast.makeText(this, "Preencha o campo nome do titular.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(validade)) {
            inputValidade.requestFocus();
            Toast.makeText(this, "Preencha o campo validade.", Toast.LENGTH_SHORT).show();
        } else if (verificacao = campoNulo(cvv)) {
            inputCVV.requestFocus();
            Toast.makeText(this, "Preencha o campo CVV.", Toast.LENGTH_SHORT).show();
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

        numerocartao = inputNumeroCartao.getText().toString();
        nometitular = inputNomeTitular.getText().toString();
        validade = inputValidade.getText().toString();
        cvv = inputCVV.getText().toString();
        troco = inputTroco.getText().toString();

        outState.putString("NumeroCartao", numerocartao);
        outState.putString("NomeTitular", nometitular);
        outState.putString("Validade", validade);
        outState.putString("CVV", cvv);
        outState.putString("Troco", troco);
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
            if (permissaoControlarBrilho()) {
                int brilho = (int) (event.values[0]);
                controlarBrilho(brilho);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

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