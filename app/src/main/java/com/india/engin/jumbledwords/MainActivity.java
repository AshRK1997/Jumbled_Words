package com.india.engin.jumbledwords;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void easy(View view) {
        Intent i = new Intent(MainActivity.this, Play.class);
        i.putExtra("difficulty","1");
        startActivity(i);
    }

    public void med(View view) {
        Intent i = new Intent(MainActivity.this, Play.class);
        i.putExtra("difficulty","2");
        startActivity(i);
    }

    public void diffi(View view) {
        Intent i = new Intent(MainActivity.this, Play.class);
        i.putExtra("difficulty","3");
        startActivity(i);
    }

    public void feedback(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.setPackage("com.google.android.gm");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"engin.mysuru@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback - Jumbly Jumbler");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void report(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.setPackage("com.google.android.gm");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"engin.mysuru@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Bug Report - Jumbly Jumbler");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
    public void helper(View view) {

    }

    public void share(View view) {
        Intent ShareingIntent = new Intent(Intent.ACTION_SEND);
        ShareingIntent.setType("text/plain");
        ShareingIntent.putExtra(Intent.EXTRA_TEXT, "A simple game to pass your time and improve your vocab!!" + "\n" + "Here is Jumbly Jumbler" + "\n" + " To download" + "\n" + "https://this_is_not_a_link");
        startActivity(ShareingIntent);
    }
    


}
