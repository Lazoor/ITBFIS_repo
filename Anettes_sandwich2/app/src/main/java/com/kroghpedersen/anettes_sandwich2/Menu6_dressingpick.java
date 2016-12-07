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

public class Menu6_dressingpick extends AppCompatActivity {

    ListView lw;
    List<ChoiceObj> choiceObjList;

    TextView title_tv;
    FloatingActionButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu6_dressingpick);


        choiceObjList = new ArrayList<ChoiceObj>();

        // Set list with valid choices
        choiceObjList.add(new ChoiceObj("Hjemmelavet Mayo", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.mayo)));
        choiceObjList.add(new ChoiceObj("Ketchup", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ketchup)));
        choiceObjList.add(new ChoiceObj("Karry", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.karry)));
        choiceObjList.add(new ChoiceObj("Ingen Dressing", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.nosaladdressing)));


        lw = (ListView) findViewById(R.id.menu6_choice_lw);
        RandomAdapter RA = new RandomAdapter(getApplicationContext(),choiceObjList);

        lw.setAdapter(RA);

        // set text font
        title_tv = (TextView) findViewById(R.id.menu6_title_tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        title_tv.setTypeface(font);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), Menu7_drinkpick.class);
                startActivity(nextStepIntent);
            }
        });

        // Back button
        back_btn = (FloatingActionButton) findViewById(R.id.menu6_dressingpick_fab);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

