package com.wafihasan.legilimency;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    String []a = {"Think of a number", "Double it", "Add","Divide it by 2", "Subtract the original number"};
    int x = a.length;
    String t = "To it";
    int c = 0;
    int j = 0;

    public int random()
    {
        Random r = new Random();
        return r.nextInt(51)*2;
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

        tv1.setText(R.string.start);
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
                tv2.setText(R.string.click_continue);
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
                    tv1.setText(R.string.number_mind);
                    tv3.setText(Integer.toString((j/2)));
                    tv2.setText(R.string.try_again);
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

        Typeface pacman = Typeface.createFromAsset(getAssets(),"fonts/pacman.ttf");
        Typeface less = Typeface.createFromAsset(getAssets(),"fonts/less.ttf");

        if(item.getItemId() == R.id.about)
        {
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            View v = getLayoutInflater().inflate(R.layout.custom_about_dialog, null);

            ImageView iv = (ImageView)v.findViewById(R.id.imageView2);
            TextView tv5 = (TextView)v.findViewById(R.id.heading);
            TextView tv6 = (TextView)v.findViewById(R.id.actual_text);

            tv5.setTypeface(pacman);
            tv6.setTypeface(less);

            ad.setView(v);
            ad.show();
        }
        else if(item.getItemId() == R.id.contact)
        {
            AlertDialog.Builder ad1 = new AlertDialog.Builder(MainActivity.this);
            View v1 = getLayoutInflater().inflate(R.layout.custom_contact_dialog, null);

            ImageView iv2 = (ImageView)v1.findViewById(R.id.imageView2);
            TextView tv7 = (TextView)v1.findViewById(R.id.contact_heading);
            TextView tv8 = (TextView)v1.findViewById(R.id.actual_text_contact);
            TextView tv9 = (TextView)v1.findViewById(R.id.fb);
            TextView tv10 = (TextView)v1.findViewById(R.id.insta);
            TextView tv11 = (TextView)v1.findViewById(R.id.mail);

            tv7.setTypeface(pacman);
            tv8.setTypeface(less);
            tv9.setTypeface(less);
            tv10.setTypeface(less);
            tv11.setTypeface(less);

            tv10.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(MainActivity.this, "Instagram doesn't support opening profiles directly. Only posts. You can click my name on the top to contact me.", Toast.LENGTH_LONG).show();
                }
            });

            ad1.setView(v1);
            ad1.show();
        }
        return super.onOptionsItemSelected(item);
    }
}