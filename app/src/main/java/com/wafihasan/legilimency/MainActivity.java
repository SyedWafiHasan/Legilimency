package com.wafihasan.legilimency;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}