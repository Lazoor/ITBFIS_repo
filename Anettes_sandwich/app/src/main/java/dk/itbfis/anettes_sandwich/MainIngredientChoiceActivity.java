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

public class MainIngredientChoiceActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView sandwichListview;
    List<ButtonObject> buttonObjects;
    Bitmap sandwichIcon;
    FloatingActionButton BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ingredient_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.kylling);
        ButtonObject chicken = new ButtonObject(sandwichIcon, "Kylling", "...");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.aeg);
        ButtonObject egg = new ButtonObject(sandwichIcon, "Æg", "...");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.laks);
        ButtonObject salmon = new ButtonObject(sandwichIcon, "Laks", "...");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.rejer);
        ButtonObject shrimp = new ButtonObject(sandwichIcon, "Rejer", "...");

        buttonObjects.add(chicken);
        buttonObjects.add(egg);
        buttonObjects.add(salmon);
        buttonObjects.add(shrimp);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        sandwichListview = (ListView) findViewById(R.id.sandwich_listview);

        sandwichListview.setAdapter(buttonAdapter);

        sandwichListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), SidesChoiceActivity.class);
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
