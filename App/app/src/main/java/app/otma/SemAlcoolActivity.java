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
import android.os.Handler;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class SemAlcoolActivity extends AppCompatActivity implements SensorEventListener {

    public LinearLayout cardRefri1, cardRefri2, cardRefri3, cardRefri4, cardRefri5, cardAddRefri1, cardAddRefri2, cardAddRefri3, cardAddRefri4, cardAddRefri5;
    public LinearLayout cardSuco1, cardSuco2, cardSuco3, cardAddSuco1, cardAddSuco2, cardAddSuco3;
    public LinearLayout cardAgua1, cardAgua2, cardAddAgua1, cardAddAgua2;
    public LinearLayout cardEnerg1, cardEnerg2, cardEnerg3, cardAddEnerg1, cardAddEnerg2, cardAddEnerg3;
    private DrawerLayout drawerLayout;
    private ScrollView contentView;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_alcool);

        contentView=findViewById(R.id.content_layout_semAlcool);
        NavigationView navigationView = findViewById(R.id.NavigationView);
        drawerLayout=findViewById(R.id.DrawerLayout);
        Toolbar toolbar = findViewById(R.id.app_Bar);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.iteminicio:
                    Toast.makeText(SemAlcoolActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    openNextActivity("Index");
                    return true;
                case R.id.categoria_cerveja:
                    Toast.makeText(SemAlcoolActivity.this, "Cerveja", Toast.LENGTH_SHORT).show();
                    openNextActivity("Cerveja");
                    return true;
                case R.id.categoria_vinho:
                    Toast.makeText(SemAlcoolActivity.this, "Vinhos", Toast.LENGTH_SHORT).show();
                    openNextActivity("Vinhos");
                    return true;
                case R.id.categoria_destilados:
                    Toast.makeText(SemAlcoolActivity.this, "Destilados", Toast.LENGTH_SHORT).show();
                    openNextActivity("Destilados");
                    return true;
                case R.id.categoria_semAlcool:
                    Toast.makeText(SemAlcoolActivity.this, "Sem Álcool", Toast.LENGTH_SHORT).show();
                    openNextActivity("SemAlcool");
                    return true;
                case R.id.itemcarrinho:
                    Toast.makeText(SemAlcoolActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
                    openNextActivity("Carrinho");
                    return true;
                case R.id.itemsair:
                    Toast.makeText(SemAlcoolActivity.this, "Sair", Toast.LENGTH_SHORT).show();
                    openNextActivity("Sair");
                    return true;
            }
            return true;
        });

        // cards refrigerante
        cardRefri1 = findViewById(R.id.cardRefri1);
        cardAddRefri1 = findViewById(R.id.cardRefri1_0);
        cardRefri2 = findViewById(R.id.cardRefri2);
        cardAddRefri2 = findViewById(R.id.cardRefri2_0);
        cardRefri3 = findViewById(R.id.cardRefri3);
        cardAddRefri3 = findViewById(R.id.cardRefri3_0);
        cardRefri4 = findViewById(R.id.cardRefri4);
        cardAddRefri4 = findViewById(R.id.cardRefri4_0);
        cardRefri5 = findViewById(R.id.cardRefri5);
        cardAddRefri5 = findViewById(R.id.cardRefri5_0);
        // cards suco
        cardSuco1 = findViewById(R.id.cardSuco1);
        cardAddSuco1 = findViewById(R.id.cardSuco1_0);
        cardSuco2 = findViewById(R.id.cardSuco2);
        cardAddSuco2 = findViewById(R.id.cardSuco2_0);
        cardSuco3 = findViewById(R.id.cardSuco3);
        cardAddSuco3 = findViewById(R.id.cardSuco3_0);
        // cards água
        cardAgua1 = findViewById(R.id.cardAgua1);
        cardAddAgua1 = findViewById(R.id.cardAgua1_0);
        cardAgua2 = findViewById(R.id.cardAgua2);
        cardAddAgua2 = findViewById(R.id.cardAgua2_0);
        // cards energético
        cardEnerg1 = findViewById(R.id.cardEnerg1);
        cardAddEnerg1 = findViewById(R.id.cardEnerg1_0);
        cardEnerg2 = findViewById(R.id.cardEnerg2);
        cardAddEnerg2 = findViewById(R.id.cardEnerg2_0);
        cardEnerg3 = findViewById(R.id.cardEnerg3);
        cardAddEnerg3 = findViewById(R.id.cardEnerg3_0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            contentView.setVisibility(View.INVISIBLE);
            return true;
        }
        return true;
    }

    public void returnContent(View view) {
        drawerLayout.closeDrawer(GravityCompat.START);
        new Handler().postDelayed(() -> contentView.setVisibility(View.VISIBLE), 200);
    }

    public void abrirCarrinho(View view){
        Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
        startActivity(intent);
    }

    public void openNextActivity(String value) {
        Intent intent = new Intent();

        switch (value) {
            case "Index":
                intent = new Intent(getApplicationContext(), MainActivity.class);
                break;
            case "Cerveja":
                intent = new Intent(getApplicationContext(), CervejaActivity.class);
                break;
            case "Vinhos":
                intent = new Intent(getApplicationContext(), VinhoActivity.class);
                break;
            case "Destilados":
                intent = new Intent(getApplicationContext(), DestiladoActivity.class);
                break;
            case "Carrinho":
                intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
                break;
            case "Sair":
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                break;
            case "SemAlcool":
                intent = new Intent(getApplicationContext(), SemAlcoolActivity.class);
                break;
        }
        startActivity(intent);
    }

    // onclick refrigerante
    public void addRefri1(View asc){
        cardRefri1.setVisibility(View.GONE);
        cardAddRefri1.setVisibility(View.VISIBLE);
    }
    public void addRefri2(View asc){
        cardRefri2.setVisibility(View.GONE);
        cardAddRefri2.setVisibility(View.VISIBLE);
    }
    public void addRefri3(View asc){
        cardRefri3.setVisibility(View.GONE);
        cardAddRefri3.setVisibility(View.VISIBLE);
    }
    public void addRefri4(View asc){
        cardRefri4.setVisibility(View.GONE);
        cardAddRefri4.setVisibility(View.VISIBLE);
    }
    public void addRefri5(View asc){
        cardRefri5.setVisibility(View.GONE);
        cardAddRefri5.setVisibility(View.VISIBLE);
    }
    public void retRefri1(View asc){
        cardRefri1.setVisibility(View.VISIBLE);
        cardAddRefri1.setVisibility(View.GONE);
    }
    public void retRefri2(View asc){
        cardRefri2.setVisibility(View.VISIBLE);
        cardAddRefri2.setVisibility(View.GONE);
    }
    public void retRefri3(View asc){
        cardRefri3.setVisibility(View.VISIBLE);
        cardAddRefri3.setVisibility(View.GONE);
    }
    public void retRefri4(View asc){
        cardRefri4.setVisibility(View.VISIBLE);
        cardAddRefri4.setVisibility(View.GONE);
    }
    public void retRefri5(View asc){
        cardRefri5.setVisibility(View.VISIBLE);
        cardAddRefri5.setVisibility(View.GONE);
    }

    // onclick suco
    public void addSuco1(View asc){
        cardSuco1.setVisibility(View.GONE);
        cardAddSuco1.setVisibility(View.VISIBLE);
    }
    public void addSuco2(View asc){
        cardSuco2.setVisibility(View.GONE);
        cardAddSuco2.setVisibility(View.VISIBLE);
    }
    public void addSuco3(View asc){
        cardSuco3.setVisibility(View.GONE);
        cardAddSuco3.setVisibility(View.VISIBLE);
    }
    public void retSuco1(View asc){
        cardSuco1.setVisibility(View.VISIBLE);
        cardAddSuco1.setVisibility(View.GONE);
    }
    public void retSuco2(View asc){
        cardSuco2.setVisibility(View.VISIBLE);
        cardAddSuco2.setVisibility(View.GONE);
    }
    public void retSuco3(View asc){
        cardSuco3.setVisibility(View.VISIBLE);
        cardAddSuco3.setVisibility(View.GONE);
    }

    // onclick água
    public void addAgua1(View asc){
        cardAgua1.setVisibility(View.GONE);
        cardAddAgua1.setVisibility(View.VISIBLE);
    }
    public void addAgua2(View asc){
        cardAgua2.setVisibility(View.GONE);
        cardAddAgua2.setVisibility(View.VISIBLE);
    }
    public void retAgua1(View asc){
        cardAgua1.setVisibility(View.VISIBLE);
        cardAddAgua1.setVisibility(View.GONE);
    }
    public void retAgua2(View asc){
        cardAgua2.setVisibility(View.VISIBLE);
        cardAddAgua2.setVisibility(View.GONE);
    }

    // onclick energético
    public void addEnerg1(View asc){
        cardEnerg1.setVisibility(View.GONE);
        cardAddEnerg1.setVisibility(View.VISIBLE);
    }
    public void addEnerg2(View asc){
        cardEnerg2.setVisibility(View.GONE);
        cardAddEnerg2.setVisibility(View.VISIBLE);
    }
    public void addEnerg3(View asc){
        cardEnerg3.setVisibility(View.GONE);
        cardAddEnerg3.setVisibility(View.VISIBLE);
    }
    public void retEnerg1(View asc){
        cardEnerg1.setVisibility(View.VISIBLE);
        cardAddEnerg1.setVisibility(View.GONE);
    }
    public void retEnerg2(View asc){
        cardEnerg2.setVisibility(View.VISIBLE);
        cardAddEnerg2.setVisibility(View.GONE);
    }
    public void retEnerg3(View asc){
        cardEnerg3.setVisibility(View.VISIBLE);
        cardAddEnerg3.setVisibility(View.GONE);
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