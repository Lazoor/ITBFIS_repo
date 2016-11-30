package com.kroghpedersen.anettes_sandwich2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
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

public class menu3_breadpick extends AppCompatActivity {

    ListView lw;
    List<ChoiceObj> choiceObjList;

    TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu3_breadpick);


        choiceObjList = new ArrayList<ChoiceObj>();

        // Set list with valid choices
        choiceObjList.add(new ChoiceObj("Klassisk mørk", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.stadard)));
        choiceObjList.add(new ChoiceObj("Focaccia", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.stadard)));
        choiceObjList.add(new ChoiceObj("Protein", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.stadard)));


        lw = (ListView) findViewById(R.id.menu3_choice_lw);
        RandomAdapter RA = new RandomAdapter(getApplicationContext(),choiceObjList);

        lw.setAdapter(RA);


        // set text font
        title_tv = (TextView) findViewById(R.id.menu3_title_tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        title_tv.setTypeface(font);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), Menu4_meatpick.class);
                startActivity(nextStepIntent);
            }
        });


    }
}
