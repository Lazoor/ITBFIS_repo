package dk.itbfis.anettes_sandwich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;


public class SandwichChoiceActivity extends AppCompatActivity {

    ListView sandwichListview;
    List<ButtonObject> buttonObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich_choice);

        sandwichListview = (ListView) findViewById(R.id.sandwich_listview);


    }

}
