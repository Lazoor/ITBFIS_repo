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

public class Menu9_paymentpick extends AppCompatActivity {

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

        setContentView(R.layout.activity_menu9_paymentpick);


        choiceObjList = new ArrayList<ChoiceObj>();

        // Set list with valid choices
        choiceObjList.add(new ChoiceObj("Kredit Kort", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.creditcards)));
        choiceObjList.add(new ChoiceObj("Kontant", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kontant)));
        choiceObjList.add(new ChoiceObj("Vouchers", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.voucher)));
        //choiceObjList.add(new ChoiceObj("MobilePay", BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.mobile_pay)));

        lw = (ListView) findViewById(R.id.menu9_choice_lw);
        RandomAdapter RA = new RandomAdapter(getApplicationContext(),choiceObjList);

        lw.setAdapter(RA);


        // set text font
        title_tv = (TextView) findViewById(R.id.menu9_title_tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        title_tv.setTypeface(font);


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), Menu1_start.class);
                startActivity(nextStepIntent);
            }
        });

        // Back button
        back_btn = (FloatingActionButton) findViewById(R.id.menu9_paymentpick_fab);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

