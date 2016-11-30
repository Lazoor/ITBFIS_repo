package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SandwichChoiceActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView sandwichListview;
    List<ButtonObject> buttonObjects;
    Bitmap sandwichIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.aegogrejer);
        ButtonObject bygSelv = new ButtonObject(sandwichIcon, "Byg Selv", "Lav din egen sandwich, med det som du har lyst til.");

        sandwichIcon = BitmapFactory.decodeResource(getResources(), R.drawable.kyllingogbacon);
        ButtonObject kyllingBacon = new ButtonObject(sandwichIcon, "Kylling & bacon", "Klassisk Kylling & Bacon Sandwich");

        buttonObjects.add(bygSelv);
        buttonObjects.add(kyllingBacon);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        sandwichListview = (ListView) findViewById(R.id.sandwich_listview);

        sandwichListview.setAdapter(buttonAdapter);

        sandwichListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), BreadChoiceActivity.class);
                startActivity(nextStepIntent);
            }
        });
    }


}
