package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DrinkChoiceActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView drinkListview;
    List<ButtonObject> buttonObjects;
    Bitmap drinkIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        drinkIcon = BitmapFactory.decodeResource(getResources(), R.drawable.vand);
        ButtonObject water = new ButtonObject(drinkIcon, "Vand", "...");

        drinkIcon = BitmapFactory.decodeResource(getResources(), R.drawable.kaffe);
        ButtonObject coffee = new ButtonObject(drinkIcon, "Kaffe", "...");

        drinkIcon = BitmapFactory.decodeResource(getResources(), R.drawable.juice);
        ButtonObject juice = new ButtonObject(drinkIcon, "Juice", "...");

        drinkIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ingendrink);
        ButtonObject noDrink = new ButtonObject(drinkIcon, "Ingen Drikkevare", "...");

        buttonObjects.add(water);
        buttonObjects.add(coffee);
        buttonObjects.add(juice);
        buttonObjects.add(noDrink);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        drinkListview = (ListView) findViewById(R.id.drink_listview);

        drinkListview.setAdapter(buttonAdapter);

        drinkListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), shoppingCartActivity.class);
                startActivity(nextStepIntent);
            }
        });
    }


}
