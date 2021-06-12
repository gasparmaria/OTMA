package app.otma;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    public LinearLayout cardCerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.NavigationView);
        drawerLayout=findViewById(R.id.DrawerLayout);
        toolbar=findViewById(R.id.app_Bar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId())
            {
                case R.id.iteminicio:
                    Toast.makeText(MainActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    openIndex();
                    return true;
                case R.id.categoria_cerveja:
                    Toast.makeText(MainActivity.this, "Categorias", Toast.LENGTH_SHORT).show();
                    openCerveja();
                    return true;
                case R.id.itemcarrinho:
                    Toast.makeText(MainActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
                    openCarrinho();
                    return true;
                case R.id.itemsair:
                    Toast.makeText(MainActivity.this, "Sair", Toast.LENGTH_SHORT).show();
                    openLogin();
                    return true;
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openIndex()
    {
        Intent intent = new Intent(getApplicationContext(), IndexActivity.class);
        startActivity(intent);
    }
    public void openCerveja()
    {
        Intent intent = new Intent(getApplicationContext(), CervejaActivity.class);
        startActivity(intent);
    }
    public void openCarrinho()
    {
        Intent intent = new Intent(getApplicationContext(), CarrinhoActivity.class);
        startActivity(intent);
    }
    public void openLogin()
    {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}