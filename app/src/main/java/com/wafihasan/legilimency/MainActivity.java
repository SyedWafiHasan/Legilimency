package com.wafihasan.legilimency;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    String []a = {"Think of a number", "Double it", "Add","Divide it by 2", "Subtract the original number"};
    int x = a.length;
    String t = "To it.";
    int c = 0;
    int j = 0;

    public int random()
    {
        Random r = new Random();
        int n = r.nextInt(51)*2;
        return n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv1 = (TextView)findViewById(R.id.tv1);
        final TextView tv2 = (TextView)findViewById(R.id.tv2);
        final TextView tv3 = (TextView)findViewById(R.id.tv3);
        final TextView tv4 = (TextView)findViewById(R.id.tv4);

        tv1.setText("Click to start");
        tv3.setText("");
        tv4.setText("");

        Typeface pacman = Typeface.createFromAsset(getAssets(),"fonts/pacman.ttf");
        Typeface less = Typeface.createFromAsset(getAssets(),"fonts/less.ttf");

        tv1.setTypeface(less);
        tv2.setTypeface(pacman);
        tv3.setTypeface(less);
        tv4.setTypeface(less);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        LinearLayout lin = (LinearLayout)findViewById(R.id.lin);
        lin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View lin)
            {
                tv2.setText("Click to continue");
                if(c == 2)
                {
                    tv1.setText(a[c]);
                    j = random();
                    tv3.setText(Integer.toString(j));
                    tv4.setText(t);
                    c += 1;
                }
                else if (c == x)
                {
                    c = 0;
                    tv1.setText("The number in your mind is");
                    tv3.setText(Integer.toString((j/2)));
                    tv2.setText("Click to try again");
                }
                else
                {
                    tv1.setText(a[c]);
                    tv3.setText("");
                    tv4.setText("");
                    c += 1;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
        if(item.getItemId() == R.id.about)
        {
            ad.setIcon(R.mipmap.ic_launcher);
            ad.setTitle("About The Developer");
            ad.setMessage("Developed by Wafi Hasan.\nA student and tech enthusiast.");
            AlertDialog ad1 = ad.create();
            ad1.show();
        }
        else if(item.getItemId() == R.id.contact)
        {
            ad.setIcon(R.mipmap.ic_launcher);
            ad.setTitle("Contact the Developer");
            ad.setMessage("You can reach the developer at :\n\nfacebook.com/syedwafihasan\n\ninstagram.com/syedwafihasan\n\nsyedwafihasan@gmail.com\n\n+918299841298\n\n+917071769357");
            AlertDialog ad1 = ad.create();
            ad1.show();
        }
        return super.onOptionsItemSelected(item);
    }
}