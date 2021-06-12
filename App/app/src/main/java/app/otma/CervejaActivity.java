package app.otma;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.otma.databinding.ActivityCervejaBinding;

public class CervejaActivity extends AppCompatActivity {

    public LinearLayout cardSkol1, cardSkol2, cardSkol3, cardSkol4, cardSkol5, cardSkol6;
    public LinearLayout cardAddSkol1, cardAddSkol2, cardAddSkol3, cardAddSkol4, cardAddSkol5, cardAddSkol6;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerveja);

        setSupportActionBar(findViewById(R.id.app_Bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

        cardSkol1 = (LinearLayout) findViewById(R.id.cardSkol1);
        cardAddSkol1 = (LinearLayout) findViewById(R.id.cardSkol1_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol2);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol2_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol3);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol3_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol4);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol4_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol5);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol5_0);
        cardSkol2 = (LinearLayout) findViewById(R.id.cardSkol6);
        cardAddSkol2 = (LinearLayout) findViewById(R.id.cardSkol6_0);
    }

    public void adSkol1(View asc){
        cardSkol1.setVisibility(View.GONE);
        cardAddSkol1.setVisibility(View.VISIBLE);
    }
    public void adSkol2(View asc){
        cardSkol2.setVisibility(View.GONE);
        cardAddSkol2.setVisibility(View.VISIBLE);
    }
    public void adSkol3(View asc){
        cardSkol3.setVisibility(View.GONE);
        cardAddSkol3.setVisibility(View.VISIBLE);
    }
    public void adSkol4(View asc){
        cardSkol4.setVisibility(View.GONE);
        cardAddSkol4.setVisibility(View.VISIBLE);
    }
    public void adSkol5(View asc){
        cardSkol5.setVisibility(View.GONE);
        cardAddSkol5.setVisibility(View.VISIBLE);
    }
    public void adSkol6(View asc){
        cardSkol6.setVisibility(View.GONE);
        cardAddSkol6.setVisibility(View.VISIBLE);
    }
}