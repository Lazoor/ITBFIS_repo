package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides_choice);

        nextButton = (Button) findViewById(R.id.next_btn);

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

        nextButton.setOnClickListener(new View.OnClickListener() {
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

    }
}