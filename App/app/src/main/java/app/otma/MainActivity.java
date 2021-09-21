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
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private DrawerLayout drawerLayout;
    private ScrollView contentView;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.NavigationView);
        drawerLayout = findViewById(R.id.DrawerLayout);
        Toolbar toolbar = findViewById(R.id.app_Bar);
        contentView = findViewById(R.id.content_layout_main);

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
                    Toast.makeText(MainActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    openNextActivity("Index");
                    return true;
                case R.id.categoria_cerveja:
                    Toast.makeText(MainActivity.this, "Cerveja", Toast.LENGTH_SHORT).show();
                    openNextActivity("Cerveja");
                    return true;
                case R.id.categoria_vinho:
                    Toast.makeText(MainActivity.this, "Vinhos", Toast.LENGTH_SHORT).show();
                    openNextActivity("Vinhos");
                    return true;
                case R.id.categoria_destilados:
                    Toast.makeText(MainActivity.this, "Destilados", Toast.LENGTH_SHORT).show();
                    openNextActivity("Destilados");
                    return true;
                case R.id.categoria_semAlcool:
                    Toast.makeText(MainActivity.this, "Sem Álcool", Toast.LENGTH_SHORT).show();
                    openNextActivity("SemAlcool");
                    return true;
                case R.id.itemcarrinho:
                    Toast.makeText(MainActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
                    openNextActivity("Carrinho");
                    return true;
                case R.id.itemsair:
                    Toast.makeText(MainActivity.this, "Sair", Toast.LENGTH_SHORT).show();
                    openNextActivity("Sair");
                    return true;
            }
            return true;
        });

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

    public void abrirCarrinho(View view) {
        Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
        startActivity(intent);
    }

    public void openCerveja(View view) {
        Intent intent = new Intent(getApplicationContext(), CervejaActivity.class);
        startActivity(intent);
    }

    public void openDestilado(View view) {
        Intent intent = new Intent(getApplicationContext(), DestiladoActivity.class);
        startActivity(intent);
    }

    public void openVinho(View view) {
        Intent intent = new Intent(getApplicationContext(), VinhoActivity.class);
        startActivity(intent);
    }

    public void openSemAlcool(View view) {
        Intent intent = new Intent(getApplicationContext(), SemAlcoolActivity.class);
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

    // MÉTODOS DO SENSOR

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