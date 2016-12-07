package com.kroghpedersen.anettes_sandwich2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Menu4_meatpick extends AppCompatActivity {

    ListView lw;
    List<ChoiceObj> choiceObjList;

    FloatingActionButton back_btn;
    TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu4_meatpick);


        choiceObjList = new ArrayList<ChoiceObj>();

        // Set list with valid choices
        choiceObjList.add(new ChoiceObj("Kylling", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kylling)));
        choiceObjList.add(new ChoiceObj("Æg", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.aeg)));
        choiceObjList.add(new ChoiceObj("Laks", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.laks)));
        choiceObjList.add(new ChoiceObj("Rejer", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.rejer)));


        lw = (ListView) findViewById(R.id.menu4_choice_lw);
        RandomAdapter RA = new RandomAdapter(getApplicationContext(),choiceObjList);

        lw.setAdapter(RA);


        // set text font
        title_tv = (TextView) findViewById(R.id.menu4_title_tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        title_tv.setTypeface(font);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), Menu5_extrapick.class);
                startActivity(nextStepIntent);
            }
        });

        // Back button
        back_btn = (FloatingActionButton) findViewById(R.id.menu4_meatpick_fab);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

