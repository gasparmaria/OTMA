package app.otma;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocalizacaoActivity extends AppCompatActivity {

    private LinearLayout btn_localizacao;
    private EditText inputLogradouro, inputNumero, inputCidade, inputEstado, inputCEP, inputBairro;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        btn_localizacao = findViewById(R.id.btnLocalizacaoAtual);
        inputLogradouro = findViewById(R.id.inputLogradouro);
        inputNumero = findViewById(R.id.inputNumeroEndereco);
        inputCEP = findViewById(R.id.inputCEP);
        inputCidade = findViewById(R.id.inputCidade);
        inputEstado = findViewById(R.id.inputEstado);
        inputBairro = findViewById(R.id.inputBairro);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btn_localizacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocalizacaoAtual() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<Location> task) {
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

            }
        });
    }
}