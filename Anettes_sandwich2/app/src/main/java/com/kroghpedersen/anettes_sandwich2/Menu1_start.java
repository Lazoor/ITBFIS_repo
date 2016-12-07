package com.kroghpedersen.anettes_sandwich2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Menu1_start extends AppCompatActivity {

    private Button StartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu1_start);

        // set text font
        StartButton = (Button) findViewById(R.id.menu1_btn_start);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Roboto-Bold.ttf");
        StartButton.setTypeface(font);


        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Menu2_choice.class);
                startActivity(myIntent);
                //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);  // Disabled, doesn't work
            }

        });
    }
}
