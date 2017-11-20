package info.App.VaniteaPOS.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import info.App.VaniteaPOS.R;
import info.App.VaniteaPOS.m_MySQL.Downloader;


public class Main extends Activity {
    final static String urlAddress="http://192.168.254.101/PHP-FILES/ricemeals.php";
    final static String urlAddress2="http://192.168.254.101/PHP-FILES/unlimeals.php";
    final static String urlAddress3="http://192.168.254.101/PHP-FILES/barkadabundle.php";
    final static String urlAddress4="http://192.168.254.101/PHP-FILES/pasta.php";
    final static String urlAddress5="http://192.168.254.101/PHP-FILES/combomeals.php";
    final static String urlAddress6="http://192.168.254.101/PHP-FILES/sandwich.php";
    final static String urlAddress7="http://192.168.254.101/PHP-FILES/hotdrink.php";
    final static String urlAddress8="http://192.168.254.101/PHP-FILES/snacks.php";




    Button log_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        final GridView gv = ( GridView ) findViewById(R.id.gv);
        new Downloader(Main.this, urlAddress, gv).execute();


//Rice meal menu
        final ImageButton a = ( ImageButton ) findViewById(R.id.btnricemeals);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress, gv).execute();

            }
        });


//Unli meals
        ImageButton btnunlimeals = ( ImageButton ) findViewById(R.id.btnunlimeals);
        btnunlimeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress2, gv).execute();
            }
        });


//Barkada Bundle
        ImageButton btnbbundles = ( ImageButton ) findViewById(R.id.btnbbundles);
        btnbbundles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress3, gv).execute();
            }
        });

        //Pasta menu
        ImageButton btnpasta = ( ImageButton ) findViewById(R.id.btnpastas);
        btnpasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress4, gv).execute();
            }
        });

        //Combomeals
        ImageButton btncombo = ( ImageButton ) findViewById(R.id.btncombo);
        btncombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress5, gv).execute();
            }
        });

        //Sandwiches
        ImageButton btnsandwich = ( ImageButton ) findViewById(R.id.btnsandwich);
        btnsandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress6, gv).execute();
            }
        });

        //Hotdrinks
        ImageButton btnhotdrink = ( ImageButton ) findViewById(R.id.btnhotdrinks);
        btnhotdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress7, gv).execute();
            }
        });
        //Snacks
        ImageButton btnsnacks = ( ImageButton ) findViewById(R.id.btnsnacks);
        btnsnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(Main.this, urlAddress8, gv).execute();
            }
        });


// Logout
        log_out = ( Button ) findViewById(R.id.btnLogout);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }}