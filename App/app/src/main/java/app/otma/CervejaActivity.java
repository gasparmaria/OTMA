package app.otma;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.LinearLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.otma.databinding.ActivityCervejaBinding;

public class CervejaActivity extends AppCompatActivity {

    public LinearLayout card;
    public LinearLayout cardAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerveja);
        card = (LinearLayout) findViewById(R.id.cardSkol1);
        cardAdd = (LinearLayout) findViewById(R.id.cardSkol0);
    }

    public void adSkol1(View asc){
        card.setVisibility(View.GONE);
        cardAdd.setVisibility(View.VISIBLE);
    }
}