package app.otma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SemAlcoolActivity extends AppCompatActivity {

    public LinearLayout cardRefri1, cardRefri2, cardRefri3, cardRefri4, cardRefri5, cardAddRefri1, cardAddRefri2, cardAddRefri3, cardAddRefri4, cardAddRefri5;
    public LinearLayout cardSuco1, cardSuco2, cardSuco3, cardAddSuco1, cardAddSuco2, cardAddSuco3;
    public LinearLayout cardAgua1, cardAgua2, cardAddAgua1, cardAddAgua2;
    public LinearLayout cardEnerg1, cardEnerg2, cardEnerg3, cardAddEnerg1, cardAddEnerg2, cardAddEnerg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_alcool);

        // cards refrigerante
        cardRefri1 = (LinearLayout) findViewById(R.id.cardRefri1);
        cardAddRefri1 = (LinearLayout) findViewById(R.id.cardRefri1_0);
        cardRefri2 = (LinearLayout) findViewById(R.id.cardRefri2);
        cardAddRefri2 = (LinearLayout) findViewById(R.id.cardRefri2_0);
        cardRefri3 = (LinearLayout) findViewById(R.id.cardRefri3);
        cardAddRefri3 = (LinearLayout) findViewById(R.id.cardRefri3_0);
        cardRefri4 = (LinearLayout) findViewById(R.id.cardRefri4);
        cardAddRefri4 = (LinearLayout) findViewById(R.id.cardRefri4_0);
        cardRefri5 = (LinearLayout) findViewById(R.id.cardRefri5);
        cardAddRefri5 = (LinearLayout) findViewById(R.id.cardRefri5_0);
        // cards suco
        cardSuco1 = (LinearLayout) findViewById(R.id.cardSuco1);
        cardAddSuco1 = (LinearLayout) findViewById(R.id.cardSuco1_0);
        cardSuco2 = (LinearLayout) findViewById(R.id.cardSuco2);
        cardAddSuco2 = (LinearLayout) findViewById(R.id.cardSuco2_0);
        cardSuco3 = (LinearLayout) findViewById(R.id.cardSuco3);
        cardAddSuco3 = (LinearLayout) findViewById(R.id.cardSuco3_0);
        // cards água
        cardAgua1 = (LinearLayout) findViewById(R.id.cardAgua1);
        cardAddAgua1 = (LinearLayout) findViewById(R.id.cardAgua1_0);
        cardAgua2 = (LinearLayout) findViewById(R.id.cardAgua2);
        cardAddAgua2 = (LinearLayout) findViewById(R.id.cardAgua2_0);
        // cards energético
        cardEnerg1 = (LinearLayout) findViewById(R.id.cardEnerg1);
        cardAddEnerg1 = (LinearLayout) findViewById(R.id.cardEnerg1_0);
        cardEnerg2 = (LinearLayout) findViewById(R.id.cardEnerg2);
        cardAddEnerg2 = (LinearLayout) findViewById(R.id.cardEnerg2_0);
        cardEnerg3 = (LinearLayout) findViewById(R.id.cardEnerg3);
        cardAddEnerg3 = (LinearLayout) findViewById(R.id.cardEnerg3_0);
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
}