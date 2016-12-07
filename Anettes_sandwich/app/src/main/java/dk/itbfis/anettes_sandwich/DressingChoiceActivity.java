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

public class DressingChoiceActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView dressingListview;
    List<ButtonObject> buttonObjects;
    Bitmap dressingIcon;
    FloatingActionButton BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dressing_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        dressingIcon = BitmapFactory.decodeResource(getResources(), R.drawable.mayo);
        ButtonObject mayonnaise = new ButtonObject(dressingIcon, "Mayonnaise", "...");

        dressingIcon = BitmapFactory.decodeResource(getResources(), R.drawable.karry);
        ButtonObject curry = new ButtonObject(dressingIcon, "Karry", "...");

        dressingIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ketchup);
        ButtonObject ketchup = new ButtonObject(dressingIcon, "Ketchup", "...");

        dressingIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ingendressing);
        ButtonObject noDressing = new ButtonObject(dressingIcon, "Ingen Dressing", "...");

        buttonObjects.add(mayonnaise);
        buttonObjects.add(curry);
        buttonObjects.add(ketchup);
        buttonObjects.add(noDressing);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        dressingListview = (ListView) findViewById(R.id.dressing_listview);

        dressingListview.setAdapter(buttonAdapter);

        dressingListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), DrinkChoiceActivity.class);
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
