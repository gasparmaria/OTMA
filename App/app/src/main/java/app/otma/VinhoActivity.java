package app.otma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class VinhoActivity extends AppCompatActivity {

    public LinearLayout cardTinto1, cardTinto2, cardTinto3, cardTinto4, cardTinto5, cardAddTinto1, cardAddTinto2, cardAddTinto3, cardAddTinto4, cardAddTinto5;
    public LinearLayout cardBranco1, cardBranco2, cardBranco3, cardBranco4, cardAddBranco1, cardAddBranco2, cardAddBranco3, cardAddBranco4;
    public LinearLayout cardRose1, cardRose2, cardRose3, cardAddRose1, cardAddRose2, cardAddRose3;
    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public ScrollView contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinho);

        contentView=findViewById(R.id.content_layout_vinho);
        navigationView=findViewById(R.id.NavigationView);
        drawerLayout=findViewById(R.id.DrawerLayout);
        toolbar = findViewById(R.id.app_Bar);

        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.iteminicio:
                    Toast.makeText(VinhoActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                    openNextActivity("Index");
                    return true;
                case R.id.categoria_cerveja:
                    Toast.makeText(VinhoActivity.this, "Cerveja", Toast.LENGTH_SHORT).show();
                    openNextActivity("Cerveja");
                    return true;
                case R.id.categoria_vinho:
                    Toast.makeText(VinhoActivity.this, "Vinhos", Toast.LENGTH_SHORT).show();
                    openNextActivity("Vinhos");
                    return true;
                case R.id.categoria_destilados:
                    Toast.makeText(VinhoActivity.this, "Destilados", Toast.LENGTH_SHORT).show();
                    openNextActivity("Destilados");
                    return true;
                case R.id.categoria_semAlcool:
                    Toast.makeText(VinhoActivity.this, "Sem Álcool", Toast.LENGTH_SHORT).show();
                    openNextActivity("SemAlcool");
                    return true;
                case R.id.itemcarrinho:
                    Toast.makeText(VinhoActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
                    openNextActivity("Carrinho");
                    return true;
                case R.id.itemsair:
                    Toast.makeText(VinhoActivity.this, "Sair", Toast.LENGTH_SHORT).show();
                    openNextActivity("Sair");
                    return true;
            }
            return true;
        });

        // cards tinto
        cardTinto1 = (LinearLayout) findViewById(R.id.cardTinto1);
        cardAddTinto1 = (LinearLayout) findViewById(R.id.cardTinto1_0);
        cardTinto2 = (LinearLayout) findViewById(R.id.cardTinto2);
        cardAddTinto2 = (LinearLayout) findViewById(R.id.cardTinto2_0);
        cardTinto3 = (LinearLayout) findViewById(R.id.cardTinto3);
        cardAddTinto3 = (LinearLayout) findViewById(R.id.cardTinto3_0);
        cardTinto4 = (LinearLayout) findViewById(R.id.cardTinto4);
        cardAddTinto4 = (LinearLayout) findViewById(R.id.cardTinto4_0);
        cardTinto5 = (LinearLayout) findViewById(R.id.cardTinto5);
        cardAddTinto5 = (LinearLayout) findViewById(R.id.cardTinto5_0);
        // cards branco
        cardBranco1 = (LinearLayout) findViewById(R.id.cardBranco1);
        cardAddBranco1 = (LinearLayout) findViewById(R.id.cardBranco1_0);
        cardBranco2 = (LinearLayout) findViewById(R.id.cardBranco2);
        cardAddBranco2 = (LinearLayout) findViewById(R.id.cardBranco2_0);
        cardBranco3 = (LinearLayout) findViewById(R.id.cardBranco3);
        cardAddBranco3 = (LinearLayout) findViewById(R.id.cardBranco3_0);
        cardBranco4 = (LinearLayout) findViewById(R.id.cardBranco4);
        cardAddBranco4 = (LinearLayout) findViewById(R.id.cardBranco4_0);
        // cards rose
        cardRose1 = (LinearLayout) findViewById(R.id.cardRose1);
        cardAddRose1 = (LinearLayout) findViewById(R.id.cardRose1_0);
        cardRose2 = (LinearLayout) findViewById(R.id.cardRose2);
        cardAddRose2 = (LinearLayout) findViewById(R.id.cardRose2_0);
        cardRose3 = (LinearLayout) findViewById(R.id.cardRose3);
        cardAddRose3 = (LinearLayout) findViewById(R.id.cardRose3_0);
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
        } else if(value == "SemAlcool"){
            intent = new Intent(getApplicationContext(), SemAlcoolActivity.class);
        }
        startActivity(intent);
    }

    // onclick tinto
    public void addTinto1(View asc){
        cardTinto1.setVisibility(View.GONE);
        cardAddTinto1.setVisibility(View.VISIBLE);
    }
    public void addTinto2(View asc){
        cardTinto2.setVisibility(View.GONE);
        cardAddTinto2.setVisibility(View.VISIBLE);
    }
    public void addTinto3(View asc){
        cardTinto3.setVisibility(View.GONE);
        cardAddTinto3.setVisibility(View.VISIBLE);
    }
    public void addTinto4(View asc){
        cardTinto4.setVisibility(View.GONE);
        cardAddTinto4.setVisibility(View.VISIBLE);
    }
    public void addTinto5(View asc){
        cardTinto5.setVisibility(View.GONE);
        cardAddTinto5.setVisibility(View.VISIBLE);
    }
    public void retTinto1(View asc){
        cardTinto1.setVisibility(View.VISIBLE);
        cardAddTinto1.setVisibility(View.GONE);
    }
    public void retTinto2(View asc){
        cardTinto2.setVisibility(View.VISIBLE);
        cardAddTinto2.setVisibility(View.GONE);
    }
    public void retTinto3(View asc){
        cardTinto3.setVisibility(View.VISIBLE);
        cardAddTinto3.setVisibility(View.GONE);
    }
    public void retTinto4(View asc){
        cardTinto4.setVisibility(View.VISIBLE);
        cardAddTinto4.setVisibility(View.GONE);
    }
    public void retTinto5(View asc){
        cardTinto5.setVisibility(View.VISIBLE);
        cardAddTinto5.setVisibility(View.GONE);
    }

    // onclick branco
    public void addBranco1(View asc){
        cardBranco1.setVisibility(View.GONE);
        cardAddBranco1.setVisibility(View.VISIBLE);
    }
    public void addBranco2(View asc){
        cardBranco2.setVisibility(View.GONE);
        cardAddBranco2.setVisibility(View.VISIBLE);
    }
    public void addBranco3(View asc){
        cardBranco3.setVisibility(View.GONE);
        cardAddBranco3.setVisibility(View.VISIBLE);
    }
    public void addBranco4(View asc){
        cardBranco4.setVisibility(View.GONE);
        cardAddBranco4.setVisibility(View.VISIBLE);
    }
    public void retBranco1(View asc){
        cardBranco1.setVisibility(View.VISIBLE);
        cardAddBranco1.setVisibility(View.GONE);
    }
    public void retBranco2(View asc){
        cardBranco2.setVisibility(View.VISIBLE);
        cardAddBranco2.setVisibility(View.GONE);
    }
    public void retBranco3(View asc){
        cardBranco3.setVisibility(View.VISIBLE);
        cardAddBranco3.setVisibility(View.GONE);
    }
    public void retBranco4(View asc){
        cardBranco4.setVisibility(View.VISIBLE);
        cardAddBranco4.setVisibility(View.GONE);
    }

    // onclick rose
    public void addRose1(View asc){
        cardRose1.setVisibility(View.GONE);
        cardAddRose1.setVisibility(View.VISIBLE);
    }
    public void addRose2(View asc){
        cardRose2.setVisibility(View.GONE);
        cardAddRose2.setVisibility(View.VISIBLE);
    }
    public void addRose3(View asc){
        cardRose3.setVisibility(View.GONE);
        cardAddRose3.setVisibility(View.VISIBLE);
    }
    public void retRose1(View asc){
        cardRose1.setVisibility(View.VISIBLE);
        cardAddRose1.setVisibility(View.GONE);
    }
    public void retRose2(View asc){
        cardRose2.setVisibility(View.VISIBLE);
        cardAddRose2.setVisibility(View.GONE);
    }
    public void retRose3(View asc){
        cardRose3.setVisibility(View.VISIBLE);
        cardAddRose3.setVisibility(View.GONE);
    }
}