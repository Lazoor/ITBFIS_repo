package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SidesChoiceActivity extends AppCompatActivity {

    CheckboxAdapter checkboxAdapter;
    ListView sidesListview;
    List<CheckboxObject> checkboxObjects;
    Bitmap sidesIcon;
    FloatingActionButton BackButton, NextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides_choice);

        NextButton = (FloatingActionButton) findViewById(R.id.fab_next);

        checkboxObjects = new ArrayList<CheckboxObject>();

        sidesIcon = BitmapFactory.decodeResource(getResources(), R.drawable.salat);
        CheckboxObject salat = new CheckboxObject(sidesIcon, "Salat", "...");

        sidesIcon = BitmapFactory.decodeResource(getResources(), R.drawable.gulerod);
        CheckboxObject gulerod = new CheckboxObject(sidesIcon, "Gulerod", "...");

        sidesIcon = BitmapFactory.decodeResource(getResources(), R.drawable.tomat);
        CheckboxObject tomat = new CheckboxObject(sidesIcon, "Tomat", "...");

        checkboxObjects.add(salat);
        checkboxObjects.add(gulerod);
        checkboxObjects.add(tomat);


        checkboxAdapter = new CheckboxAdapter(getApplicationContext(), checkboxObjects);

        sidesListview = (ListView) findViewById(R.id.sides_listview);

        sidesListview.setAdapter(checkboxAdapter);

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextStepIntent = new Intent(v.getContext(), DressingChoiceActivity.class);
                startActivity(nextStepIntent);
            }
        });

        sidesListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        BackButton = (FloatingActionButton) findViewById(R.id.fab_back);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}