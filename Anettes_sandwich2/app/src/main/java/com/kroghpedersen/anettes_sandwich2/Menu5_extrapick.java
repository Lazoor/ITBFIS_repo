package com.kroghpedersen.anettes_sandwich2;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.kroghpedersen.anettes_sandwich2.R.id.view;

public class Menu5_extrapick extends AppCompatActivity {

    ListView lw;
    List<ChoiceObj> choiceObjList;

    FloatingActionButton back_btn;
    FloatingActionButton next_btn;
    TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu5_extrapick);

        choiceObjList = new ArrayList<ChoiceObj>();

        // Set list with valid choices
        choiceObjList.add(new ChoiceObj("Salat", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.salat)));
        choiceObjList.add(new ChoiceObj("Gulerod", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.gulerod)));
        choiceObjList.add(new ChoiceObj("Tomat", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tomat)));


        lw = (ListView) findViewById(R.id.menu5_choice_lw);
        RandomAdapterExtrapick RA = new RandomAdapterExtrapick(getApplicationContext(),choiceObjList);

        lw.setAdapter(RA);


        // set text font
        title_tv = (TextView) findViewById(R.id.menu5_title_tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        title_tv.setTypeface(font);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent nextStepIntent = new Intent(view.getContext(), Menu6_dressingpick.class);
                //startActivity(nextStepIntent);
            }
        });

        // Back button
        back_btn = (FloatingActionButton) findViewById(R.id.menu5_extrapick_back_fab);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Next button
        next_btn = (FloatingActionButton) findViewById(R.id.menu5_extrapick_next_fab);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextStepIntent = new Intent(getApplicationContext(), Menu6_dressingpick.class);
                startActivity(nextStepIntent);
            }
        });


    }
}
