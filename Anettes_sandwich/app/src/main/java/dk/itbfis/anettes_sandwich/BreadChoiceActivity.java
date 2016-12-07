package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BreadChoiceActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView breadListview;
    List<ButtonObject> buttonObjects;
    Bitmap sandwichIcon;
    FloatingActionButton BackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.focaccia);
        ButtonObject focaccia = new ButtonObject(sandwichIcon, "Focaccia", "Klassisk lyst brød.");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.grov);
        ButtonObject classicDark = new ButtonObject(sandwichIcon, "Klassisk Mørk", "Grov brød");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.protein);
        ButtonObject protein = new ButtonObject(sandwichIcon, "Protein", "Brød fyldt med proteiner for personen i træning");

        buttonObjects.add(focaccia);
        buttonObjects.add(classicDark);
        buttonObjects.add(protein);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        breadListview = (ListView) findViewById(R.id.sandwich_listview);

        breadListview.setAdapter(buttonAdapter);

        breadListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), MainIngredientChoiceActivity.class);
                startActivity(nextStepIntent);
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
