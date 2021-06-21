package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ScrollView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.NavigationView);
        drawerLayout = findViewById(R.id.DrawerLayout);
        toolbar = findViewById(R.id.app_Bar);
        contentView = findViewById(R.id.content_layout_main);

        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
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
                    openNextActivity("Cervejas");
                    return true;
                case R.id.categoria_vinho:
                    Toast.makeText(MainActivity.this, "Vinho", Toast.LENGTH_SHORT).show();
                    openNextActivity("Vinhos");
                    return true;
                case R.id.categoria_destilados:
                    Toast.makeText(MainActivity.this, "Destilado", Toast.LENGTH_SHORT).show();
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
        new Handler().postDelayed(() -> {
            contentView.setVisibility(View.VISIBLE);
        }, 200);

    }


    public void openCerveja(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CervejaActivity.class);
        startActivity(intent);
    }
    public void openDestilado(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DestiladoActivity.class);
        startActivity(intent);
    }
    public void openVinho(View view)
    {
        Intent intent = new Intent(getApplicationContext(), VinhoActivity.class);
        startActivity(intent);
    }
    public void openSemAlcool(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SemAlcoolActivity.class);
        startActivity(intent);
    }

    public void openNextActivity(String value) {
        Intent intent = new Intent();

        if (value == "Index") {
            intent = new Intent(getApplicationContext(), MainActivity.class);
        } else if (value == "Cerveja") {
            intent = new Intent(getApplicationContext(), CervejaActivity.class);
        } else if (value == "Vinhos") {
            intent = new Intent(getApplicationContext(), VinhoActivity.class);
        } else if (value == "Destilados") {
            intent = new Intent(getApplicationContext(), DestiladoActivity.class);
        } else if (value == "Carrinho") {
            intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
        } else if (value == "Sair") {
            intent = new Intent(getApplicationContext(), LoginActivity.class);
        }
        else if(value == "SemAlcool")
        {
            intent = new Intent(getApplicationContext(), SemAlcoolActivity.class);
        }
        startActivity(intent);
    }
}