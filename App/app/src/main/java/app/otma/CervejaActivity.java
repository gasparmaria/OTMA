package app.otma;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.otma.databinding.ActivityCervejaBinding;

public class CervejaActivity extends AppCompatActivity {

    public LinearLayout cardSkol1, cardSkol2, cardSkol3, cardSkol4, cardSkol5, cardSkol6, cardAddSkol1, cardAddSkol2, cardAddSkol3, cardAddSkol4, cardAddSkol5, cardAddSkol6;
    public LinearLayout cardBrahma1, cardBrahma2, cardBrahma3, cardBrahma4, cardBrahma5, cardAddBrahma1, cardAddBrahma2, cardAddBrahma3, cardAddBrahma4, cardAddBrahma5;
    public LinearLayout cardHeineken1, cardHeineken2, cardHeineken3, cardAddHeineken1, cardAddHeineken2, cardAddHeineken3;
    public LinearLayout cardStella1, cardStella2, cardStella3, cardAddStella1, cardAddStella2, cardAddStella3;
    public LinearLayout cardColorado1, cardColorado2, cardColorado3, cardColorado4, cardAddColorado1, cardAddColorado2, cardAddColorado3, cardAddColorado4;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerveja);

        toolbar = findViewById(R.id.app_Bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

        // cards skol
        cardSkol1 = (LinearLayout) findViewById(R.id.cardSkol1);
        cardAddSkol1 = (LinearLayout) findViewById(R.id.cardSkol1_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol2);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol2_0);
        cardSkol3 = (LinearLayout) findViewById(R.id.cardSkol3);
        cardAddSkol3 = (LinearLayout) findViewById(R.id.cardSkol3_0);
        cardSkol4 = (LinearLayout) findViewById(R.id.cardSkol4);
        cardAddSkol4 = (LinearLayout) findViewById(R.id.cardSkol4_0);
        cardSkol5 = (LinearLayout) findViewById(R.id.cardSkol5);
        cardAddSkol5 = (LinearLayout) findViewById(R.id.cardSkol5_0);
        cardSkol6 = (LinearLayout) findViewById(R.id.cardSkol6);
        cardAddSkol6 = (LinearLayout) findViewById(R.id.cardSkol6_0);
        // cards brahma
        cardBrahma1 = (LinearLayout) findViewById(R.id.cardBrahma1);
        cardAddBrahma1 = (LinearLayout) findViewById(R.id.cardBrahma1_0);
        cardBrahma2 = (LinearLayout) findViewById(R.id.cardBrahma2);
        cardAddBrahma2 = (LinearLayout) findViewById(R.id.cardBrahma2_0);
        cardBrahma3 = (LinearLayout) findViewById(R.id.cardBrahma3);
        cardAddBrahma3 = (LinearLayout) findViewById(R.id.cardBrahma3_0);
        cardBrahma4 = (LinearLayout) findViewById(R.id.cardBrahma4);
        cardAddBrahma4 = (LinearLayout) findViewById(R.id.cardBrahma4_0);
        cardBrahma5 = (LinearLayout) findViewById(R.id.cardBrahma5);
        cardAddBrahma5 = (LinearLayout) findViewById(R.id.cardBrahma5_0);
        // cards heineken
        cardHeineken1 = (LinearLayout) findViewById(R.id.cardHeineken1);
        cardAddHeineken1 = (LinearLayout) findViewById(R.id.cardHeineken1_0);
        cardHeineken2 = (LinearLayout) findViewById(R.id.cardHeineken2);
        cardAddHeineken2 = (LinearLayout) findViewById(R.id.cardHeineken2_0);
        cardHeineken3 = (LinearLayout) findViewById(R.id.cardHeineken3);
        cardAddHeineken3 = (LinearLayout) findViewById(R.id.cardHeineken3_0);
        // cards stella
        cardStella1 = (LinearLayout) findViewById(R.id.cardStella1);
        cardAddStella1 = (LinearLayout) findViewById(R.id.cardStella1_0);
        cardStella2 = (LinearLayout) findViewById(R.id.cardStella2);
        cardAddStella2 = (LinearLayout) findViewById(R.id.cardStella2_0);
        cardStella3 = (LinearLayout) findViewById(R.id.cardStella3);
        cardAddStella3 = (LinearLayout) findViewById(R.id.cardStella3_0);
        // cards colorado
        cardColorado1 = (LinearLayout) findViewById(R.id.cardColorado1);
        cardAddColorado1 = (LinearLayout) findViewById(R.id.cardColorado1_0);
        cardColorado2 = (LinearLayout) findViewById(R.id.cardColorado2);
        cardAddColorado2 = (LinearLayout) findViewById(R.id.cardColorado2_0);
        cardColorado3 = (LinearLayout) findViewById(R.id.cardColorado3);
        cardAddColorado3 = (LinearLayout) findViewById(R.id.cardColorado3_0);
        cardColorado4 = (LinearLayout) findViewById(R.id.cardColorado4);
        cardAddColorado4 = (LinearLayout) findViewById(R.id.cardColorado4_0);
    }

    // onclick skol
    public void addSkol1(View asc){
        cardSkol1.setVisibility(View.GONE);
        cardAddSkol1.setVisibility(View.VISIBLE);
    }
    public void addSkol2(View asc){
        cardSkol2.setVisibility(View.GONE);
        cardAddSkol2.setVisibility(View.VISIBLE);
    }
    public void addSkol3(View asc){
        cardSkol3.setVisibility(View.GONE);
        cardAddSkol3.setVisibility(View.VISIBLE);
    }
    public void addSkol4(View asc){
        cardSkol4.setVisibility(View.GONE);
        cardAddSkol4.setVisibility(View.VISIBLE);
    }
    public void addSkol5(View asc){
        cardSkol5.setVisibility(View.GONE);
        cardAddSkol5.setVisibility(View.VISIBLE);
    }
    public void addSkol6(View asc){
        cardSkol6.setVisibility(View.GONE);
        cardAddSkol6.setVisibility(View.VISIBLE);
    }

    // onclick brahma
    public void addBrahma1(View asc){
        cardBrahma1.setVisibility(View.GONE);
        cardAddBrahma1.setVisibility(View.VISIBLE);
    }
    public void addBrahma2(View asc){
        cardBrahma2.setVisibility(View.GONE);
        cardAddBrahma2.setVisibility(View.VISIBLE);
    }
    public void addBrahma3(View asc){
        cardBrahma3.setVisibility(View.GONE);
        cardAddBrahma3.setVisibility(View.VISIBLE);
    }
    public void addBrahma4(View asc){
        cardBrahma4.setVisibility(View.GONE);
        cardAddBrahma4.setVisibility(View.VISIBLE);
    }
    public void addBrahma5(View asc){
        cardBrahma5.setVisibility(View.GONE);
        cardAddBrahma5.setVisibility(View.VISIBLE);
    }

    // onclick heineken
    public void addHeineken1(View asc){
        cardHeineken1.setVisibility(View.GONE);
        cardAddHeineken1.setVisibility(View.VISIBLE);
    }
    public void addHeineken2(View asc){
        cardHeineken2.setVisibility(View.GONE);
        cardAddHeineken2.setVisibility(View.VISIBLE);
    }
    public void addHeineken3(View asc){
        cardHeineken3.setVisibility(View.GONE);
        cardAddHeineken3.setVisibility(View.VISIBLE);
    }

    // onclick stella
    public void addStella1(View asc){
        cardStella1.setVisibility(View.GONE);
        cardAddStella1.setVisibility(View.VISIBLE);
    }
    public void addStella2(View asc){
        cardStella2.setVisibility(View.GONE);
        cardAddStella2.setVisibility(View.VISIBLE);
    }
    public void addStella3(View asc){
        cardStella3.setVisibility(View.GONE);
        cardAddStella3.setVisibility(View.VISIBLE);
    }

    // onclick colorado
    public void addColorado1(View asc){
        cardColorado1.setVisibility(View.GONE);
        cardAddColorado1.setVisibility(View.VISIBLE);
    }
    public void addColorado2(View asc){
        cardColorado2.setVisibility(View.GONE);
        cardAddColorado2.setVisibility(View.VISIBLE);
    }
    public void addColorado3(View asc){
        cardColorado3.setVisibility(View.GONE);
        cardAddColorado3.setVisibility(View.VISIBLE);
    }
    public void addColorado4(View asc){
        cardColorado4.setVisibility(View.GONE);
        cardAddColorado4.setVisibility(View.VISIBLE);
    }

}