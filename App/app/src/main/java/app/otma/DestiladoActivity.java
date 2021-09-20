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

public class DestiladoActivity extends AppCompatActivity implements SensorEventListener {

    public LinearLayout cardBeats1, cardBeats2, cardBeats3, cardBeats4, cardBeats5, cardBeats6, cardBeats7, cardAddBeats1, cardAddBeats2, cardAddBeats3, cardAddBeats4, cardAddBeats5, cardAddBeats6, cardAddBeats7;
    public LinearLayout cardWhisky1, cardWhisky2, cardWhisky3, cardWhisky4, cardAddWhisky1, cardAddWhisky2, cardAddWhisky3, cardAddWhisky4;
    public LinearLayout cardVodka1, cardVodka2, cardVodka3, cardVodka4, cardAddVodka1, cardAddVodka2, cardAddVodka3, cardAddVodka4;
    public LinearLayout cardGin1, cardGin2, cardGin3, cardAddGin1, cardAddGin2, cardAddGin3;
    public LinearLayout cardCachaca1, cardCachaca2, cardCachaca3, cardAddCachaca1, cardAddCachaca2, cardAddCachaca3;
    private DrawerLayout drawerLayout;
    private ScrollView contentView;
    private SensorManager sensorManager;
    private Sensor sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destilado);

        contentView=findViewById(R.id.content_layout_destilado);
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
                    Toast.makeText(DestiladoActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    openNextActivity("Index");
                    return true;
                case R.id.categoria_cerveja:
                    Toast.makeText(DestiladoActivity.this, "Cerveja", Toast.LENGTH_SHORT).show();
                    openNextActivity("Cerveja");
                    return true;
                case R.id.categoria_vinho:
                    Toast.makeText(DestiladoActivity.this, "Vinhos", Toast.LENGTH_SHORT).show();
                    openNextActivity("Vinhos");
                    return true;
                case R.id.categoria_destilados:
                    Toast.makeText(DestiladoActivity.this, "Destilados", Toast.LENGTH_SHORT).show();
                    openNextActivity("Destilados");
                    return true;
                case R.id.categoria_semAlcool:
                    Toast.makeText(DestiladoActivity.this, "Sem Álcool", Toast.LENGTH_SHORT).show();
                    openNextActivity("SemAlcool");
                    return true;
                case R.id.itemcarrinho:
                    Toast.makeText(DestiladoActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
                    openNextActivity("Carrinho");
                    return true;
                case R.id.itemsair:
                    Toast.makeText(DestiladoActivity.this, "Sair", Toast.LENGTH_SHORT).show();
                    openNextActivity("Sair");
                    return true;
            }
            return true;
        });

        // cards beats
        cardBeats1 = (LinearLayout) findViewById(R.id.cardBeats1);
        cardAddBeats1 = (LinearLayout) findViewById(R.id.cardBeats1_0);
        cardBeats2 = (LinearLayout) findViewById(R.id.cardBeats2);
        cardAddBeats2 = (LinearLayout) findViewById(R.id.cardBeats2_0);
        cardBeats3 = (LinearLayout) findViewById(R.id.cardBeats3);
        cardAddBeats3 = (LinearLayout) findViewById(R.id.cardBeats3_0);
        cardBeats4 = (LinearLayout) findViewById(R.id.cardBeats4);
        cardAddBeats4 = (LinearLayout) findViewById(R.id.cardBeats4_0);
        cardBeats5 = (LinearLayout) findViewById(R.id.cardBeats5);
        cardAddBeats5 = (LinearLayout) findViewById(R.id.cardBeats5_0);
        cardBeats6 = (LinearLayout) findViewById(R.id.cardBeats6);
        cardAddBeats6 = (LinearLayout) findViewById(R.id.cardBeats6_0);
        cardBeats7 = (LinearLayout) findViewById(R.id.cardBeats7);
        cardAddBeats7 = (LinearLayout) findViewById(R.id.cardBeats7_0);
        // cards whisky
        cardWhisky1 = (LinearLayout) findViewById(R.id.cardWhisky1);
        cardAddWhisky1 = (LinearLayout) findViewById(R.id.cardWhisky1_0);
        cardWhisky2 = (LinearLayout) findViewById(R.id.cardWhisky2);
        cardAddWhisky2 = (LinearLayout) findViewById(R.id.cardWhisky2_0);
        cardWhisky3 = (LinearLayout) findViewById(R.id.cardWhisky3);
        cardAddWhisky3 = (LinearLayout) findViewById(R.id.cardWhisky3_0);
        cardWhisky4 = (LinearLayout) findViewById(R.id.cardWhisky4);
        cardAddWhisky4 = (LinearLayout) findViewById(R.id.cardWhisky4_0);
        // cards vodka
        cardVodka1 = (LinearLayout) findViewById(R.id.cardVodka1);
        cardAddVodka1 = (LinearLayout) findViewById(R.id.cardVodka1_0);
        cardVodka2 = (LinearLayout) findViewById(R.id.cardVodka2);
        cardAddVodka2 = (LinearLayout) findViewById(R.id.cardVodka2_0);
        cardVodka3 = (LinearLayout) findViewById(R.id.cardVodka3);
        cardAddVodka3 = (LinearLayout) findViewById(R.id.cardVodka3_0);
        cardVodka4 = (LinearLayout) findViewById(R.id.cardVodka4);
        cardAddVodka4 = (LinearLayout) findViewById(R.id.cardVodka4_0);
        // cards gin
        cardGin1 = (LinearLayout) findViewById(R.id.cardGin1);
        cardAddGin1 = (LinearLayout) findViewById(R.id.cardGin1_0);
        cardGin2 = (LinearLayout) findViewById(R.id.cardGin2);
        cardAddGin2 = (LinearLayout) findViewById(R.id.cardGin2_0);
        cardGin3 = (LinearLayout) findViewById(R.id.cardGin3);
        cardAddGin3 = (LinearLayout) findViewById(R.id.cardGin3_0);
        // cards cachaça
        cardCachaca1 = (LinearLayout) findViewById(R.id.cardCachaca1);
        cardAddCachaca1 = (LinearLayout) findViewById(R.id.cardCachaca1_0);
        cardCachaca2 = (LinearLayout) findViewById(R.id.cardCachaca2);
        cardAddCachaca2 = (LinearLayout) findViewById(R.id.cardCachaca2_0);
        cardCachaca3 = (LinearLayout) findViewById(R.id.cardCachaca3);
        cardAddCachaca3 = (LinearLayout) findViewById(R.id.cardCachaca3_0);
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

    // onclick beats
    public void addBeats1(View asc){
        cardBeats1.setVisibility(View.GONE);
        cardAddBeats1.setVisibility(View.VISIBLE);
    }
    public void addBeats2(View asc){
        cardBeats2.setVisibility(View.GONE);
        cardAddBeats2.setVisibility(View.VISIBLE);
    }
    public void addBeats3(View asc){
        cardBeats3.setVisibility(View.GONE);
        cardAddBeats3.setVisibility(View.VISIBLE);
    }
    public void addBeats4(View asc){
        cardBeats4.setVisibility(View.GONE);
        cardAddBeats4.setVisibility(View.VISIBLE);
    }
    public void addBeats5(View asc){
        cardBeats5.setVisibility(View.GONE);
        cardAddBeats5.setVisibility(View.VISIBLE);
    }
    public void addBeats6(View asc){
        cardBeats6.setVisibility(View.GONE);
        cardAddBeats6.setVisibility(View.VISIBLE);
    }
    public void addBeats7(View asc){
        cardBeats7.setVisibility(View.GONE);
        cardAddBeats7.setVisibility(View.VISIBLE);
    }
    public void retBeats1(View asc){
        cardBeats1.setVisibility(View.VISIBLE);
        cardAddBeats1.setVisibility(View.GONE);
    }
    public void retBeats2(View asc){
        cardBeats2.setVisibility(View.VISIBLE);
        cardAddBeats2.setVisibility(View.GONE);
    }
    public void retBeats3(View asc){
        cardBeats3.setVisibility(View.VISIBLE);
        cardAddBeats3.setVisibility(View.GONE);
    }
    public void retBeats4(View asc){
        cardBeats4.setVisibility(View.VISIBLE);
        cardAddBeats4.setVisibility(View.GONE);
    }
    public void retBeats5(View asc){
        cardBeats5.setVisibility(View.VISIBLE);
        cardAddBeats5.setVisibility(View.GONE);
    }
    public void retBeats6(View asc){
        cardBeats6.setVisibility(View.VISIBLE);
        cardAddBeats6.setVisibility(View.GONE);
    }
    public void retBeats7(View asc){
        cardBeats7.setVisibility(View.VISIBLE);
        cardAddBeats7.setVisibility(View.GONE);
    }

    // onclick whisky
    public void addWhisky1(View asc){
        cardWhisky1.setVisibility(View.GONE);
        cardAddWhisky1.setVisibility(View.VISIBLE);
    }
    public void addWhisky2(View asc){
        cardWhisky2.setVisibility(View.GONE);
        cardAddWhisky2.setVisibility(View.VISIBLE);
    }
    public void addWhisky3(View asc){
        cardWhisky3.setVisibility(View.GONE);
        cardAddWhisky3.setVisibility(View.VISIBLE);
    }
    public void addWhisky4(View asc){
        cardWhisky4.setVisibility(View.GONE);
        cardAddWhisky4.setVisibility(View.VISIBLE);
    }
    public void retWhisky1(View asc){
        cardWhisky1.setVisibility(View.VISIBLE);
        cardAddWhisky1.setVisibility(View.GONE);
    }
    public void retWhisky2(View asc){
        cardWhisky2.setVisibility(View.VISIBLE);
        cardAddWhisky2.setVisibility(View.GONE);
    }
    public void retWhisky3(View asc){
        cardWhisky3.setVisibility(View.VISIBLE);
        cardAddWhisky3.setVisibility(View.GONE);
    }
    public void retWhisky4(View asc){
        cardWhisky4.setVisibility(View.VISIBLE);
        cardAddWhisky4.setVisibility(View.GONE);
    }

    // onclick vodkac
    public void addVodka1(View asc){
        cardVodka1.setVisibility(View.GONE);
        cardAddVodka1.setVisibility(View.VISIBLE);
    }
    public void addVodka2(View asc){
        cardVodka2.setVisibility(View.GONE);
        cardAddVodka2.setVisibility(View.VISIBLE);
    }
    public void addVodka3(View asc){
        cardVodka3.setVisibility(View.GONE);
        cardAddVodka3.setVisibility(View.VISIBLE);
    }
    public void addVodka4(View asc){
        cardVodka4.setVisibility(View.GONE);
        cardAddVodka4.setVisibility(View.VISIBLE);
    }
    public void retVodka1(View asc){
        cardVodka1.setVisibility(View.VISIBLE);
        cardAddVodka1.setVisibility(View.GONE);
    }
    public void retVodka2(View asc){
        cardVodka2.setVisibility(View.VISIBLE);
        cardAddVodka2.setVisibility(View.GONE);
    }
    public void retVodka3(View asc){
        cardVodka3.setVisibility(View.VISIBLE);
        cardAddVodka3.setVisibility(View.GONE);
    }
    public void retVodka4(View asc){
        cardVodka4.setVisibility(View.VISIBLE);
        cardAddVodka4.setVisibility(View.GONE);
    }

    // onclick gin
    public void addGin1(View asc){
        cardGin1.setVisibility(View.GONE);
        cardAddGin1.setVisibility(View.VISIBLE);
    }
    public void addGin2(View asc){
        cardGin2.setVisibility(View.GONE);
        cardAddGin2.setVisibility(View.VISIBLE);
    }
    public void addGin3(View asc){
        cardGin3.setVisibility(View.GONE);
        cardAddGin3.setVisibility(View.VISIBLE);
    }
    public void retGin1(View asc){
        cardGin1.setVisibility(View.VISIBLE);
        cardAddGin1.setVisibility(View.GONE);
    }
    public void retGin2(View asc){
        cardGin2.setVisibility(View.VISIBLE);
        cardAddGin2.setVisibility(View.GONE);
    }
    public void retGin3(View asc){
        cardGin3.setVisibility(View.VISIBLE);
        cardAddGin3.setVisibility(View.GONE);
    }

    // onclick cachaça
    public void addCachaca1(View asc){
        cardCachaca1.setVisibility(View.GONE);
        cardAddCachaca1.setVisibility(View.VISIBLE);
    }
    public void addCachaca2(View asc){
        cardCachaca2.setVisibility(View.GONE);
        cardAddCachaca2.setVisibility(View.VISIBLE);
    }
    public void addCachaca3(View asc){
        cardCachaca3.setVisibility(View.GONE);
        cardAddCachaca3.setVisibility(View.VISIBLE);
    }
    public void retCachaca1(View asc){
        cardCachaca1.setVisibility(View.VISIBLE);
        cardAddCachaca1.setVisibility(View.GONE);
    }
    public void retCachaca2(View asc){
        cardCachaca2.setVisibility(View.VISIBLE);
        cardAddCachaca2.setVisibility(View.GONE);
    }
    public void retCachaca3(View asc){
        cardCachaca3.setVisibility(View.VISIBLE);
        cardAddCachaca3.setVisibility(View.GONE);
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