package app.otma;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DestiladoActivity extends AppCompatActivity {

    public LinearLayout cardBeats1, cardBeats2, cardBeats3, cardBeats4, cardBeats5, cardBeats6, cardBeats7, cardAddBeats1, cardAddBeats2, cardAddBeats3, cardAddBeats4, cardAddBeats5, cardAddBeats6, cardAddBeats7;
    public LinearLayout cardWhisky1, cardWhisky2, cardWhisky3, cardWhisky4, cardAddWhisky1, cardAddWhisky2, cardAddWhisky3, cardAddWhisky4;
    public Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destilado);

        toolbar = findViewById(R.id.app_Bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menuicon);

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
}